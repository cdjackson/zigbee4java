package org.bubblecloud.zigbee.v3.zcl.clusters.levelcontrol;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;


/**
 * Stop Command value object class.
 * 
 * 
 * Cluster: Level Control
 * This cluster provides an interface for controlling a characteristic of a device that
 * can be set to a level, for example the brightness of a light, the degree of closure of
 * a door, or the power output of a heater.
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class StopCommand extends ZclCommand {

    /**
     * Default constructor setting the command type field.
     */
    public StopCommand() {
        setType(ZclCommandType.STOP_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public StopCommand(final ZclCommandMessage message) {
        super(message);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        return message;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        return builder.toString();
    }

}