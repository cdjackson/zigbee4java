package org.bubblecloud.zigbee.v3.zdo.command;

import org.bubblecloud.zigbee.v3.zdo.ZdoRequest;

/**
 * UserDescriptorSet.
 */
public class UserDescriptorSet extends ZdoRequest {
    /**
     * The network address.
     */
    public int networkAddress;
    /**
     * The user descriptor. Maximum 16 ASCII character set characters.
     */
    public String descriptor;

    public UserDescriptorSet() {
    }

    public UserDescriptorSet(int destinationAddress, int networkAddress, String descriptor) {
        this.destinationAddress = destinationAddress;
        this.networkAddress = networkAddress;
        this.descriptor = descriptor;
    }

    public int getNetworkAddress() {
        return networkAddress;
    }

    public void setNetworkAddress(int networkAddress) {
        this.networkAddress = networkAddress;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public String toString() {
        return "UserDescriptorSet " +
                "destinationAddress=" + destinationAddress +
                ", networkAddress=" + networkAddress +
                ", descriptor='" + descriptor + '\'';
    }
}
