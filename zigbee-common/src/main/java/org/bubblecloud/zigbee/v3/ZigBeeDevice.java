package org.bubblecloud.zigbee.v3;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.bubblecloud.zigbee.v3.zcl.ZclCluster;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ReadAttributesResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.general.ReportAttributesCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclClusterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Value object for ZigBee device.
 */
public class ZigBeeDevice implements CommandListener {
    /**
     * The {@link Logger}.
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ZigBeeDevice.class);

    /**
     * Link to the network manager
     */
    private final ZigBeeNetworkManager networkManager;
    /**
     * The IEEE address.
     */
    private IeeeAddress ieeeAddress;
    /**
     * The network address.
     */
    private ZigBeeDeviceAddress networkAddress = null;
    /**
     * The profile ID.
     */
    private int profileId;
    /**
     * The logical type of the device.
     */
    private int deviceType;
    /**
     * The device ID.
     */
    private int deviceId;
    /**
     * The manufacturer code.
     */
    private int manufacturerCode;
    /**
     * The device version.
     */
    private int deviceVersion;
    /**
     * Clusters
     */
    private final Map<Integer, ZclCluster> clusters = new HashMap<Integer, ZclCluster>();
    /**
     * Input cluster IDs
     */
    private final List<Integer> inputClusterIds = new ArrayList<Integer>();
    /**
     * Output cluster IDs
     */
    private final List<Integer> outputClusterIds = new ArrayList<Integer>();
    /**
     * Label.
     */
    private String label;

    ZigBeeDevice(ZigBeeNetworkManager networkManager) {
        this.networkManager = networkManager;
        networkManager.addCommandListener(this);
    }

    protected void finalize() {
        networkManager.removeCommandListener(this);
    }

    /**
     * Gets the device ID.
     * 
     * @return the device ID
     */
    public int getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the device ID.
     * 
     * @param deviceId
     *            the device ID.
     */
    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Gets device version.
     * 
     * @return the device version
     */
    public int getDeviceVersion() {
        return deviceVersion;
    }

