package org.bubblecloud.zigbee.v3.zcl.clusters.iasace;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;


/**
 * Arm Command value object class.
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
public class ArmCommand extends ZclCommand {
    /**
     * Arm Mode command message field.
     */
    private Integer armMode;

    /**
     * Default constructor setting the command type field.
     */
    public ArmCommand() {
        setType(ZclCommandType.ARM_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public ArmCommand(final ZclCommandMessage message) {
        super(message);
        this.armMode = (Integer) message.getFields().get(ZclFieldType.ARM_COMMAND_ARM_MODE);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.ARM_COMMAND_ARM_MODE,armMode);
        return message;
    }

    /**
     * Gets Arm Mode.
     * @return the Arm Mode
     */
    public Integer getArmMode() {
        return armMode;
    }

    /**
     * Sets Arm Mode.
     * @param armMode the Arm Mode
     */
    public void setArmMode(final Integer armMode) {
        this.armMode = armMode;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("armMode");
        builder.append('=');
        builder.append(armMode);
        return builder.toString();
    }

}