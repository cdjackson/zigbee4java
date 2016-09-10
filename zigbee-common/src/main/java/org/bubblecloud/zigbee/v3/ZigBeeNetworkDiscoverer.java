package org.bubblecloud.zigbee.v3;

import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zdo.command.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * ZigBee network discoverer is used to discover devices in the network. This
 * class is thread safe.
 */
public class ZigBeeNetworkDiscoverer implements CommandListener {
    /**
     * The logger.
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ZigBeeNetworkDiscoverer.class);
    /**
     * Minimum time before information can be queried again for same network
     * address or endpoint.
     */
    private static final int MINIMUM_REQUERY_TIME_MILLIS = 10000;
    /**
     * The ZigBee network state.
     */
    private ZigBeeNetworkState networkState;
    /**
     * The ZigBee command interface.
     */
    private ZigBeeNetworkManager networkManager;
    /**
     * The received IEEE addresses.
     */
    private Map<Integer, IeeeAddressResponse> ieeeAddresses = Collections
            .synchronizedMap(new HashMap<Integer, IeeeAddressResponse>());
    /**
     * The received node descriptors.
     */
    private Map<Integer, NodeDescriptorResponse> nodeDescriptors = Collections
            .synchronizedMap(new HashMap<Integer, NodeDescriptorResponse>());
    /**
     * The received power descriptors.
     */
    private Map<Integer, PowerDescriptorResponse> powerDescriptors = Collections
            .synchronizedMap(new HashMap<Integer, PowerDescriptorResponse>());
    /**
     * Map of IEEE address request times.
     */
    final Map<Integer, Long> ieeeAddressRequestTimes = Collections.synchronizedMap(new HashMap<Integer, Long>());
    /**
     * Map of node descriptor request times.
     */
    final Map<Integer, Long> nodeDescriptorRequestTimes = Collections.synchronizedMap(new HashMap<Integer, Long>());
    /**
     * Map of power descriptor request times.
     */
    final Map<Integer, Long> powerDescriptorRequestTimes = Collections.synchronizedMap(new HashMap<Integer, Long>());
    /**
     * Map of active endpoints request times.
     */
    final Map<Integer, Long> activeEndpointsRequestTimes = Collections.synchronizedMap(new HashMap<Integer, Long>());
    /**
     * Map of endpoint descriptor request times.
     */
    final Map<String, Long> endpointDescriptorRequestTimes = Collections.synchronizedMap(new HashMap<String, Long>());

    /**
     * Discovers ZigBee network state.
     * 
     * @param networkState
     *            the network state
     * @param dongle
     *            the command interface
     */
    public ZigBeeNetworkDiscoverer(final ZigBeeNetworkState networkState, final ZigBeeNetworkManager networkManager) {
        this.networkState = networkState;
        this.networkManager = networkManager;
    }

    /**
     * Starts up ZigBee network discoverer.
     */
    public void startup() {
        networkManager.addCommandListener(this);
        // Start discovery from root node.
        requestNodeIeeeAddressAndAssociatedNodes(0);
    }

    /**
     * Shuts down ZigBee network discoverer.
     */
    public void shutdown() {
        networkManager.removeCommandListener(this);
    }

