package org.bubblecloud.zigbee.v3.zcl.clusters.iasace;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;


/**
 * Get Zone Information Command value object class.
 * 
 * 
 * Cluster: IAS ACE
 * The IAS ACE cluster defines an interface to the functionality of any Ancillary
 * Control Equipment of the IAS system. Using this cluster, a ZigBee enabled ACE
 * device can access a IAS CIE device and manipulate the IAS system, on behalf of a
 * level-2 user.
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class GetZoneInformationCommand extends ZclCommand {
    /**
     * Zone ID command message field.
     */
    private Integer zoneId;

    /**
     * Default constructor setting the command type field.
     */
    public GetZoneInformationCommand() {
        setType(ZclCommandType.GET_ZONE_INFORMATION_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public GetZoneInformationCommand(final ZclCommandMessage message) {
        super(message);
        this.zoneId = (Integer) message.getFields().get(ZclFieldType.GET_ZONE_INFORMATION_COMMAND_ZONE_ID);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.GET_ZONE_INFORMATION_COMMAND_ZONE_ID,zoneId);
        return message;
    }

    /**
     * Gets Zone ID.
     * @return the Zone ID
     */
    public Integer getZoneId() {
        return zoneId;
    }

    /**
     * Sets Zone ID.
     * @param zoneId the Zone ID
     */
    public void setZoneId(final Integer zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("zoneId = ");
        builder.append(zoneId);
        return builder.toString();
    }

}
