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
import org.bubblecloud.zigbee.v3.zcl.clusters.iaswd.SquawkCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.iaswd.StartWarningCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclDataType;

/**
 * <b>IAS WD</b> cluster implementation (<i>Cluster ID 0x0502</i>).
 * <p>
 * The IAS WD cluster provides an interface to the functionality of any Warning
 * Device equipment of the IAS system. Using this cluster, a ZigBee enabled CIE
 * device can access a ZigBee enabled IAS WD device and issue alarm warning
 * indications (siren, strobe lighting, etc.) when a system alarm condition is detected.
 * </p>
 * This code is autogenerated. Modifications may be overwritten!
 */
public class ZclIasWdCluster extends ZclCluster {
    // Cluster ID
    private static final int CLUSTER_ID = 0x0502;

    // Attribute constants
    private final int ATTR_MAXDURATION = 0x0000;
    private final int ATTR_ZONETYPE = 0x0001;
    private final int ATTR_ZONESTATUS = 0x0002;
    private final int ATTR_IAS_CIE_ADDRESS = 0x0010;

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(4);

        attributeMap.put(ATTR_MAXDURATION, new ZclAttribute(0, ZclDataType.UNSIGNED_16_BIT_INTEGER, true, true, true, false));
        attributeMap.put(ATTR_ZONETYPE, new ZclAttribute(1, ZclDataType.ENUMERATION_8_BIT, true, true, false, false));
        attributeMap.put(ATTR_ZONESTATUS, new ZclAttribute(2, ZclDataType.BITMAP_16_BIT, true, true, false, false));
        attributeMap.put(ATTR_IAS_CIE_ADDRESS, new ZclAttribute(16, ZclDataType.IEEE_ADDRESS, true, true, true, false));

        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclIasWdCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID);
    }



    /**
     * Set the <i>MaxDuration</i> attribute
     * <p>
     * The MaxDuration attribute specifies the maximum time in seconds that the siren
     * will sound continuously, regardless of start/stop commands.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param maxDuration the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setMaxDuration(final Object value) {
        return write(ATTR_MAXDURATION, ZclDataType.UNSIGNED_16_BIT_INTEGER, value);
    }


    /**
     * Get the <i>MaxDuration</i> attribute
     * <p>
     * The MaxDuration attribute specifies the maximum time in seconds that the siren
     * will sound continuously, regardless of start/stop commands.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getMaxDuration() {
        return read(ATTR_MAXDURATION);
    }


    /**
     * Get the <i>ZoneType</i> attribute
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getZoneType() {
        return read(ATTR_ZONETYPE);
    }


    /**
     * Get the <i>ZoneStatus</i> attribute
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getZoneStatus() {
        return read(ATTR_ZONESTATUS);
    }


    /**
     * Set the <i>IAS_CIE_Address</i> attribute
     * </p>
     * The attribute is of type {@link Long}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param ias_Cie_Address the {@link Long} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setIas_Cie_Address(final Object value) {
        return write(ATTR_IAS_CIE_ADDRESS, ZclDataType.IEEE_ADDRESS, value);
    }


    /**
     * Get the <i>IAS_CIE_Address</i> attribute
     * </p>
     * The attribute is of type {@link Long}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getIas_Cie_Address() {
        return read(ATTR_IAS_CIE_ADDRESS);
    }


    /**
     * The Start Warning Command
     * <p>
     * This command starts the WD operation. The WD alerts the surrounding area by
     * audible (siren) and visual (strobe) signals.
     * <br>
     * A Start Warning command shall always terminate the effect of any previous
     * command that is still current.
     * </p>
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> startWarningCommand() {
        return send(new StartWarningCommand());
    }


    /**
     * The Squawk Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> squawkCommand() {
        return send(new SquawkCommand());
    }


    /**
     * Add a binding for this cluster to the local node
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> bind() {
        return bind();
    }

}