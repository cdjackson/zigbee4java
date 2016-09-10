package org.bubblecloud.zigbee.v3.zdo;

/**
 * Common interface for response commands..
 */
public abstract class ZdoRequest extends ZdoCommand {
    /**
     * Destination address;
     */
    protected int destinationAddress;
    /**
     * Gets destination address.
     * @return the destination address
     */
    public int getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(int destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
}