    @Override
    public void commandReceived(final Command command) {
        LOGGER.info("Received: " + command);

        // 0. ZCL command received from remote node. Request IEEE address if it
        // is not yet known.
        if (command instanceof ZclCommand) {
            final ZclCommand zclCommand = (ZclCommand) command;
            if (networkState.getDevice(zclCommand.getSourceAddress()) == null) {
                // TODO: Protect against group address?
                ZigBeeDeviceAddress address = (ZigBeeDeviceAddress) zclCommand.getSourceAddress();
                requestNodeIeeeAddressAndAssociatedNodes(address.getAddress());
            }
        }

        // 0. Node has been announced.
        if (command instanceof DeviceAnnounce) {
            final DeviceAnnounce deviceAnnounce = (DeviceAnnounce) command;
            requestNodeIeeeAddressAndAssociatedNodes(deviceAnnounce.getNetworkAddress());
        }

        // 1. Node IEEE address and associated nodes have been received.
        if (command instanceof IeeeAddressResponse) {
            final IeeeAddressResponse ieeeAddressResponse = (IeeeAddressResponse) command;

            if (ieeeAddressResponse.getStatus() == 0) {
                ieeeAddresses.put(ieeeAddressResponse.getNetworkAddress(), ieeeAddressResponse);
                describeNode(ieeeAddressResponse.getNetworkAddress());

                for (final int networkAddress : ieeeAddressResponse.associatedDeviceList) {
                    requestNodeIeeeAddressAndAssociatedNodes(networkAddress);
                }
            } else {
                LOGGER.warn(ieeeAddressResponse.toString());
            }
        }

        // 2. Node has been described.
        if (command instanceof NodeDescriptorResponse) {
            final NodeDescriptorResponse nodeDescriptorResponse = (NodeDescriptorResponse) command;

            if (nodeDescriptorResponse.getStatus() == 0) {
                // Create the node

                nodeDescriptors.put(nodeDescriptorResponse.getNetworkAddress(), nodeDescriptorResponse);
                requestPowerDescriptor(nodeDescriptorResponse.getNetworkAddress());
            } else {
                LOGGER.warn(nodeDescriptorResponse.toString());
            }
        }

        // 3. Node power descriptor has been received
        if (command instanceof PowerDescriptorResponse) {
            final PowerDescriptorResponse powerDescriptorResponse = (PowerDescriptorResponse) command;

            if (powerDescriptorResponse.getStatus() == 0) {
                powerDescriptors.put(powerDescriptorResponse.getSourceAddress(), powerDescriptorResponse);

                final int networkAddress = powerDescriptorResponse.getSourceAddress();
                final IeeeAddressResponse ieeeAddressResponse = ieeeAddresses.get(networkAddress);
                final NodeDescriptorResponse nodeDescriptorResponse = nodeDescriptors.get(networkAddress);

                addOrUpdateNode(ieeeAddressResponse, nodeDescriptorResponse, powerDescriptorResponse);

                requestNodeEndpoints(nodeDescriptorResponse.getNetworkAddress());
            } else {
                LOGGER.warn(powerDescriptorResponse.toString());
            }
        }

        // 4. Endpoints have been received.
        if (command instanceof ActiveEndpointsResponse) {
            final ActiveEndpointsResponse activeEndpointsResponse = (ActiveEndpointsResponse) command;
            if (activeEndpointsResponse.getStatus() == 0) {
                for (final int endpoint : activeEndpointsResponse.getActiveEndpoints()) {
                    int networkAddress = activeEndpointsResponse.getNetworkAddress();
                    describeEndpoint(networkAddress, endpoint);
                }
            } else {
                LOGGER.warn(activeEndpointsResponse.toString());
            }
        }

        // 5. Endpoint is described.
        if (command instanceof SimpleDescriptorResponse) {
            final SimpleDescriptorResponse simpleDescriptorResponse = (SimpleDescriptorResponse) command;
            if (simpleDescriptorResponse.getStatus() == 0) {
                final int networkAddress = simpleDescriptorResponse.getNetworkAddress();
                final IeeeAddressResponse ieeeAddressResponse = ieeeAddresses.get(networkAddress);
                final NodeDescriptorResponse nodeDescriptorResponse = nodeDescriptors.get(networkAddress);

                if (ieeeAddressResponse == null || nodeDescriptorResponse == null) {
                    return;
                }

                addOrUpdateDevice(ieeeAddressResponse, nodeDescriptorResponse, simpleDescriptorResponse);
            } else {
                LOGGER.warn(simpleDescriptorResponse.toString());
            }
        }

        // 6. Endpoint user descriptor is received.
        if (command instanceof UserDescriptorResponse) {
            final UserDescriptorResponse userDescriptorResponse = (UserDescriptorResponse) command;
            LOGGER.info("Received user descriptor response: " + userDescriptorResponse);
        }
    }

    /**
     * Requests node IEEE address and associated nodes.
     * 
     * @param networkAddress
     *            the network address
     */
    private void requestNodeIeeeAddressAndAssociatedNodes(final int networkAddress) {
        if (ieeeAddressRequestTimes.get(networkAddress) != null
                && System.currentTimeMillis() - ieeeAddressRequestTimes.get(networkAddress) < MINIMUM_REQUERY_TIME_MILLIS) {
            return;
        }
        ieeeAddressRequestTimes.put(networkAddress, System.currentTimeMillis());

        try {
            final IeeeAddressRequest ieeeAddressRequest = new IeeeAddressRequest(networkAddress, 1, 0);
            networkManager.sendCommand(ieeeAddressRequest);
        } catch (ZigBeeException e) {
            LOGGER.error("Error sending discovery command.", e);
        }
    }

    /**
     * Describe node at given network address.
     * 
     * @param networkAddress
     *            the network address
     */
    private void describeNode(final int networkAddress) {
        if (nodeDescriptorRequestTimes.get(networkAddress) != null
                && System.currentTimeMillis() - nodeDescriptorRequestTimes.get(networkAddress) < MINIMUM_REQUERY_TIME_MILLIS) {
            return;
        }
        nodeDescriptorRequestTimes.put(networkAddress, System.currentTimeMillis());

        try {
            final NodeDescriptorRequest nodeDescriptorRequest = new NodeDescriptorRequest(networkAddress,
                    networkAddress);
            networkManager.sendCommand(nodeDescriptorRequest);
        } catch (ZigBeeException e) {
            LOGGER.error("Error sending discovery command.", e);
        }
    }

    private void requestPowerDescriptor(final int networkAddress) {
        // if (nodeDescriptorRequestTimes.get(networkAddress) != null
        // && System.currentTimeMillis() -
        // nodeDescriptorRequestTimes.get(networkAddress) <
        // MINIMUM_REQUERY_TIME_MILLIS) {
        // return;
        // }
        // nodeDescriptorRequestTimes.put(networkAddress,
        // System.currentTimeMillis());

        try {
            final PowerDescriptorRequest powerDescriptorRequest = new PowerDescriptorRequest(networkAddress,
                    networkAddress);
            networkManager.sendCommand(powerDescriptorRequest);
        } catch (ZigBeeException e) {
            LOGGER.error("Error sending discovery command.", e);
        }
    }

