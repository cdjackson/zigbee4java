package org.bubblecloud.zigbee.v3.zcl.clusters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.bubblecloud.zigbee.v3.CommandResult;
import org.bubblecloud.zigbee.v3.ZigBeeDevice;
import org.bubblecloud.zigbee.v3.ZigBeeDeviceAddress;
import org.bubblecloud.zigbee.v3.ZigBeeNetworkManager;
import org.bubblecloud.zigbee.v3.zcl.ZclAttribute;
import org.bubblecloud.zigbee.v3.zcl.ZclCluster;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ConfigureReportingCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ConfigureReportingResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.DefaultResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.DiscoverAttributesCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.DiscoverAttributesResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ReadAttributesCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ReadAttributesResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ReadAttributesStructuredCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ReadReportingConfigurationCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ReadReportingConfigurationResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ReportAttributesCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.WriteAttributesCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.WriteAttributesNoResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.WriteAttributesResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.WriteAttributesStructuredCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.WriteAttributesStructuredResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.WriteAttributesUndividedCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclDataType;

/**
 * <b>General</b> cluster implementation (<i>Cluster ID 0xFFFF</i>).
 * This code is autogenerated. Modifications may be overwritten!
 */
public class ZclGeneralCluster extends ZclCluster {
    // Cluster ID
    private static final int CLUSTER_ID = 0xFFFF;

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(0);


        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclGeneralCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID);
    }



    /**
     * The Read Attributes Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> readAttributesCommand() {
        return send(new ReadAttributesCommand());
    }


    /**
     * The  Read Attributes Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> readAttributesResponse() {
        return send(new ReadAttributesResponse());
    }


    /**
     * The Write Attributes Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> writeAttributesCommand() {
        return send(new WriteAttributesCommand());
    }


    /**
     * The Write Attributes Undivided Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> writeAttributesUndividedCommand() {
        return send(new WriteAttributesUndividedCommand());
    }


    /**
     * The  Write Attributes Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> writeAttributesResponse() {
        return send(new WriteAttributesResponse());
    }


    /**
     * The  Write Attributes No Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> writeAttributesNoResponse() {
        return send(new WriteAttributesNoResponse());
    }


    /**
     * The Configure Reporting Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> configureReportingCommand() {
        return send(new ConfigureReportingCommand());
    }


    /**
     * The  Configure Reporting Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> configureReportingResponse() {
        return send(new ConfigureReportingResponse());
    }


    /**
     * The Read Reporting Configuration Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> readReportingConfigurationCommand() {
        return send(new ReadReportingConfigurationCommand());
    }


    /**
     * The  Read Reporting Configuration Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> readReportingConfigurationResponse() {
        return send(new ReadReportingConfigurationResponse());
    }


    /**
     * The Report Attributes Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> reportAttributesCommand() {
        return send(new ReportAttributesCommand());
    }


    /**
     * The  Default Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> defaultResponse() {
        return send(new DefaultResponse());
    }


    /**
     * The Discover Attributes Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> discoverAttributesCommand() {
        return send(new DiscoverAttributesCommand());
    }


    /**
     * The  Discover Attributes Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> discoverAttributesResponse() {
        return send(new DiscoverAttributesResponse());
    }


    /**
     * The Read Attributes Structured Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> readAttributesStructuredCommand() {
        return send(new ReadAttributesStructuredCommand());
    }


    /**
     * The Write Attributes Structured Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> writeAttributesStructuredCommand() {
        return send(new WriteAttributesStructuredCommand());
    }


    /**
     * The  Write Attributes Structured Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> writeAttributesStructuredResponse() {
        return send(new WriteAttributesStructuredResponse());
    }

}
