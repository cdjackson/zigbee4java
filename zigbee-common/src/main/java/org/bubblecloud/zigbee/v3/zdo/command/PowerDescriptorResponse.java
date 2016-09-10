package org.bubblecloud.zigbee.v3.zdo.command;

import org.bubblecloud.zigbee.v3.zdo.ZdoCommand;
import org.bubblecloud.zigbee.v3.zdo.ZdoResponse;
import org.bubblecloud.zigbee.v3.zdo.descriptors.PowerDescriptor;

/**
 * 
 * @author Chris Jackson
 *
 */
public class PowerDescriptorResponse extends ZdoCommand implements ZdoResponse {
    /**
     * this field indicates either SUCCESS or FAILURE.
     */
    public int status;
    /**
     * the message's source network address.
     */
    public int sourceAddress;
    
    private PowerDescriptor powerDescriptor;

    public PowerDescriptorResponse() {
    }

    public PowerDescriptorResponse(int status, int sourceAddress, PowerDescriptor powerDescriptor) {
        this.status = status;
        this.sourceAddress = sourceAddress;
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

    public PowerDescriptor getPowerDescriptor() {
        return powerDescriptor;
    }

    @Override
    public String toString() {
        return "Power Descriptor Response " +
                "status=" + status +
                ", sourceAddress=" + sourceAddress +
                ", powerDescriptor=" + powerDescriptor;
    }
}
