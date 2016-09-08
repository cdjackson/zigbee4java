package org.bubblecloud.zigbee.v3.zcl.clusters.levelcontrol;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;


/**
 * Step Command value object class.
 * 
 * 
 * Cluster: Level Control
 * This cluster provides an interface for controlling a characteristic of a device that
 * can be set to a level, for example the brightness of a light, the degree of closure of
 * a door, or the power output of a heater.
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class StepCommand extends ZclCommand {
    /**
     * Step mode command message field.
     */
    private Integer stepMode;
    /**
     * Step size command message field.
     */
    private Integer stepSize;
    /**
     * Transition time command message field.
     */
    private Integer transitionTime;

    /**
     * Default constructor setting the command type field.
     */
    public StepCommand() {
        setType(ZclCommandType.STEP_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public StepCommand(final ZclCommandMessage message) {
        super(message);
        this.stepMode = (Integer) message.getFields().get(ZclFieldType.STEP_COMMAND_STEP_MODE);
        this.stepSize = (Integer) message.getFields().get(ZclFieldType.STEP_COMMAND_STEP_SIZE);
        this.transitionTime = (Integer) message.getFields().get(ZclFieldType.STEP_COMMAND_TRANSITION_TIME);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.STEP_COMMAND_STEP_MODE,stepMode);
        message.getFields().put(ZclFieldType.STEP_COMMAND_STEP_SIZE,stepSize);
        message.getFields().put(ZclFieldType.STEP_COMMAND_TRANSITION_TIME,transitionTime);
        return message;
    }

    /**
     * Gets Step mode.
     * @return the Step mode
     */
    public Integer getStepMode() {
        return stepMode;
    }

    /**
     * Sets Step mode.
     * @param stepMode the Step mode
     */
    public void setStepMode(final Integer stepMode) {
        this.stepMode = stepMode;
    }

    /**
     * Gets Step size.
     * @return the Step size
     */
    public Integer getStepSize() {
        return stepSize;
    }

    /**
     * Sets Step size.
     * @param stepSize the Step size
     */
    public void setStepSize(final Integer stepSize) {
        this.stepSize = stepSize;
    }

    /**
     * Gets Transition time.
     * @return the Transition time
     */
    public Integer getTransitionTime() {
        return transitionTime;
    }

    /**
     * Sets Transition time.
     * @param transitionTime the Transition time
     */
    public void setTransitionTime(final Integer transitionTime) {
        this.transitionTime = transitionTime;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("stepMode = ");
        builder.append(stepMode);
        builder.append(", ");
        builder.append("stepSize = ");
        builder.append(stepSize);
        builder.append(", ");
        builder.append("transitionTime = ");
        builder.append(transitionTime);
        return builder.toString();
    }

}
