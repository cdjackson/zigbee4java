package org.bubblecloud.zigbee.v3.zcl.clusters.general;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;


/**
 * Write Attributes Structured Command value object class.
 * 
 * The write attributes structured command is generated when a device wishes to
 * change the values of one or more attributes located on another device. Each write
 * attribute record shall contain the identifier and the actual value of the attribute, or
 * element thereof, to be written.
 * 
 * Cluster: General
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class WriteAttributesStructuredCommand extends ZclCommand {
    /**
     * Attribute selectors command message field.
     */
    private Object attributeSelectors;

    /**
     * Default constructor setting the command type field.
     */
    public WriteAttributesStructuredCommand() {
        setType(ZclCommandType.WRITE_ATTRIBUTES_STRUCTURED_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public WriteAttributesStructuredCommand(final ZclCommandMessage message) {
        super(message);
        this.attributeSelectors = (Object) message.getFields().get(ZclFieldType.WRITE_ATTRIBUTES_STRUCTURED_COMMAND_ATTRIBUTE_SELECTORS);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.WRITE_ATTRIBUTES_STRUCTURED_COMMAND_ATTRIBUTE_SELECTORS,attributeSelectors);
        return message;
    }

    /**
     * Gets Attribute selectors.
     * @return the Attribute selectors
     */
    public Object getAttributeSelectors() {
        return attributeSelectors;
    }

    /**
     * Sets Attribute selectors.
     * @param attributeSelectors the Attribute selectors
     */
    public void setAttributeSelectors(final Object attributeSelectors) {
        this.attributeSelectors = attributeSelectors;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("attributeSelectors = ");
        builder.append(attributeSelectors);
        return builder.toString();
    }

}
