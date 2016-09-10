package org.bubblecloud.zigbee.v3;

/**
 * ZigBee network listener. Provides notifications on devices and nodes - eg devices added
 * to the network, removed from the network, or updated.
 */
public interface ZigBeeNetworkStateListener {

    /**
     * Node was added
     * 
     * @param node
     *            the new {@link ZigBeeNode}
     */
    void nodeAdded(final ZigBeeNode node);

    /**
     * Node was updated
     * 
     * @param node
     *            the updated {@link ZigBeeNode}
     */
    void nodeUpdated(final ZigBeeNode node);

    /**
     * Node was removed
     * 
     * @param node
     *            the removed {@link ZigBeeNode}
     */
    void nodeRemoved(final ZigBeeNode node);
    
    /**
     * Device was added to network.
     * 
     * @param device
     *            the {@link ZigBeeDevice}
     */
    void deviceAdded(final ZigBeeDevice device);

    /**
     * Device was updated.
     * 
     * @param device
     *            the {@link ZigBeeDevice}
     */
    void deviceUpdated(final ZigBeeDevice device);

    /**
     * Device was removed from network.
     * 
     * @param device
     *            the {@link ZigBeeDevice}
     */
    void deviceRemoved(final ZigBeeDevice device);
}