    /**
     * Sets device version.
     * 
     * @param deviceVersion
     *            the device version
     */
    public void setDeviceVersion(int deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

    /**
     * Gets end point.
     * 
     * @return the end point
     */
    public int getEndpoint() {
        return networkAddress.getEndpoint();
    }

    /**
     * Gets IEEE Address.
     * 
     * @return the IEEE address
     */
    public IeeeAddress getIeeeAddress() {
        return ieeeAddress;
    }

    /**
     * Sets IEEE Address.
     * 
     * @param ieeeAddress
     *            the IEEE address
     */
    public void setIeeeAddress(IeeeAddress ieeeAddress) {
        this.ieeeAddress = ieeeAddress;
    }

    /**
     * Gets input cluster IDs. This lists the IDs of all clusters the device
     * supports as a server.
     * 
     * @return the input cluster IDs
     */
    public List<Integer> getInputClusterIds() {
        return inputClusterIds;
    }

    /**
     * Gets an input cluster
     * 
     * @param clusterId
     *            the cluster number
     * @return the cluster or null if cluster is not found
     */
    public ZclCluster getCluster(int clusterId) {
        return clusters.get(clusterId);
    }

    /**
     * Sets input cluster IDs.
     * 
     * @param inputClusterIds
     *            the input cluster IDs
     */
    public void setInputClusterIds(List<Integer> inputClusterIds) {
        this.inputClusterIds.clear();
        this.inputClusterIds.addAll(inputClusterIds);

        LOGGER.debug("{}: Setting input clusters {}", networkAddress, inputClusterIds);

        updateClusters(inputClusterIds, true);
    }

    public void setDeviceAddress(ZigBeeDeviceAddress networkAddress) {
        this.networkAddress = networkAddress;
    }

    /**
     * Gets network address.
     * 
     * @return the network address
     */
    public int getNetworkAddress() {
        return networkAddress.getAddress();
    }

    /**
     * Gets the device address
     * 
     * @return the {@link ZigBeeDeviceAddress}
     */
    public ZigBeeDeviceAddress getDeviceAddress() {
        return networkAddress;
    }

    /**
     * Gets output cluster IDs. This provides the IDs of all clusters the device
     * supports as a client.
     * 
     * @return the output cluster IDs
     */
    public List<Integer> getOutputClusterIds() {
        return outputClusterIds;
    }

    /**
     * Sets output cluster IDs.
     * 
     * @param outputClusterIds
     *            the output cluster IDs
     */
    public void setOutputClusterIds(List<Integer> outputClusterIds) {
        this.outputClusterIds.clear();
        this.outputClusterIds.addAll(outputClusterIds);

        LOGGER.debug("{}: Setting output clusters {}", networkAddress, outputClusterIds);

        updateClusters(outputClusterIds, false);
    }

    private void updateClusters(List<Integer> newList, boolean isInput) {
        // Get a list any clusters that are no longer in the list
        List<Integer> removeIds = new ArrayList<Integer>();
        for (ZclCluster cluster : clusters.values()) {
            if (newList.contains(cluster.getClusterID())) {
                // The existing cluster is in the new list, so no need to remove
                // it
                continue;
            }
            if (isInput == true && cluster.isServer() == false) {
                cluster.setServer(false);
            }
            if (isInput == false && cluster.isClient() == false) {
                cluster.setClient(false);
            }

            // If the cluster is not a server or client, then remove it
            if (!cluster.isClient() && !cluster.isServer()) {
                removeIds.add(cluster.getClusterID());
            }
        }

        // Remove clusters no longer in use
        for (int id : removeIds) {
            LOGGER.debug("{}: Removing cluster {}", networkAddress, id);
            clusters.remove(id);
        }

        // Add any missing clusters into the list
        for (int id : newList) {
            if (!clusters.containsKey(id)) {
                // Get the cluster type
                ZclClusterType clusterType = ZclClusterType.getValueById(id);
                ZclCluster clusterClass = null;
                if (clusterType == null) {
                    // Unsupported cluster
                    LOGGER.debug("{}: Unsupported cluster {}", networkAddress, id);
                    continue;
                }

                // Create a cluster class
                Constructor<? extends ZclCluster> constructor;
                try {
                    constructor = clusterType.getClusterClass().getConstructor(ZigBeeNetworkManager.class,
                            ZigBeeDeviceAddress.class);
                    clusterClass = constructor.newInstance(networkManager, networkAddress);
                } catch (Exception e) {
                    LOGGER.debug("{}: Error instantiating cluster {}", networkAddress, clusterType);
                }
                if (isInput) {
                    LOGGER.debug("{}: Setting cluster {} as server", networkAddress, clusterType);
                    clusterClass.setServer(true);
                } else {
                    LOGGER.debug("{}: Setting cluster {} as client", networkAddress, clusterType);
                    clusterClass.setClient(true);
                }

                // Add to our list of clusters
                clusters.put(id, clusterClass);
            }
        }
    }

    /**
     * Gets profile ID.
     * 
     * @return the profile ID.
     */
    public int getProfileId() {
        return profileId;
    }

    /**
     * Sets profile ID
     * 
     * @param profileId
     *            the profile ID
     */
    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    /**
     * Gets device logical type.
     * 
     * @return the device logical type.
     */
    public int getDeviceType() {
        return deviceType;
    }

    /**
     * Sets device logical type.
     * 
     * @param deviceType
     *            the device logical type
     */
    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Gets manufacturer code.
     * 
     * @return the manufacturer code.
     */
    public int getManufacturerCode() {
        return manufacturerCode;
    }

    /**
     * Sets manufacturer code.
     * 
     * @param manufacturerCode
     *            the manufacturer code.
     */
    public void setManufacturerCode(int manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    /**
     * Gets label.
     * 
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets label.
     * 
     * @param label
     *            the label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void commandReceived(Command command) {
        if (command instanceof ReportAttributesCommand
                && ((ReportAttributesCommand) command).getSourceAddress().equals(networkAddress)) {
            ReportAttributesCommand attributeCommand = (ReportAttributesCommand) command;
            
            // Get the cluster
            ZclCluster cluster = getCluster(attributeCommand.getClusterId());
            if(cluster == null) {
                LOGGER.debug("{}: Cluster {} not found for attribute report", networkAddress, attributeCommand.getClusterId());
                return;
            }

            // Pass the reports to the cluster
            cluster.handleAttributeReport(attributeCommand.getReports());
        }
        if (command instanceof ReadAttributesResponse
                && ((ReadAttributesResponse) command).getSourceAddress().equals(networkAddress)) {
            ReadAttributesResponse attributeCommand = (ReadAttributesResponse) command;
            
            // Get the cluster
            ZclCluster cluster = getCluster(attributeCommand.getClusterId());
            if(cluster == null) {
                LOGGER.debug("{}: Cluster {} not found for attribute report", networkAddress, attributeCommand.getClusterId());
                return;
            }

            attributeCommand.getRecords();
            // Pass the reports to the cluster
            cluster.handleAttributeStatus(attributeCommand.getRecords());
        }
    }

    @Override
    public String toString() {
        return "ZigBeeDevice " + "label=" + label + ", networkAddress=" + networkAddress.toString() + ", ieeeAddress="
                + String.format("%08X", ieeeAddress) + ", profileId=" + profileId + ", deviceType=" + deviceType + ", deviceId=" + deviceId
                + ", manufacturerCode=" + manufacturerCode + ", deviceVersion=" + deviceVersion + ", inputClusterIds="
                + getInputClusterIds().toString() + ", outputClusterIds=" + getOutputClusterIds().toString();
    }
}
