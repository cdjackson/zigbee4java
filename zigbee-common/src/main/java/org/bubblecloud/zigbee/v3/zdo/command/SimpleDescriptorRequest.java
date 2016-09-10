package org.bubblecloud.zigbee.v3.zdo.command;

import org.bubblecloud.zigbee.v3.zdo.ZdoRequest;

/**
 * SimpleDescriptorRequest
 */
public class SimpleDescriptorRequest extends ZdoRequest {
    /**
     * Endpoint.
     */
    private int endpoint;

    public SimpleDescriptorRequest() {
    }

    public SimpleDescriptorRequest(int destinationAddress, int endpoint) {
        this.destinationAddress = destinationAddress;
        this.endpoint = endpoint;
    }

    public int getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(int endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return "Simple Descriptor Request " +
                "destinationAddress=" + destinationAddress +
                ", endpoint=" + endpoint;
    }
}
