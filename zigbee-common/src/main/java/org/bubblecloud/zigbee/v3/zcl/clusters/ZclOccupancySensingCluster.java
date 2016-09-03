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
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclDataType;

/**
 * <b>Occupancy sensing</b> cluster implementation (<i>Cluster ID 0x0406</i>).
 * <p>
 * The cluster provides an interface to occupancy sensing functionality,
 * including configuration and provision of notifications of occupancy status.
 * </p>
 * This code is autogenerated. Modifications may be overwritten!
 */
public class ZclOccupancySensingCluster extends ZclCluster {
    // Cluster ID
    private static final int CLUSTER_ID = 0x0406;

    // Attribute constants
    private final int ATTR_OCCUPANCY = 0x0000;
    private final int ATTR_OCCUPANCYSENSORTYPE = 0x0001;
    private final int ATTR_PIROCCUPIEDTOUNOCCUPIEDDELAY = 0x0010;
    private final int ATTR_PIRUNOCCUPIEDTOOCCUPIEDDELAY = 0x0011;
    private final int ATTR_ULTRASONICOCCUPIEDTOUNOCCUPIEDDELAY = 0x0020;
    private final int ATTR_ULTRASONICUNOCCUPIEDTOOCCUPIEDDELAY = 0x0021;
    private final int ATTR_ULTRASONICUNOCCUPIEDTOOCCUPIEDTHRESHOLD = 0x0022;

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(7);

