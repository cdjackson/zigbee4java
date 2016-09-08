package org.bubblecloud.zigbee.v3.zcl.clusters.groups;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;
import org.bubblecloud.zigbee.v3.zcl.field.*;

import java.util.List;

/**
 *  Get Group Membership Response value object class.
 * 
 * 
 * Cluster: Groups
 * The ZigBee specification provides the capability for group addressing. That is,
 * any endpoint on any device may be assigned to one or more groups, each labeled
 * with a 16-bit identifier (0x0001 – 0xfff7), which acts for all intents and purposes
 * like a network address. Once a group is established, frames, sent using the
 * APSDE-DATA.request primitive and having a DstAddrMode of 0x01, denoting
 * group addressing, will be delivered to every endpoint assigned to the group
 * address named in the DstAddr parameter of the outgoing APSDE-DATA.request
 * primitive on every device in the network for which there are such endpoints.
 * <br>
 * Management of group membership on each device and endpoint is implemented
 * by the APS, but the over-the-air messages that allow for remote management and
 * commissioning of groups are defined here in the cluster library on the theory that,
 * while the basic group addressing facilities are integral to the operation of the
 * stack, not every device will need or want to implement this management cluster.
 * Furthermore, the placement of the management commands here allows developers
 * of proprietary profiles to avoid implementing the library cluster but still exploit
 * group addressing
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class GetGroupMembershipResponse extends ZclCommand {
    /**
     * Capacity command message field.
     */
    private Integer capacity;
    /**
     * Group count command message field.
     */
    private Integer groupCount;
    /**
     * Group list command message field.
     */
    private List<Unsigned16BitInteger> groupList;

    /**
     * Default constructor setting the command type field.
     */
    public GetGroupMembershipResponse() {
        setType(ZclCommandType.GET_GROUP_MEMBERSHIP_RESPONSE);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public GetGroupMembershipResponse(final ZclCommandMessage message) {
        super(message);
        this.capacity = (Integer) message.getFields().get(ZclFieldType.GET_GROUP_MEMBERSHIP_RESPONSE_CAPACITY);
        this.groupCount = (Integer) message.getFields().get(ZclFieldType.GET_GROUP_MEMBERSHIP_RESPONSE_GROUP_COUNT);
        this.groupList = (List<Unsigned16BitInteger>) message.getFields().get(ZclFieldType.GET_GROUP_MEMBERSHIP_RESPONSE_GROUP_LIST);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.GET_GROUP_MEMBERSHIP_RESPONSE_CAPACITY,capacity);
        message.getFields().put(ZclFieldType.GET_GROUP_MEMBERSHIP_RESPONSE_GROUP_COUNT,groupCount);
        message.getFields().put(ZclFieldType.GET_GROUP_MEMBERSHIP_RESPONSE_GROUP_LIST,groupList);
        return message;
    }

    /**
     * Gets Capacity.
     * @return the Capacity
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Sets Capacity.
     * @param capacity the Capacity
     */
    public void setCapacity(final Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets Group count.
     * @return the Group count
     */
    public Integer getGroupCount() {
        return groupCount;
    }

    /**
     * Sets Group count.
     * @param groupCount the Group count
     */
    public void setGroupCount(final Integer groupCount) {
        this.groupCount = groupCount;
    }

    /**
     * Gets Group list.
     * @return the Group list
     */
    public List<Unsigned16BitInteger> getGroupList() {
        return groupList;
    }

    /**
     * Sets Group list.
     * @param groupList the Group list
     */
    public void setGroupList(final List<Unsigned16BitInteger> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("capacity = ");
        builder.append(capacity);
        builder.append(", ");
        builder.append("groupCount = ");
        builder.append(groupCount);
        builder.append(", ");
        builder.append("groupList = ");
        builder.append(groupList);
        return builder.toString();
    }

}
