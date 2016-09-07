package org.bubblecloud.zigbee.v3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

import org.bubblecloud.zigbee.util.ZigBeeConstants;
import org.bubblecloud.zigbee.v3.model.ZToolAddress16;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.ZclCustomResponseMatcher;
import org.bubblecloud.zigbee.v3.zcl.ZclResponseMatcher;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ConfigureReportingCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ReadAttributesCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.WriteAttributesCommand;
import org.bubblecloud.zigbee.v3.zcl.field.AttributeIdentifier;
import org.bubblecloud.zigbee.v3.zcl.field.AttributeReportingConfigurationRecord;
import org.bubblecloud.zigbee.v3.zcl.field.WriteAttributeRecord;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclAttributeType;
import org.bubblecloud.zigbee.v3.zdo.ZdoResponseMatcher;
import org.bubblecloud.zigbee.v3.zdo.command.BindRequest;
import org.bubblecloud.zigbee.v3.zdo.command.ManagementPermitJoinRequest;
import org.bubblecloud.zigbee.v3.zdo.command.UnbindRequest;

/**
 * Implements functions for managing the ZigBee interface
 * 
 * @author Chris Jackson
 */
public class ZigBeeNetworkManager implements ZigBeeNetwork {
    /**
     * The dongle implementation.
     */
    private final ZigBeeTransport dongle;

    /**
     * The ZigBee network networkDiscoverer.
     */
    private final ZigBeeNetworkDiscoverer networkDiscoverer;

    /**
     * The network state.
     */
    private ZigBeeNetworkStateImpl networkState;

    ZigBeeNetwork zigbeeNetwork;

    /**
     * The command listener creation times.
     */
    private final Set<CommandExecution> commandExecutions = new HashSet<CommandExecution>();

    /**
     * The command listeners.
     */
    private List<CommandListener> commandListeners = new ArrayList<CommandListener>();

    /**
     * Constructor which configures serial port and ZigBee network.
     * 
     * @param dongle
     *            the dongle
     * @param resetNetwork
     *            whether network is to be reset
     */
    public ZigBeeNetworkManager(final ZigBeeTransport dongle, final boolean resetNetwork) {
        this.dongle = dongle;
        this.networkState = new ZigBeeNetworkStateImpl(resetNetwork);
        this.networkDiscoverer = new ZigBeeNetworkDiscoverer(networkState, this);

        // setNetwork(dongle);

        dongle.setZigBeeNetwork(this);
        // setNetworkState(networkState);
    }