    /**
     * Discover node endpoints.
     * 
     * @param networkAddress
     *            the network address
     */
    private void requestNodeEndpoints(final int networkAddress) {
        if (activeEndpointsRequestTimes.get(networkAddress) != null
                && System.currentTimeMillis() - activeEndpointsRequestTimes.get(networkAddress) < MINIMUM_REQUERY_TIME_MILLIS) {
            return;
        }
        activeEndpointsRequestTimes.put(networkAddress, System.currentTimeMillis());

        try {
            final ActiveEndpointsRequest activeEndpointsRequest = new ActiveEndpointsRequest();
            activeEndpointsRequest.setDestinationAddress(networkAddress);
            activeEndpointsRequest.setNetworkAddressOfInterest(networkAddress);
            networkManager.sendCommand(activeEndpointsRequest);
        } catch (ZigBeeException e) {
            LOGGER.error("Error sending discovery command.", e);
        }
    }

    /**
     * Describe node endpoint
     * 
     * @param networkAddress
     *            the network address
     * @param endpoint
     *            the endpoint
     */
    private void describeEndpoint(final int networkAddress, final int endpoint) {
        final String deviceIdentifier = networkAddress + "/" + endpoint;
        if (endpointDescriptorRequestTimes.get(deviceIdentifier) != null
                && System.currentTimeMillis() - endpointDescriptorRequestTimes.get(deviceIdentifier) < MINIMUM_REQUERY_TIME_MILLIS) {
            return;
        }
        endpointDescriptorRequestTimes.put(deviceIdentifier, System.currentTimeMillis());
        try {
            final SimpleDescriptorRequest request = new SimpleDescriptorRequest();
            request.setDestinationAddress(networkAddress);
            request.setEndpoint(endpoint);
            networkManager.sendCommand(request);
        } catch (ZigBeeException e) {
            LOGGER.error("Error sending discovery command.", e);
        }
    }

    private void addOrUpdateNode(final IeeeAddressResponse ieeeAddressResponse,
            final NodeDescriptorResponse nodeDescriptorResponse, final PowerDescriptorResponse powerDescriptorResponse) {
        final ZigBeeNode node;
        final boolean newDevice = networkState.getNode(ieeeAddressResponse.getNetworkAddress()) == null;

        if (newDevice) {
            node = new ZigBeeNode();
        } else {
            node = networkState.getNode(ieeeAddressResponse.getNetworkAddress());
        }

        node.setNetworkAddress(ieeeAddressResponse.getNetworkAddress());
        node.setIeeeAddress(ieeeAddressResponse.getIeeeAddress());
        node.setPowerDescriptor(powerDescriptorResponse.getPowerDescriptor());

    }

    /**
     * Adds device to network state.
     * 
     * @param ieeeAddressResponse
     *            the IEEE address response
     * @param nodeDescriptorResponse
     *            the node descriptor response
     * @param simpleDescriptorResponse
     *            the simple descriptor response
     */
    private void addOrUpdateDevice(final IeeeAddressResponse ieeeAddressResponse,
            final NodeDescriptorResponse nodeDescriptorResponse, final SimpleDescriptorResponse simpleDescriptorResponse) {
        final ZigBeeDevice device;
        final boolean newDevice = networkState.getDevice(new ZigBeeDeviceAddress(ieeeAddressResponse
                .getNetworkAddress(), simpleDescriptorResponse.getEndpoint())) == null;

        if (newDevice) {
            device = new ZigBeeDevice(networkManager);
        } else {
            device = networkState.getDevice(new ZigBeeDeviceAddress(ieeeAddressResponse.getNetworkAddress(),
                    simpleDescriptorResponse.getEndpoint()));
        }

        device.setIeeeAddress(ieeeAddressResponse.getIeeeAddress());
        device.setDeviceAddress(new ZigBeeDeviceAddress(ieeeAddressResponse.getNetworkAddress(),
                simpleDescriptorResponse.getEndpoint()));
        device.setProfileId(simpleDescriptorResponse.getProfileId());
        device.setDeviceId(simpleDescriptorResponse.getDeviceId());
        device.setManufacturerCode(nodeDescriptorResponse.getManufacturerCode());
        device.setDeviceVersion(simpleDescriptorResponse.getDeviceVersion());
        device.setDeviceType(nodeDescriptorResponse.getLogicalType());
        device.setInputClusterIds(simpleDescriptorResponse.getInputClusters());
        device.setOutputClusterIds(simpleDescriptorResponse.getOutputClusters());

        if (newDevice) {
            networkState.addDevice(device);
        } else {
            networkState.updateDevice(device);
        }

        /*
         * final UserDescriptorRequest userDescriptorRequest = new
         * UserDescriptorRequest( device.getNetworkAddress(),
         * device.getNetworkAddress()); try {
         * commandInterface.sendCommand(userDescriptorRequest); } catch (final
         * ZigBeeException e) { LOGGER.error("Error sending discovery command.",
         * e); }
         */
    }
}
