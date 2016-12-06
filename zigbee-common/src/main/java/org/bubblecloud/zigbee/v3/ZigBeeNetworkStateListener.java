package org.bubblecloud.zigbee.v3;

import org.bubblecloud.zigbee.v3.ZigBeeNetwork.TransportState;

/**
 * ZigBee network listener. Provides notifications on updates to the network state
 */
public interface ZigBeeNetworkStateListener {

    /**
     * Network state has been update.
     * 
     * @param state
     *            the updated {@link TransportState}
     */
    void networkStateUpdated(final TransportState state);
}