        attributeMap.put(ATTR_OCCUPANCY, new ZclAttribute(0, ZclDataType.BITMAP_8_BIT, true, true, false, true));
        attributeMap.put(ATTR_OCCUPANCYSENSORTYPE, new ZclAttribute(1, ZclDataType.ENUMERATION_8_BIT, true, true, false, false));
        attributeMap.put(ATTR_PIROCCUPIEDTOUNOCCUPIEDDELAY, new ZclAttribute(16, ZclDataType.UNSIGNED_8_BIT_INTEGER, false, true, true, false));
        attributeMap.put(ATTR_PIRUNOCCUPIEDTOOCCUPIEDDELAY, new ZclAttribute(17, ZclDataType.UNSIGNED_8_BIT_INTEGER, false, true, true, false));
        attributeMap.put(ATTR_ULTRASONICOCCUPIEDTOUNOCCUPIEDDELAY, new ZclAttribute(32, ZclDataType.UNSIGNED_8_BIT_INTEGER, false, true, true, false));
        attributeMap.put(ATTR_ULTRASONICUNOCCUPIEDTOOCCUPIEDDELAY, new ZclAttribute(33, ZclDataType.UNSIGNED_8_BIT_INTEGER, false, true, true, false));
        attributeMap.put(ATTR_ULTRASONICUNOCCUPIEDTOOCCUPIEDTHRESHOLD, new ZclAttribute(34, ZclDataType.UNSIGNED_8_BIT_INTEGER, false, true, true, false));

        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclOccupancySensingCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID);
    }



    /**
     * Get the <i>Occupancy</i> attribute
     * <p>
     * The Occupancy attribute is a bitmap.
     * <br>
     * Bit 0 specifies the sensed occupancy as follows: 1 = occupied, 0 = unoccupied.
     * All other bits are reserved.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getOccupancy() {
        return read(ATTR_OCCUPANCY);
    }


    /**
     * Configure reporting for the <i>Occupancy</i> attribute
     * <p>
     * The Occupancy attribute is a bitmap.
     * <br>
     * Bit 0 specifies the sensed occupancy as follows: 1 = occupied, 0 = unoccupied.
     * All other bits are reserved.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param minInterval {@link int} minimum reporting period
     * @param maxInterval {@link int} maximum reporting period
     * @param reportableChange {@link Object} delta required to trigger report
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> configOccupancyReporting(final int minInterval, final int maxInterval, final Object reportableChange) {
        return report(ATTR_OCCUPANCY, minInterval, maxInterval, reportableChange);
    }


    /**
     * Get the <i>OccupancySensorType</i> attribute
     * <p>
     * <br>
     * The OccupancySensorType attribute specifies the type of the occupancy sensor.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getOccupancySensorType() {
        return read(ATTR_OCCUPANCYSENSORTYPE);
    }


    /**
     * Set the <i>PIROccupiedToUnoccupiedDelay</i> attribute
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param pirOccupiedToUnoccupiedDelay the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setPirOccupiedToUnoccupiedDelay(final Object value) {
        return write(ATTR_PIROCCUPIEDTOUNOCCUPIEDDELAY, ZclDataType.UNSIGNED_8_BIT_INTEGER, value);
    }


    /**
     * Get the <i>PIROccupiedToUnoccupiedDelay</i> attribute
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getPirOccupiedToUnoccupiedDelay() {
        return read(ATTR_PIROCCUPIEDTOUNOCCUPIEDDELAY);
    }


    /**
     * Set the <i>PIRUnoccupiedToOccupiedDelay</i> attribute
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param pirUnoccupiedToOccupiedDelay the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setPirUnoccupiedToOccupiedDelay(final Object value) {
        return write(ATTR_PIRUNOCCUPIEDTOOCCUPIEDDELAY, ZclDataType.UNSIGNED_8_BIT_INTEGER, value);
    }


    /**
     * Get the <i>PIRUnoccupiedToOccupiedDelay</i> attribute
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getPirUnoccupiedToOccupiedDelay() {
        return read(ATTR_PIRUNOCCUPIEDTOOCCUPIEDDELAY);
    }


    /**
     * Set the <i>UltraSonicOccupiedToUnoccupiedDelay</i> attribute
     * <p>
     * <br>
     * The UltraSonicOccupiedToUnoccupiedTime attribute specifies the time delay, in
     * seconds, before the ultrasonic sensor changes to its occupied state when the
     * sensed area becomes unoccupied. This attribute, along with
     * UltraSonicUnoccupiedToOccupiedTime, may be used to reduce sensor 'chatter'
     * when used in an area where occupation changes frequently.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param ultraSonicOccupiedToUnoccupiedDelay the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setUltraSonicOccupiedToUnoccupiedDelay(final Object value) {
        return write(ATTR_ULTRASONICOCCUPIEDTOUNOCCUPIEDDELAY, ZclDataType.UNSIGNED_8_BIT_INTEGER, value);
    }


    /**
     * Get the <i>UltraSonicOccupiedToUnoccupiedDelay</i> attribute
     * <p>
     * <br>
     * The UltraSonicOccupiedToUnoccupiedTime attribute specifies the time delay, in
     * seconds, before the ultrasonic sensor changes to its occupied state when the
     * sensed area becomes unoccupied. This attribute, along with
     * UltraSonicUnoccupiedToOccupiedTime, may be used to reduce sensor 'chatter'
     * when used in an area where occupation changes frequently.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getUltraSonicOccupiedToUnoccupiedDelay() {
        return read(ATTR_ULTRASONICOCCUPIEDTOUNOCCUPIEDDELAY);
    }


    /**
     * Set the <i>UltraSonicUnoccupiedToOccupiedDelay</i> attribute
     * <p>
     * <br>
     * The UltraSonicUnoccupiedToOccupiedTime attribute specifies the time delay, in
     * seconds, before the ultrasonic sensor changes to its unoccupied state when the
     * sensed area becomes occupied.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param ultraSonicUnoccupiedToOccupiedDelay the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setUltraSonicUnoccupiedToOccupiedDelay(final Object value) {
        return write(ATTR_ULTRASONICUNOCCUPIEDTOOCCUPIEDDELAY, ZclDataType.UNSIGNED_8_BIT_INTEGER, value);
    }


    /**
     * Get the <i>UltraSonicUnoccupiedToOccupiedDelay</i> attribute
     * <p>
     * <br>
     * The UltraSonicUnoccupiedToOccupiedTime attribute specifies the time delay, in
     * seconds, before the ultrasonic sensor changes to its unoccupied state when the
     * sensed area becomes occupied.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getUltraSonicUnoccupiedToOccupiedDelay() {
        return read(ATTR_ULTRASONICUNOCCUPIEDTOOCCUPIEDDELAY);
    }


    /**
     * Set the <i>UltrasonicUnoccupiedToOccupiedThreshold</i> attribute
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param ultrasonicUnoccupiedToOccupiedThreshold the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setUltrasonicUnoccupiedToOccupiedThreshold(final Object value) {
        return write(ATTR_ULTRASONICUNOCCUPIEDTOOCCUPIEDTHRESHOLD, ZclDataType.UNSIGNED_8_BIT_INTEGER, value);
    }


    /**
     * Get the <i>UltrasonicUnoccupiedToOccupiedThreshold</i> attribute
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getUltrasonicUnoccupiedToOccupiedThreshold() {
        return read(ATTR_ULTRASONICUNOCCUPIEDTOOCCUPIEDTHRESHOLD);
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
