package org.bubblecloud.zigbee.v3.zcl;

/**
 * Attribute update listener
 * 
 * @author Chris Jackson
 *
 */
public interface ZclAttributeListener {
    /**
     * Called when an attribute is updated
     */
    void AttributeUpdated(ZclAttribute attribute);

}
