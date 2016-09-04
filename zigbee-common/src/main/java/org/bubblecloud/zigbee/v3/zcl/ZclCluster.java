package org.bubblecloud.zigbee.v3.zcl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import org.bubblecloud.zigbee.v3.CommandResult;
import org.bubblecloud.zigbee.v3.ZigBeeDeviceAddress;
import org.bubblecloud.zigbee.v3.ZigBeeNetworkManager;
import org.bubblecloud.zigbee.v3.zcl.field.AttributeReport;
import org.bubblecloud.zigbee.v3.zcl.field.ReadAttributeStatusRecord;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclDataType;

/**
 * Base class for the ZCL Cluster
 * 
 * @author Chris Jackson
 *
 */
public abstract class ZclCluster {

    private final ZigBeeNetworkManager zigbeeManager;
    private final ZigBeeDeviceAddress zigbeeAddress;
    protected final int clusterId;
    protected final String clusterName;

    private boolean isClient = false;
    private boolean isServer = false;

    private final List<ZclAttributeListener> attributeListeners = new ArrayList<ZclAttributeListener>();
    
    protected Map<Integer, ZclAttribute> attributes = initializeAttributes();

    protected abstract Map<Integer, ZclAttribute> initializeAttributes();

    public ZclCluster(ZigBeeNetworkManager zigbeeManager, ZigBeeDeviceAddress zigbeeAddress, int clusterId,
            String clusterName) {
        this.zigbeeManager = zigbeeManager;
        this.zigbeeAddress = zigbeeAddress;
        this.clusterId = clusterId;
        this.clusterName = clusterName;
    }

    protected Future<CommandResult> send(ZclCommand command) {
        command.setDestinationAddress(zigbeeAddress);
        // command.setDestinationEndpoint(zigbeeDevice.getEndpoint());
        return zigbeeManager.unicast(command);
    }

    /**
     * Read an attribute
     * 
     * @param attributeId
     * @return
     */
    protected Future<CommandResult> read(final int attributeId) {
        return zigbeeManager.read(zigbeeAddress, clusterId, attributeId);
        /*
         * final ReadAttributesCommand command = new ReadAttributesCommand();
         * 
         * command.setClusterId(clusterId); final AttributeIdentifier
         * attributeIdentifier = new AttributeIdentifier();
         * attributeIdentifier.setAttributeIdentifier(attributeId);
         * command.setIdentifiers
         * (Collections.singletonList(attributeIdentifier));
         * 
         * command.setDestinationAddress(device.getNetworkAddress());
         * command.setDestinationEndpoint(device.getEndpoint());
         * 
         * return unicast(command);
         */
    }

    /**
     * Write an attribute
     * 
     * @param attributeId
     * @param value
     * @return
     */
    protected Future<CommandResult> write(final int attributeId, ZclDataType dataType, final Object value) {
        return zigbeeManager.write(zigbeeAddress, clusterId, attributeId, value);
        /*
         * final WriteAttributesCommand command = new WriteAttributesCommand();
         * command.setClusterId(clusterId);
         * 
         * final WriteAttributeRecord record = new WriteAttributeRecord();
         * record.setAttributeIdentifier(attributeId);
         * record.setAttributeDataType(ZclAttributeType.get(clusterId,
         * attributeId).getZigBeeType().getId());
         * record.setAttributeValue(value);
         * command.setRecords(Collections.singletonList(record));
         * 
         * command.setDestinationAddress(zigbeeDevice.getNetworkAddress());
         * command.setDestinationEndpoint(zigbeeDevice.getEndpoint());
         * 
         * return zigbeeApi.unicast(command);
         */
    }

