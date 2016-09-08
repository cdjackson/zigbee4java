package org.bubblecloud.zigbee.v3.zcl.clusters.iaswd;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;


/**
 * Start Warning Command value object class.
 * 
 * This command starts the WD operation. The WD alerts the surrounding area by
 * audible (siren) and visual (strobe) signals.
 * <br>
 * A Start Warning command shall always terminate the effect of any previous
 * command that is still current.
 * 
 * Cluster: IAS WD
 * The IAS WD cluster provides an interface to the functionality of any Warning
 * Device equipment of the IAS system. Using this cluster, a ZigBee enabled CIE
 * device can access a ZigBee enabled IAS WD device and issue alarm warning
 * indications (siren, strobe lighting, etc.) when a system alarm condition is detected.
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class StartWarningCommand extends ZclCommand {
    /**
     * Header command message field.
     */
    private Integer header;
    /**
     * Warning duration command message field.
     */
    private Integer warningDuration;

    /**
     * Default constructor setting the command type field.
     */
    public StartWarningCommand() {
        setType(ZclCommandType.START_WARNING_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public StartWarningCommand(final ZclCommandMessage message) {
        super(message);
        this.header = (Integer) message.getFields().get(ZclFieldType.START_WARNING_COMMAND_HEADER);
        this.warningDuration = (Integer) message.getFields().get(ZclFieldType.START_WARNING_COMMAND_WARNING_DURATION);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.START_WARNING_COMMAND_HEADER,header);
        message.getFields().put(ZclFieldType.START_WARNING_COMMAND_WARNING_DURATION,warningDuration);
        return message;
    }

    /**
     * Gets Header.
     * @return the Header
     */
    public Integer getHeader() {
        return header;
    }

    /**
     * Sets Header.
     * @param header the Header
     */
    public void setHeader(final Integer header) {
        this.header = header;
    }

    /**
     * Gets Warning duration.
     * @return the Warning duration
     */
    public Integer getWarningDuration() {
        return warningDuration;
    }

    /**
     * Sets Warning duration.
     * @param warningDuration the Warning duration
     */
    public void setWarningDuration(final Integer warningDuration) {
        this.warningDuration = warningDuration;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("header = ");
        builder.append(header);
        builder.append(", ");
        builder.append("warningDuration = ");
        builder.append(warningDuration);
        return builder.toString();
    }

}
