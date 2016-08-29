package org.bubblecloud.zigbee.v3.zcl.clusters;

import java.util.concurrent.Future;
import org.bubblecloud.zigbee.v3.CommandResult;
import org.bubblecloud.zigbee.v3.ZigBeeApi;
import org.bubblecloud.zigbee.v3.ZigBeeDevice;
import org.bubblecloud.zigbee.v3.zcl.ZclCluster;

/**
 * <b>Analog Value (Basic)</b> cluster implementation (<i>Cluster ID 0x000E</i>).
 * This code is autogenerated. Modifications may be overwritten!
 */
public class ZclAnalogValueBasicCluster extends ZclCluster {
    // Cluster ID
    private static final int CLUSTER_ID = 0x000E;

    /**
     * Default constructor.
     */
    public ZclAnalogValueBasicCluster(final ZigBeeApi zigbeeApi, final ZigBeeDevice zigbeeDevice) {
        super(zigbeeApi, zigbeeDevice, CLUSTER_ID);
    }


}
