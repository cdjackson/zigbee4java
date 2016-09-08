package org.bubblecloud.zigbee.v3.zcl.clusters.levelcontrol;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;


/**
 * Move Command value object class.
 * 
 * 
 * Cluster: Level Control
 * This cluster provides an interface for controlling a characteristic of a device that
 * can be set to a level, for example the brightness of a light, the degree of closure of
 * a door, or the power output of a heater.
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class MoveCommand extends ZclCommand {
    /**
     * Move mode command message field.
     */
    private Integer moveMode;
    /**
     * Rate command message field.
     */
    private Integer rate;

    /**
     * Default constructor setting the command type field.
     */
    public MoveCommand() {
        setType(ZclCommandType.MOVE_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public MoveCommand(final ZclCommandMessage message) {
        super(message);
        this.moveMode = (Integer) message.getFields().get(ZclFieldType.MOVE_COMMAND_MOVE_MODE);
        this.rate = (Integer) message.getFields().get(ZclFieldType.MOVE_COMMAND_RATE);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.MOVE_COMMAND_MOVE_MODE,moveMode);
        message.getFields().put(ZclFieldType.MOVE_COMMAND_RATE,rate);
        return message;
    }

    /**
     * Gets Move mode.
     * @return the Move mode
     */
    public Integer getMoveMode() {
        return moveMode;
    }

    /**
     * Sets Move mode.
     * @param moveMode the Move mode
     */
    public void setMoveMode(final Integer moveMode) {
        this.moveMode = moveMode;
    }

    /**
     * Gets Rate.
     * @return the Rate
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * Sets Rate.
     * @param rate the Rate
     */
    public void setRate(final Integer rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("moveMode = ");
        builder.append(moveMode);
        builder.append(", ");
        builder.append("rate = ");
        builder.append(rate);
        return builder.toString();
    }

}
