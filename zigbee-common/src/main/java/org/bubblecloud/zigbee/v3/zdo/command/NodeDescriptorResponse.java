package org.bubblecloud.zigbee.v3.zdo.command;

import org.bubblecloud.zigbee.v3.zdo.ZdoCommand;
import org.bubblecloud.zigbee.v3.zdo.ZdoResponse;
import org.bubblecloud.zigbee.v3.zdo.descriptors.NodeDescriptor;

/**
 * NodeDescriptorResponse.
 */
public class NodeDescriptorResponse extends ZdoCommand implements ZdoResponse {
    /**
     * this field indicates either SUCCESS or FAILURE.
     */
    public int status;
    /**
     * the message's source network address.
     */
    public int sourceAddress;
    /**
     * Device's short address of this Node descriptor.
     */
    public int networkAddress;
    
    private NodeDescriptor nodeDescriptor;


    public NodeDescriptorResponse() {
    }

    public NodeDescriptorResponse(int status, int sourceAddress, int networkAddress,
            NodeDescriptor nodeDescriptor) {
        this.status = status;
        this.sourceAddress = sourceAddress;
        this.networkAddress = networkAddress;
        this.nodeDescriptor = nodeDescriptor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(int sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public int getNetworkAddress() {
        return networkAddress;
    }

    public void setNetworkAddress(int networkAddress) {
        this.networkAddress = networkAddress;
    }
    
    public NodeDescriptor getNodeDescriptor() {
        return nodeDescriptor;
    }

    @Override
    public String toString() {
        return "Node Descriptor Response " +
                "status=" + status +
                ", sourceAddress=" + sourceAddress +
                ", networkAddress=" + networkAddress +
                ", nodeDescriptor=" + nodeDescriptor;
    }
}
