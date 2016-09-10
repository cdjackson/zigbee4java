package org.bubblecloud.zigbee.v3;

import org.bubblecloud.zigbee.v3.zcl.ZclCustomResponseMatcher;
import org.bubblecloud.zigbee.v3.zcl.clusters.ZclOnOffCluster;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.MoveToColorCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.doorlock.LockDoorCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.doorlock.UnlockDoorCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.groups.AddGroupCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.groups.GetGroupMembershipCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.groups.RemoveGroupCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.groups.ViewGroupCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.iaswd.SquawkCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.iaswd.StartWarningCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.levelcontrol.MoveToLevelCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.onoff.OffCommand;
import org.bubblecloud.zigbee.v3.zcl.field.Unsigned16BitInteger;
import org.bubblecloud.zigbee.v3.zdo.command.*;
import org.bubblecloud.zigbee.util.Cie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.*;

/**
 * ZigBee API. This API is experimental and under development.
 */
public class ZigBeeApi {
    /**
     * The {@link Logger}.
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ZigBeeApi.class);

    /**
     * The ZigBee Network Manager
     */
    private ZigBeeNetworkManager networkManager;
    
    /**
     * Default constructor inheritance.
     */
    public ZigBeeApi() {
    }

    /**
     * Constructor for setting the ZCL API.
     * @param network the ZCL API
     */
    public ZigBeeApi(final ZigBeeNetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    /**
     * Gets the ZigBee network.
     * @return the ZigBee network
     */
    public ZigBeeNetworkManager getNetwork() {
        return networkManager;
    }

    /**
     * Sets device label.
     * @param networkAddress the network address
     * @param endPointId the end point ID
     * @param label the label
     */
    public void setDeviceLabel(final int networkAddress, final int endPointId, final String label) {
        networkManager.setDeviceLabel(networkAddress, endPointId, label);
    }

    /**
     * Removes device(s) by network address.
     * @param networkAddress the network address
     */
    public void removeDevice(final int networkAddress) {
        networkManager.removeDevice(networkAddress);
    }


    /**
     * Gets ZigBee devices.
     * @return list of ZigBee devices
     */
    public List<ZigBeeDevice> getDevices() {
        return networkManager.getDevices();
    }

    /**
     * Sets group label.
     * @param groupId the group ID
     * @param label the label
     */
    public void addMembership(final int groupId, final String label) {
        networkManager.addMembership(groupId, label);
    }

    /**
     * Removes group label.
     * @param groupId the group ID
     */
    public void removeMembership(final int groupId) {
        networkManager.removeMembership(groupId);
    }

    /**
     * Gets group by network address.
     * @param groupId the group ID
     * @return the ZigBee group or null if no exists with given group ID.
     */
    public ZigBeeGroupAddress getGroup(final int groupId) {
        return networkManager.getGroup(groupId);
    }

    /**
     * Gets all groups.
     * @return list of groups.
     */
    public List<ZigBeeGroupAddress> getGroups() {
        return networkManager.getGroups();
    }

    /**
     * Labels destination.
     * @param destination the {@link ZigBeeAddress}
     */
    public void label(final ZigBeeAddress destination, final String label) {
        if (destination.isGroup()) {
            final ZigBeeGroupAddress group = (ZigBeeGroupAddress) destination;
            this.addMembership(group.getGroupId(), label);
        } else {
            final ZigBeeDeviceAddress device = (ZigBeeDeviceAddress) destination;
            this.setDeviceLabel(device.getAddress(), device.getEndpoint(), label);
        }
    }

    /**
     * Sets user descriptor.
     * @param device the device
     * @param descriptor the descriptor
     * @return TRUE if no errors occurred in sending.
     */
    public Future<CommandResult> describe(final ZigBeeDevice device, final String descriptor) {
        final UserDescriptorSet command = new UserDescriptorSet(device.getNetworkAddress(), device.getNetworkAddress(),
                descriptor);

        return networkManager.unicast(command);
    }

    /**
     * Binds two devices.
     * @param source the source device
     * @param destination the destination device
     * @param clusterId the cluster ID
     * @return TRUE if no errors occurred in sending.
     */
    public Future<CommandResult> bind(final ZigBeeDevice source, final ZigBeeDevice destination, final int clusterId) {
        return networkManager.bind(source, destination, clusterId);
    }

    /**
     * Unbinds two devices.
     * @param source the source device
     * @param destination the destination device
     * @param clusterId the cluster ID
     * @return TRUE if no errors occurred in sending.
     */
    public Future<CommandResult> unbind(final ZigBeeDevice source, final ZigBeeDevice destination,
                                        final int clusterId) {
        return networkManager.unbind(source, destination, clusterId);
    }

    /**
     * Switches destination on.
     * @param destination the {@link ZigBeeAddress}
     * @return the command result future.
     */
    public Future<CommandResult> on(final ZigBeeAddress destination) {
        ZigBeeDevice device = networkManager.getDevice((ZigBeeDeviceAddress) destination);
        ZclOnOffCluster cluster = (ZclOnOffCluster) device.getCluster(ZclOnOffCluster.CLUSTER_ID);
        return cluster.onCommand();

//        final OnCommand command = new OnCommand();
//        return send(destination, command);

    }

    /**
     * Switches destination off.
     * @param destination the {@link ZigBeeAddress}
     * @return the command result future.
     */
    public Future<CommandResult> off(final ZigBeeAddress destination) {
        final OffCommand command = new OffCommand();
        return networkManager.send(destination, command);
    }

    /**
     * Colors device light.
     * @param destination the {@link ZigBeeAddress}
     * @param red the red component [0..1]
     * @param green the green component [0..1]
     * @param blue the blue component [0..1]
     * @param time the in seconds
     * @return the command result future.
     */
    public Future<CommandResult> color(final ZigBeeAddress destination, final double red, final double green,
                                       final double blue, double time) {
        final MoveToColorCommand command = new MoveToColorCommand();

        final Cie cie = Cie.rgb2cie(red, green ,blue);

        int x = (int) (cie.x * 65536);
        int y = (int) (cie.y * 65536);
        if (x > 65279) {
            x = 65279;
        }
        if (y > 65279) {
            y = 65279;
        }

        command.setColorX(x);
        command.setColorY(y);
        command.setTransitionTime((int) (time * 10));

        return networkManager.send(destination, command);
    }

    /**
     * Moves device level.
     * @param destination the {@link ZigBeeAddress}
     * @param level the level
     * @param time the transition time
     * @return the command result future.
     */
    public Future<CommandResult> level(final ZigBeeAddress destination, final double level, final double time) {

        final MoveToLevelCommand command = new MoveToLevelCommand();

        int l = (int) (level * 254);
        if (l > 254) {
            l = 254;
        }
        if (l < 0) {
            l = 0;
        }

        command.setLevel(l);
        command.setTransitionTime((int) (time * 10));

        return networkManager.send(destination, command);
    }

    /**
     * Locks door.
     * @param destination the {@link ZigBeeAddress}
     * @param pinCode the pin code
     * @return the command result future.
     */
    public Future<CommandResult> lock(final ZigBeeAddress destination, final String pinCode) {
        final LockDoorCommand command = new LockDoorCommand();

        command.setPinCode(pinCode);

        return networkManager.send(destination, command);
    }

    /**
     * Unlocks door.
     * @param destination the {@link ZigBeeAddress}
     * @param pinCode the pin code
     * @return the command result future.
     */
    public Future<CommandResult> unlock(final ZigBeeAddress destination, final String pinCode) {
        final UnlockDoorCommand command = new UnlockDoorCommand();

        command.setPinCode(pinCode);

        return networkManager.send(destination, command);
    }

    /**
     * This command uses the WD capabilities to emit a quick audible/visible pulse called a "squawk".
     * @param destination the {@link ZigBeeAddress}
     * @param mode the mode
     * @param strobe the strobe
     * @param level the level
     * @return the command result future
     */
    public Future<CommandResult> squawk(final ZigBeeAddress destination, final int mode, final int strobe, final int level) {
        final SquawkCommand command = new SquawkCommand();

        final int header = (level << 6) | (strobe << 4) | mode;

        command.setHeader(header);

        return networkManager.send(destination, command);
    }

    /**
     * Starts warning.
     * @param destination the {@link ZigBeeAddress}
     * @param mode the mode
     * @param strobe the strobe
     * @param duration the duration
     * @return the command result future
     */
    public Future<CommandResult> warn(final ZigBeeAddress destination, final int mode, final int strobe, final int duration) {
        final StartWarningCommand command = new StartWarningCommand();

        final int header = (strobe << 4) | mode;
        command.setHeader(header);
        command.setWarningDuration(duration);

        return networkManager.send(destination, command);
    }

    /**
     * Writes attribute to device.
     * @param device the device
     * @param clusterId the cluster ID
     * @param attributeId the attribute ID
     * @param value the value
     * @return the command result future
     */
    public Future<CommandResult> write(final ZigBeeDeviceAddress device, final int clusterId, final int attributeId,
                                       final Object value) {
        return networkManager.write(device, clusterId, attributeId, value);
    }

    /**
     * Reads attribute from device.
     * @param device the device
     * @param clusterId the cluster ID
     * @param attributeId the attribute ID
     * @return the command result future
     */
    public Future<CommandResult> read(final ZigBeeDeviceAddress device, final int clusterId, final int attributeId) {
        return networkManager.read(device, clusterId, attributeId);
    }

    /**
     * Configures attribute reporting.
     * @param device the device
     * @param clusterId the cluster ID
     * @param attributeId the attribute ID
     * @param minInterval the minimum interval
     * @param maxInterval the maximum interval
     * @param reportableChange the reportable change
     * @return the command result future
     */
    public Future<CommandResult> report(final ZigBeeDeviceAddress device, final int clusterId, final int attributeId,
                                        final int minInterval, final int maxInterval, final Object reportableChange) {
        return networkManager.report(device, clusterId, attributeId, minInterval, maxInterval, reportableChange);
    }

    /**
     * Permit joining.
     * @param enable enable
     */
    public void permitJoin(final boolean enable) {
        networkManager.permitJoin(enable);
    }

    /**
     * Adds group membership to device.
     * @param device the device
     * @param groupId the group ID
     * @param groupName the group name
     * @return the command result future
     */
    public Future<CommandResult> addMembership(final ZigBeeDevice device, final int groupId, final String groupName) {
        final AddGroupCommand command = new AddGroupCommand();
        command.setGroupId(groupId);
        command.setGroupName(groupName);

        command.setDestinationAddress(device.getDeviceAddress());

        return networkManager.unicast(command, new ZclCustomResponseMatcher());
    }

    /**
     * Gets group memberships from device.
     * @param device the device
     * @return the command result future
     */
    public Future<CommandResult> getGroupMemberships(final ZigBeeDevice device) {
        final GetGroupMembershipCommand command = new GetGroupMembershipCommand();

        command.setGroupCount(0);
        command.setGroupList(Collections.<Unsigned16BitInteger>emptyList());
        command.setDestinationAddress(device.getDeviceAddress());

        return networkManager.unicast(command, new ZclCustomResponseMatcher());
    }

    /**
     * Views group membership from device.
     * @param device the device
     * @param groupId the group ID
     * @return the command result future
     */
    public Future<CommandResult> viewMembership(final ZigBeeDevice device, final int groupId) {
        final ViewGroupCommand command = new ViewGroupCommand();
        command.setGroupId(groupId);

        command.setDestinationAddress(device.getDeviceAddress());

        return networkManager.unicast(command, new ZclCustomResponseMatcher());
    }

    /**
     * Removes group membership from device.
     * @param device the device
     * @param groupId the group ID
     * @return the command result future
     */
    public Future<CommandResult> removeMembership(final ZigBeeDevice device, final int groupId) {
        final RemoveGroupCommand command = new RemoveGroupCommand();
        command.setGroupId(groupId);

        command.setDestinationAddress(device.getDeviceAddress());

        return networkManager.unicast(command, new ZclCustomResponseMatcher());
    }
}
