package org.bubblecloud.zigbee.v3;

/**
 * Represents an IEEE address
 * 
 * @author Chris Jackson
 *
 */
public class IeeeAddress {
    private long address;

    public IeeeAddress(long address) {
        this.address = address;
    }

    public IeeeAddress(String address) {
        this.address = Long.parseLong(address, 16);
    }

    public long getLong() {
        return address;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return String.format("%08X", address);
    }
}