    public Future<CommandResult> report(final int attributeId, final int minInterval, final int maxInterval,
            final Object reportableChange) {
        return zigbeeManager.report(zigbeeAddress, clusterId, attributeId, minInterval, maxInterval, reportableChange);
        /*
         * final ConfigureReportingCommand command = new
         * ConfigureReportingCommand();
         * 
         * command.setClusterId(clusterId);
         * 
         * final AttributeReportingConfigurationRecord record = new
         * AttributeReportingConfigurationRecord(); record.setDirection(0);
         * record.setAttributeIdentifier(attributeId);
         * record.setAttributeDataType(ZclAttributeType .get(clusterId,
         * attributeId).getZigBeeType().getId());
         * record.setMinimumReportingInterval(minInterval);
         * record.setMinimumReportingInterval(maxInterval);
         * record.setReportableChange(reportableChange);
         * record.setTimeoutPeriod(0);
         * command.setRecords(Collections.singletonList(record));
         * 
         * command.setDestinationAddress(device.getNetworkAddress());
         * command.setDestinationEndpoint(device.getEndpoint());
         * 
         * return unicast(command, new ZclCustomResponseMatcher());
         */
    }

    /**
     * Gets all the attributes supported by this cluster This will return all
     * attributes, even if they are not actually supported by the device. The
     * user should check to see if this is implemented.
     * 
     * @return {@link Set} containing all {@link ZclAttributes} available in
     *         this cluster
     */
    public Set<ZclAttribute> getAttributes() {
        Set<ZclAttribute> attr = new HashSet<ZclAttribute>();
        attr.addAll(attributes.values());
        return attr;
    }

    /**
     * Gets an attribute from the attribute ID
     * 
     * @param id
     *            the attribute ID
     * @return the {@link ZclAttribute}
     */
    public ZclAttribute getAttribute(int id) {
        return attributes.get(id);
    }

    /**
     * Gets the cluster ID for this cluster
     * 
     * @return the cluster ID as {@link Integer}
     */
    public Integer getClusterID() {
        return clusterId;
    }

    /**
     * Gets the cluster name for this cluster
     * 
     * @return the cluster name as {@link String}
     */
    public String getClusterName() {
        return clusterName;
    }

    /**
     * Sets the server flag for this cluster. This means the cluster is listed
     * in the devices input cluster list
     * 
     * @param isServer
     *            true if this is a server
     */
    public void setServer(boolean isServer) {
        this.isServer = isServer;
    }

    /**
     * Gets the state of the server flag. If the cluster is a server this will
     * return true
     * 
     * @return true if the cluster can act as a server
     */
    public boolean isServer() {
        return isServer;
    }

    /**
     * Sets the client flag for this cluster. This means the cluster is listed
     * in the devices output cluster list
     * 
     * @param isServer
     *            true if this is a client
     */
    public void setClient(boolean isClient) {
        this.isClient = isClient;
    }

    /**
     * Gets the state of the client flag. If the cluster is a client this will
     * return true
     * 
     * @return true if the cluster can act as a client
     */
    public boolean isClient() {
        return isClient;
    }
    
    public void addAttributeListener(ZclAttributeListener listener) {
        // Don't add more than once.
        if(attributeListeners.contains(listener)) {
            return;
        }
        attributeListeners.add(listener);
    }
    
    public void removeAttributeListener(ZclAttributeListener listener) {
        attributeListeners.remove(listener);
    }

    private void notifyAttributeListener(ZclAttribute attribute) {
        for(ZclAttributeListener listener : attributeListeners) {
            listener.AttributeUpdated(attribute);
        }
    }

    /**
     * Processes a list of attribute reports for this cluster
     * 
     * @param reports
     *            {@List} of {@link AttributeReport}
     */
    public void handleAttributeReport(List<AttributeReport> reports) {
        for (AttributeReport report : reports) {
            ZclAttribute attribute = attributes.get(report.getAttributeIdentifier());
            attribute.updateValue(report.getAttributeValue());
            notifyAttributeListener(attribute);
        }
    }

    public void handleAttributeStatus(List<ReadAttributeStatusRecord> records) {
        for (ReadAttributeStatusRecord record : records) {
            ZclAttribute attribute = attributes.get(record.getAttributeIdentifier());
            attribute.updateValue(record.getAttributeValue());
            notifyAttributeListener(attribute);
        }
    }
}
