package org.bubblecloud.zigbee.v3;

/**
 * ZigBee network.
 */
public interface ZigBeeNetwork {
    enum TransportState {
        UNINITIALISED, INITIALISING, ONLINE
    }

    /**
     * Sends ZigBee library command without waiting for response.
     * 
     * @param command
     *            the command
     * @return transaction ID
     * @throws ZigBeeException
     *             if exception occurs in sending
     */
    int sendCommand(final Command command) throws ZigBeeException;

    /**
     * Adds ZigBee library command listener.
     * 
     * @param commandListener
     *            the command listener
     */
    void addCommandListener(final CommandListener commandListener);

    /**
     * Removes ZigBee library command listener.
     * 
     * @param commandListener
     *            the command listener
     */
    void removeCommandListener(final CommandListener commandListener);

    /**
     * A callback called by the {@link ZigBeeTransport} when a command is
     * received
     * 
     * @param command
     *            the {@link Command} that is received
     */
    void receiveCommand(final Command command);

    /**
     * Set the network state.
     * This is a callback from the {@link ZigBeeTransport} when the state of the transport changes
     * @param state
     */
    void setNetworkState(TransportState state);
    
    /**
     * Adds a ZigBee network state listener.
     * This will receive network state updates (eg when the network is initialised).
     * @param stateListener the {@link ZigBeeNetworkStateListener} state listener
     */
    public void addNetworkStateListener(ZigBeeNetworkStateListener stateListener);

}
