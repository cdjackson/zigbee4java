package org.bubblecloud.zigbee.v3.zcl.clusters.doorlock;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;


/**
 * Unlock Door Command value object class.
 * 
 * 
 * Cluster: Door Lock
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class UnlockDoorCommand extends ZclCommand {
    /**
     * Pin code command message field.
     */
    private String pinCode;

    /**
     * Default constructor setting the command type field.
     */
    public UnlockDoorCommand() {
        setType(ZclCommandType.UNLOCK_DOOR_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public UnlockDoorCommand(final ZclCommandMessage message) {
        super(message);
        this.pinCode = (String) message.getFields().get(ZclFieldType.UNLOCK_DOOR_COMMAND_PIN_CODE);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.UNLOCK_DOOR_COMMAND_PIN_CODE,pinCode);
        return message;
    }

    /**
     * Gets Pin code.
     * @return the Pin code
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * Sets Pin code.
     * @param pinCode the Pin code
     */
    public void setPinCode(final String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("pinCode = ");
        builder.append(pinCode);
        return builder.toString();
    }

}
