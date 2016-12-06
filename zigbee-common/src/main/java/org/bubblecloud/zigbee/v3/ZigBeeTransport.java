package org.bubblecloud.zigbee.v3;

/**
 * ZigBee transport interface implemented by different hardware drivers. This
 * could support for example serial interfaces for dongles, or IP connections to
 * remote interfaces.
 */
public interface ZigBeeTransport {
    /**
     * Starts up a transport interface.
     *
     * @return true if startup was success.
     */
    boolean startup();

    /**
     * Shuts down a transport interface.
     */
    void shutdown();

    /**
     * Sends ZigBee library command without waiting for response.
     * 
     * @param command
     *            the command
     * @return transaction ID
     * @throws {@link ZigBeeException} if exception occurs in sending
     */
    int sendCommand(final Command command) throws ZigBeeException;

    /**
     * Sets the {@link ZigBeeNetwork}. Called by the network so that the
     * {@link ZigBeeTransport} can send callback messages to the network.
     * 
     * @param zigbeeNetwork
     */
    void setZigBeeNetwork(final ZigBeeNetwork zigbeeNetwork);
}