    /**
     * Starts up ZigBee manager components.
     * 
     * @return TRUE if startup was successful.
     */
    public boolean startup() {
        networkState.startup();
        if (dongle.startup()) {
            networkDiscoverer.startup();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Shuts down ZigBee manager components.
     */
    public void shutdown() {
        networkDiscoverer.shutdown();
        dongle.shutdown();
        networkState.shutdown();
    }

    @Override
    public int sendCommand(Command command) throws ZigBeeException {
        return dongle.sendCommand(command);
    }

    @Override
    public void addCommandListener(CommandListener commandListener) {
        final List<CommandListener> modifiedCommandListeners = new ArrayList<CommandListener>(commandListeners);
        modifiedCommandListeners.add(commandListener);
        commandListeners = Collections.unmodifiableList(modifiedCommandListeners);
    }

    @Override
    public void removeCommandListener(CommandListener commandListener) {
        final List<CommandListener> modifiedCommandListeners = new ArrayList<CommandListener>(commandListeners);
        modifiedCommandListeners.remove(commandListener);
        commandListeners = Collections.unmodifiableList(modifiedCommandListeners);
    }

    @Override
    public void receiveCommand(Command command) {
        for (final CommandListener commandListener : commandListeners) {
            commandListener.commandReceived(command);
        }
    }

    @Override
    public void setZigBeeNetwork(ZigBeeNetwork zigbeeNetwork) {
        this.zigbeeNetwork = zigbeeNetwork;
    }

    /**
     * Sets device label.
     * 
     * @param networkAddress
     *            the network address
     * @param endPointId
     *            the end point ID
     * @param label
     *            the label
     */
    public void setDeviceLabel(final int networkAddress, final int endPointId, final String label) {
        final ZigBeeDevice device = networkState.getDevice(new ZigBeeDeviceAddress(networkAddress, endPointId));
        device.setLabel(label);
        networkState.updateDevice(device);
    }

    /**
     * Removes device(s) by network address.
     * 
     * @param networkAddress
     *            the network address
     */
    public void removeDevice(final int networkAddress) {
        final List<ZigBeeDevice> devices = networkState.getDevices();
        final List<ZigBeeDevice> devicesToRemove = new ArrayList<ZigBeeDevice>();
        for (final ZigBeeDevice device : devices) {
            if (device.getNetworkAddress() == networkAddress) {
                devicesToRemove.add(device);
            }
        }

        for (final ZigBeeDevice device : devicesToRemove) {
            networkState.removeDevice(device.getNetworkAddress(), device.getEndpoint());
        }
    }

    /**
     * Gets ZigBee devices.
     * 
     * @return list of ZigBee devices
     */
    public List<ZigBeeDevice> getDevices() {
        return networkState.getDevices();
    }

    /**
     * Gets a single ZigBee device
     * 
     * @param address
     *            {@link ZigBeeDeviceAddress}
     * @return the {@link ZigBeeDevice}
     */
    public ZigBeeDevice getDevice(ZigBeeDeviceAddress address) {
        return networkState.getDevice(address);
    }

    /**
     * Sets group label.
     * 
     * @param groupId
     *            the group ID
     * @param label
     *            the label
     */
    public void addMembership(final int groupId, final String label) {
        if (networkState.getGroup(groupId) == null) {
            networkState.addGroup(new ZigBeeGroupAddress(groupId, label));
        } else {
            final ZigBeeGroupAddress group = networkState.getGroup(groupId);
            group.setLabel(label);
            networkState.updateGroup(group);
        }
    }

    /**
     * Removes group label.
     * 
     * @param groupId
     *            the group ID
     */
    public void removeMembership(final int groupId) {
        networkState.removeGroup(groupId);
    }

    /**
     * Gets group by network address.
     * 
     * @param groupId
     *            the group ID
     * @return the ZigBee group or null if no exists with given group ID.
     */
    public ZigBeeGroupAddress getGroup(final int groupId) {
        return networkState.getGroup(groupId);
    }

    /**
     * Gets all groups.
     * 
     * @return list of groups.
     */
    public List<ZigBeeGroupAddress> getGroups() {
        return networkState.getGroups();
    }

    public ZigBeeNetworkState getNetworkState() {
        return networkState;
    }

    /**
     * Sends command to {@link ZigBeeAddress}.
     * 
     * @param destination
     *            the destination
     * @param command
     *            the command
     * @return the command result future
     */
    Future<CommandResult> send(ZigBeeAddress destination, ZclCommand command) {
        command.setDestinationAddress(destination);
        if (destination.isGroup()) {
            return broadcast(command);
        } else {
            return unicast(command);
        }
    }

    /**
     * Sends command.
     * 
     * @param command
     *            the command
     * @return the command result future.
     */
    public Future<CommandResult> unicast(final Command command) {

        final CommandResponseMatcher responseMatcher;
        if (command instanceof ZclCommand) {
            responseMatcher = new ZclResponseMatcher();
        } else {
            responseMatcher = new ZdoResponseMatcher();
        }

        return unicast(command, responseMatcher);
    }

    /**
     * Sends ZCL command.
     * 
     * @param command
     *            the command
     * @param responseMatcher
     *            the response matcher.
     * @return the command result future.
     */
    Future<CommandResult> unicast(final Command command, final CommandResponseMatcher responseMatcher) {
        synchronized (command) {
            final CommandResultFuture future = new CommandResultFuture(this);
            final CommandExecution commandExecution = new CommandExecution(System.currentTimeMillis(), command, future);
            future.setCommandExecution(commandExecution);
            final CommandListener commandListener = new CommandListener() {
                @Override
                public void commandReceived(Command receivedCommand) {
                    // Ensure that received command is not processed before
                    // command is sent and
                    // hence transaction ID for the command set.
                    synchronized (command) {
                        if (responseMatcher.isMatch(command, receivedCommand)) {
                            synchronized (future) {
                                future.set(new CommandResult(receivedCommand));
                                synchronized (future) {
                                    future.notify();
                                }
                                removeCommandExecution(commandExecution);
                            }
                        }
                    }
                }
            };
            commandExecution.setCommandListener(commandListener);
            addCommandExecution(commandExecution);
            try {
                int transactionId = sendCommand(command);
                if (command instanceof ZclCommand) {
                    ((ZclCommand) command).setTransactionId((byte) transactionId);
                }
            } catch (final ZigBeeException e) {
                future.set(new CommandResult(e.toString()));
                removeCommandExecution(commandExecution);
            }
            return future;
        }
    }

    /**
     * Broadcasts command i.e. does not wait for response.
     * 
     * @param command
     *            the command
     * @return the command result future.
     */
    private Future<CommandResult> broadcast(final Command command) {
        synchronized (command) {
            final CommandResultFuture future = new CommandResultFuture(this);

            try {
                sendCommand(command);
                future.set(new CommandResult(new BroadcastResponse()));
            } catch (final ZigBeeException e) {
                future.set(new CommandResult(e.toString()));
            }

            return future;
        }
    }

    /**
     * Adds command listener and removes expired command listeners.
     *
     * @param commandExecution
     *            the command execution
     */
    private void addCommandExecution(final CommandExecution commandExecution) {
        synchronized (commandExecutions) {
            final List<CommandExecution> expiredCommandExecutions = new ArrayList<CommandExecution>();
            for (final CommandExecution existingCommandExecution : commandExecutions) {
                if (System.currentTimeMillis() - existingCommandExecution.getStartTime() > 8000) {
                    expiredCommandExecutions.add(existingCommandExecution);
                }
            }
            for (final CommandExecution expiredCommandExecution : expiredCommandExecutions) {
                ((CommandResultFuture) expiredCommandExecution.getFuture()).set(new CommandResult());
                removeCommandExecution(expiredCommandExecution);
            }
            commandExecutions.add(commandExecution);
            addCommandListener(commandExecution.getCommandListener());
        }
    }

    /**
     * Removes command execution.
     * 
     * @param expiredCommandExecution
     *            the command execution
     */
    protected void removeCommandExecution(CommandExecution expiredCommandExecution) {
        commandExecutions.remove(expiredCommandExecution);
        removeCommandListener(expiredCommandExecution.getCommandListener());
        synchronized (expiredCommandExecution.getFuture()) {
            expiredCommandExecution.getFuture().notify();
        }
    }

    public void permitJoin(final boolean enable) {

        final ManagementPermitJoinRequest command = new ManagementPermitJoinRequest();

        if (enable) {
            command.setDuration(0xFF);
        } else {
            command.setDuration(0);
        }

        command.setAddressingMode(ZigBeeConstants.BROADCAST_ADDRESS);
        command.setDestinationAddress(ZToolAddress16.ZCZR_BROADCAST.get16BitValue());
        command.setTrustCenterSignificance(1);

        try {
            sendCommand(command);
        } catch (final ZigBeeException e) {
            throw new ZigBeeApiException("Error sending permit join command.", e);
        }
    }

    /**
     * Binds two devices.
     * 
     * @param source
     *            the source device
     * @param destination
     *            the destination device
     * @param clusterId
     *            the cluster ID
     * @return TRUE if no errors occurred in sending.
     */
    public Future<CommandResult> bind(final ZigBeeDevice source, final ZigBeeDevice destination, final int clusterId) {
        final int destinationAddress = source.getNetworkAddress();
        final IeeeAddress bindSourceAddress = source.getIeeeAddress();
        final int bindSourceEndpoint = source.getEndpoint();
        final int bindCluster = clusterId;
        final int bindDestinationAddressingMode = 3; // 64 bit addressing
        final IeeeAddress bindDestinationAddress = destination.getIeeeAddress();
        final int bindDestinationEndpoint = destination.getEndpoint();
        final BindRequest command = new BindRequest(destinationAddress, bindSourceAddress.getLong(),
                bindSourceEndpoint, bindCluster, bindDestinationAddressingMode, bindDestinationAddress.getLong(),
                bindDestinationEndpoint);
        return unicast(command);
    }

    /**
     * Unbinds two devices.
     * 
     * @param source
     *            the source device
     * @param destination
     *            the destination device
     * @param clusterId
     *            the cluster ID
     * @return TRUE if no errors occurred in sending.
     */
    public Future<CommandResult> unbind(final ZigBeeDevice source, final ZigBeeDevice destination, final int clusterId) {
        final int destinationAddress = source.getNetworkAddress();
        final IeeeAddress bindSourceAddress = source.getIeeeAddress();
        final int bindSourceEndpoint = source.getEndpoint();
        final int bindCluster = clusterId;
        final int bindDestinationAddressingMode = 3; // 64 bit addressing
        final IeeeAddress bindDestinationAddress = destination.getIeeeAddress();
        final int bindDestinationEndpoint = destination.getEndpoint();
        final UnbindRequest command = new UnbindRequest(destinationAddress, bindSourceAddress.getLong(),
                bindSourceEndpoint, bindCluster, bindDestinationAddressingMode, bindDestinationAddress.getLong(),
                bindDestinationEndpoint);
        return unicast(command);
    }

    /**
     * Writes attribute to device.
     * 
     * @param zigbeeAddress
     *            the device
     * @param clusterId
     *            the cluster ID
     * @param attributeId
     *            the attribute ID
     * @param value
     *            the value
     * @return the command result future
     */
    public Future<CommandResult> write(final ZigBeeDeviceAddress zigbeeAddress, final int clusterId,
            final int attributeId, final Object value) {

        final WriteAttributesCommand command = new WriteAttributesCommand();
        command.setClusterId(clusterId);

        final WriteAttributeRecord record = new WriteAttributeRecord();
        record.setAttributeIdentifier(attributeId);
        record.setAttributeDataType(ZclAttributeType.get(clusterId, attributeId).getZigBeeType().getId());
        record.setAttributeValue(value);
        command.setRecords(Collections.singletonList(record));

        command.setDestinationAddress(zigbeeAddress);
        // command.setDestinationAddress(device.getNetworkAddress());
        // command.setDestinationEndpoint(device.getEndpoint());

        return unicast(command, new ZclCustomResponseMatcher());
    }

    /**
     * Reads attribute from device.
     * 
     * @param zigbeeAddress
     *            the device
     * @param clusterId
     *            the cluster ID
     * @param attributeId
     *            the attribute ID
     * @return the command result future
     */
    public Future<CommandResult> read(final ZigBeeDeviceAddress zigbeeAddress, final int clusterId,
            final int attributeId) {
        final ReadAttributesCommand command = new ReadAttributesCommand();

        command.setClusterId(clusterId);
        final AttributeIdentifier attributeIdentifier = new AttributeIdentifier();
        attributeIdentifier.setAttributeIdentifier(attributeId);
        command.setIdentifiers(Collections.singletonList(attributeIdentifier));

        command.setDestinationAddress(zigbeeAddress);

        return unicast(command, new ZclCustomResponseMatcher());
    }

    /**
     * Configures attribute reporting.
     * 
     * @param zigbeeAddress
     *            the device
     * @param clusterId
     *            the cluster ID
     * @param attributeId
     *            the attribute ID
     * @param minInterval
     *            the minimum interval
     * @param maxInterval
     *            the maximum interval
     * @param reportableChange
     *            the reportable change
     * @return the command result future
     */
    public Future<CommandResult> report(final ZigBeeDeviceAddress zigbeeAddress, final int clusterId,
            final int attributeId, final int minInterval, final int maxInterval, final Object reportableChange) {
        final ConfigureReportingCommand command = new ConfigureReportingCommand();

        command.setClusterId(clusterId);

        final AttributeReportingConfigurationRecord record = new AttributeReportingConfigurationRecord();
        record.setDirection(0);
        record.setAttributeIdentifier(attributeId);
        record.setAttributeDataType(ZclAttributeType.get(clusterId, attributeId).getZigBeeType().getId());
        record.setMinimumReportingInterval(minInterval);
        record.setMinimumReportingInterval(maxInterval);
        record.setReportableChange(reportableChange);
        record.setTimeoutPeriod(0);
        command.setRecords(Collections.singletonList(record));

        command.setDestinationAddress(zigbeeAddress);

        return unicast(command, new ZclCustomResponseMatcher());
    }

}
