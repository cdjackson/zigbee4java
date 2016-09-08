package org.bubblecloud.zigbee.v3.zcl.clusters.groups;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;


/**
 *  Add Group Response value object class.
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
public class AddGroupResponse extends ZclCommand {
    /**
     * Status command message field.
     */
    private Integer status;
    /**
     * Group ID command message field.
     */
    private Integer groupId;

    /**
     * Default constructor setting the command type field.
     */
    public AddGroupResponse() {
        setType(ZclCommandType.ADD_GROUP_RESPONSE);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public AddGroupResponse(final ZclCommandMessage message) {
        super(message);
        this.status = (Integer) message.getFields().get(ZclFieldType.ADD_GROUP_RESPONSE_STATUS);
        this.groupId = (Integer) message.getFields().get(ZclFieldType.ADD_GROUP_RESPONSE_GROUP_ID);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.ADD_GROUP_RESPONSE_STATUS,status);
        message.getFields().put(ZclFieldType.ADD_GROUP_RESPONSE_GROUP_ID,groupId);
        return message;
    }

    /**
     * Gets Status.
     * @return the Status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets Status.
     * @param status the Status
     */
    public void setStatus(final Integer status) {
        this.status = status;
    }

    /**
     * Gets Group ID.
     * @return the Group ID
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * Sets Group ID.
     * @param groupId the Group ID
     */
    public void setGroupId(final Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("status = ");
        builder.append(status);
        builder.append(", ");
        builder.append("groupId = ");
        builder.append(groupId);
        return builder.toString();
    }

}
