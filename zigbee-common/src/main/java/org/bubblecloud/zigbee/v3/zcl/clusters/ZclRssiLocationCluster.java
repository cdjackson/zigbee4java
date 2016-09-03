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
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.AnchorNodeAnnounceCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.CompactLocationDataNotificationCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.DeviceConfigurationResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.GetDeviceConfigurationCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.GetLocationDataCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.LocationDataNotificationCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.LocationDataResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.ReportRssiMeasurementsCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.RequestOwnLocationCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.RssiPingCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.RssiRequestCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.RssiResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.SendPingsCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.SetAbsoluteLocationCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.rssilocation.SetDeviceConfigurationCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclDataType;

/**
 * <b>RSSI Location</b> cluster implementation (<i>Cluster ID 0x000B</i>).
 * This code is autogenerated. Modifications may be overwritten!
 */
public class ZclRssiLocationCluster extends ZclCluster {
    // Cluster ID
    private static final int CLUSTER_ID = 0x000B;

    // Attribute constants
    private final int ATTR_LOCATIONTYPE = 0x0000;
    private final int ATTR_LOCATIONMETHOD = 0x0001;
    private final int ATTR_LOCATIONAGE = 0x0002;
    private final int ATTR_QUALITYMEASURE = 0x0003;
    private final int ATTR_NUMBEROFDEVICES = 0x0004;
    private final int ATTR_COORDINATE1 = 0x0010;
    private final int ATTR_COORDINATE2 = 0x0011;
    private final int ATTR_COORDINATE3 = 0x0012;
    private final int ATTR_POWER = 0x0013;
    private final int ATTR_PATHLOSSEXPONENT = 0x0014;
    private final int ATTR_REPORTINGPERIOD = 0x0015;
    private final int ATTR_CALCULATIONPERIOD = 0x0016;
    private final int ATTR_NUMBERRSSIMEASUREMENTS = 0x0017;

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(13);

        attributeMap.put(ATTR_LOCATIONTYPE, new ZclAttribute(0, ZclDataType.DATA_8_BIT, true, true, false, false));
        attributeMap.put(ATTR_LOCATIONMETHOD, new ZclAttribute(1, ZclDataType.ENUMERATION_8_BIT, true, true, false, false));
        attributeMap.put(ATTR_LOCATIONAGE, new ZclAttribute(2, ZclDataType.UNSIGNED_16_BIT_INTEGER, false, true, false, false));
        attributeMap.put(ATTR_QUALITYMEASURE, new ZclAttribute(3, ZclDataType.UNSIGNED_8_BIT_INTEGER, false, true, false, false));
        attributeMap.put(ATTR_NUMBEROFDEVICES, new ZclAttribute(4, ZclDataType.UNSIGNED_8_BIT_INTEGER, false, true, false, false));
        attributeMap.put(ATTR_COORDINATE1, new ZclAttribute(16, ZclDataType.SIGNED_16_BIT_INTEGER, true, true, true, false));
        attributeMap.put(ATTR_COORDINATE2, new ZclAttribute(17, ZclDataType.SIGNED_16_BIT_INTEGER, true, true, true, false));
        attributeMap.put(ATTR_COORDINATE3, new ZclAttribute(18, ZclDataType.SIGNED_16_BIT_INTEGER, false, true, true, false));
        attributeMap.put(ATTR_POWER, new ZclAttribute(19, ZclDataType.SIGNED_16_BIT_INTEGER, true, true, true, false));
        attributeMap.put(ATTR_PATHLOSSEXPONENT, new ZclAttribute(20, ZclDataType.SIGNED_16_BIT_INTEGER, true, true, true, false));
        attributeMap.put(ATTR_REPORTINGPERIOD, new ZclAttribute(21, ZclDataType.SIGNED_16_BIT_INTEGER, false, true, true, false));
        attributeMap.put(ATTR_CALCULATIONPERIOD, new ZclAttribute(22, ZclDataType.SIGNED_16_BIT_INTEGER, false, true, true, false));
        attributeMap.put(ATTR_NUMBERRSSIMEASUREMENTS, new ZclAttribute(23, ZclDataType.SIGNED_16_BIT_INTEGER, false, true, true, false));

        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclRssiLocationCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID);
    }



    /**
     * Get the <i>LocationType</i> attribute
     * <p>
     * The LocationType attribute is 8 bits long and is divided into bit fields.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getLocationType() {
        return read(ATTR_LOCATIONTYPE);
    }


    /**
     * Get the <i>LocationMethod</i> attribute
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getLocationMethod() {
        return read(ATTR_LOCATIONMETHOD);
    }


    /**
     * Get the <i>LocationAge</i> attribute
     * <p>
     * <br>
     * The LocationAge attribute indicates the amount of time, measured in seconds, that
     * has transpired since the location information was last calculated. This attribute is
     * not valid if the Absolute bit of the LocationType attribute is set to one.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getLocationAge() {
        return read(ATTR_LOCATIONAGE);
    }


    /**
     * Get the <i>QualityMeasure</i> attribute
     * <p>
     * <br>
     * The QualityMeasure attribute is a measure of confidence in the corresponding
     * location information. The higher the value, the more confident the transmitting
     * device is in the location information. A value of 0x64 indicates complete (100%)
     * confidence and a value of 0x00 indicates zero confidence. (Note: no fixed
     * confidence metric is mandated – the metric may be application and manufacturer
     * dependent).
     * <br>
     * This field is not valid if the Absolute bit of the LocationType attribute is set to one.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getQualityMeasure() {
        return read(ATTR_QUALITYMEASURE);
    }


    /**
     * Get the <i>NumberOfDevices</i> attribute
     * <p>
     * <br>
     * The NumberOfDevices attribute is the number of devices whose location data
     * were used to calculate the last location value. This attribute is related to the
     * QualityMeasure attribute.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getNumberOfDevices() {
        return read(ATTR_NUMBEROFDEVICES);
    }


    /**
     * Set the <i>Coordinate1</i> attribute
     * <p>
     * <br>
     * The Coordinate1, Coordinate2 and Coordinate3 attributes are signed 16-bit
     * integers, and represent orthogonal linear coordinates x, y, z in meters as follows.
     * <br>
     * x = Coordinate1 / 10, y = Coordinate2 / 10, z = Coordinate3 / 10
     * <br>
     * The range of x is -3276.7 to 3276.7 meters, corresponding to Coordinate1
     * between 0x8001 and 0x7fff. The same range applies to y and z. A value of
     * 0x8000 for any of the coordinates indicates that the coordinate is unknown.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param coordinate1 the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setCoordinate1(final Object value) {
        return write(ATTR_COORDINATE1, ZclDataType.SIGNED_16_BIT_INTEGER, value);
    }


    /**
     * Get the <i>Coordinate1</i> attribute
     * <p>
     * <br>
     * The Coordinate1, Coordinate2 and Coordinate3 attributes are signed 16-bit
     * integers, and represent orthogonal linear coordinates x, y, z in meters as follows.
     * <br>
     * x = Coordinate1 / 10, y = Coordinate2 / 10, z = Coordinate3 / 10
     * <br>
     * The range of x is -3276.7 to 3276.7 meters, corresponding to Coordinate1
     * between 0x8001 and 0x7fff. The same range applies to y and z. A value of
     * 0x8000 for any of the coordinates indicates that the coordinate is unknown.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCoordinate1() {
        return read(ATTR_COORDINATE1);
    }


    /**
     * Set the <i>Coordinate2</i> attribute
     * <p>
     * <br>
     * The Coordinate1, Coordinate2 and Coordinate3 attributes are signed 16-bit
     * integers, and represent orthogonal linear coordinates x, y, z in meters as follows.
     * <br>
     * x = Coordinate1 / 10, y = Coordinate2 / 10, z = Coordinate3 / 10
     * <br>
     * The range of x is -3276.7 to 3276.7 meters, corresponding to Coordinate1
     * between 0x8001 and 0x7fff. The same range applies to y and z. A value of
     * 0x8000 for any of the coordinates indicates that the coordinate is unknown.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param coordinate2 the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setCoordinate2(final Object value) {
        return write(ATTR_COORDINATE2, ZclDataType.SIGNED_16_BIT_INTEGER, value);
    }


    /**
     * Get the <i>Coordinate2</i> attribute
     * <p>
     * <br>
     * The Coordinate1, Coordinate2 and Coordinate3 attributes are signed 16-bit
     * integers, and represent orthogonal linear coordinates x, y, z in meters as follows.
     * <br>
     * x = Coordinate1 / 10, y = Coordinate2 / 10, z = Coordinate3 / 10
     * <br>
     * The range of x is -3276.7 to 3276.7 meters, corresponding to Coordinate1
     * between 0x8001 and 0x7fff. The same range applies to y and z. A value of
     * 0x8000 for any of the coordinates indicates that the coordinate is unknown.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCoordinate2() {
        return read(ATTR_COORDINATE2);
    }


    /**
     * Set the <i>Coordinate3</i> attribute
     * <p>
     * <br>
     * The Coordinate1, Coordinate2 and Coordinate3 attributes are signed 16-bit
     * integers, and represent orthogonal linear coordinates x, y, z in meters as follows.
     * <br>
     * x = Coordinate1 / 10, y = Coordinate2 / 10, z = Coordinate3 / 10
     * <br>
     * The range of x is -3276.7 to 3276.7 meters, corresponding to Coordinate1
     * between 0x8001 and 0x7fff. The same range applies to y and z. A value of
     * 0x8000 for any of the coordinates indicates that the coordinate is unknown.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param coordinate3 the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setCoordinate3(final Object value) {
        return write(ATTR_COORDINATE3, ZclDataType.SIGNED_16_BIT_INTEGER, value);
    }


    /**
     * Get the <i>Coordinate3</i> attribute
     * <p>
     * <br>
     * The Coordinate1, Coordinate2 and Coordinate3 attributes are signed 16-bit
     * integers, and represent orthogonal linear coordinates x, y, z in meters as follows.
     * <br>
     * x = Coordinate1 / 10, y = Coordinate2 / 10, z = Coordinate3 / 10
     * <br>
     * The range of x is -3276.7 to 3276.7 meters, corresponding to Coordinate1
     * between 0x8001 and 0x7fff. The same range applies to y and z. A value of
     * 0x8000 for any of the coordinates indicates that the coordinate is unknown.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCoordinate3() {
        return read(ATTR_COORDINATE3);
    }


    /**
     * Set the <i>Power</i> attribute
     * <p>
     * <br>
     * The Power attribute specifies the value of the average power P0, measured in
     * dBm, received at a reference distance of one meter from the transmitter.
     * <br>
     * P0 = Power / 100
     * <br>
     * A value of 0x8000 indicates that Power is unknown.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param power the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setPower(final Object value) {
        return write(ATTR_POWER, ZclDataType.SIGNED_16_BIT_INTEGER, value);
    }


    /**
     * Get the <i>Power</i> attribute
     * <p>
     * <br>
     * The Power attribute specifies the value of the average power P0, measured in
     * dBm, received at a reference distance of one meter from the transmitter.
     * <br>
     * P0 = Power / 100
     * <br>
     * A value of 0x8000 indicates that Power is unknown.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getPower() {
        return read(ATTR_POWER);
    }


    /**
     * Set the <i>PathLossExponent</i> attribute
     * <p>
     * <br>
     * The PathLossExponent attribute specifies the value of the Path Loss Exponent n,
     * an exponent that describes the rate at which the signal power decays with
     * increasing distance from the transmitter.
     * <br>
     * n = PathLossExponent / 100
     * <br>
     * A value of 0xffff indicates that PathLossExponent is unknown.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param pathLossExponent the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setPathLossExponent(final Object value) {
        return write(ATTR_PATHLOSSEXPONENT, ZclDataType.SIGNED_16_BIT_INTEGER, value);
    }


    /**
     * Get the <i>PathLossExponent</i> attribute
     * <p>
     * <br>
     * The PathLossExponent attribute specifies the value of the Path Loss Exponent n,
     * an exponent that describes the rate at which the signal power decays with
     * increasing distance from the transmitter.
     * <br>
     * n = PathLossExponent / 100
     * <br>
     * A value of 0xffff indicates that PathLossExponent is unknown.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getPathLossExponent() {
        return read(ATTR_PATHLOSSEXPONENT);
    }


    /**
     * Set the <i>ReportingPeriod</i> attribute
     * <p>
     * <br>
     * The ReportingPeriod attribute specifies the time in seconds between successive
     * reports of the device's location by means of the Location Data Notification
     * command. The minimum value this attribute can take is specified by the profile in
     * use. If ReportingPeriod is zero, the device does not automatically report its
     * location. Note that location information can always be polled at any time.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param reportingPeriod the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setReportingPeriod(final Object value) {
        return write(ATTR_REPORTINGPERIOD, ZclDataType.SIGNED_16_BIT_INTEGER, value);
    }


    /**
     * Get the <i>ReportingPeriod</i> attribute
     * <p>
     * <br>
     * The ReportingPeriod attribute specifies the time in seconds between successive
     * reports of the device's location by means of the Location Data Notification
     * command. The minimum value this attribute can take is specified by the profile in
     * use. If ReportingPeriod is zero, the device does not automatically report its
     * location. Note that location information can always be polled at any time.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getReportingPeriod() {
        return read(ATTR_REPORTINGPERIOD);
    }


    /**
     * Set the <i>CalculationPeriod</i> attribute
     * <p>
     * <br>
     * The CalculationPeriod attribute specifies the time in seconds between successive
     * calculations of the device's location. If CalculationPeriod is less than the
     * physically possible minimum period that the calculation can be performed, the
     * calculation will be repeated as frequently as possible.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param calculationPeriod the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setCalculationPeriod(final Object value) {
        return write(ATTR_CALCULATIONPERIOD, ZclDataType.SIGNED_16_BIT_INTEGER, value);
    }


    /**
     * Get the <i>CalculationPeriod</i> attribute
     * <p>
     * <br>
     * The CalculationPeriod attribute specifies the time in seconds between successive
     * calculations of the device's location. If CalculationPeriod is less than the
     * physically possible minimum period that the calculation can be performed, the
     * calculation will be repeated as frequently as possible.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCalculationPeriod() {
        return read(ATTR_CALCULATIONPERIOD);
    }


    /**
     * Set the <i>NumberRSSIMeasurements</i> attribute
     * <p>
     * <br>
     * The NumberRSSIMeasurements attribute specifies the number of RSSI
     * measurements to be used to generate one location estimate. The measurements are
     * averaged to improve accuracy. NumberRSSIMeasurements must be greater than or
     * equal to 1.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param numberRssiMeasurements the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setNumberRssiMeasurements(final Object value) {
        return write(ATTR_NUMBERRSSIMEASUREMENTS, ZclDataType.SIGNED_16_BIT_INTEGER, value);
    }


    /**
     * Get the <i>NumberRSSIMeasurements</i> attribute
     * <p>
     * <br>
     * The NumberRSSIMeasurements attribute specifies the number of RSSI
     * measurements to be used to generate one location estimate. The measurements are
     * averaged to improve accuracy. NumberRSSIMeasurements must be greater than or
     * equal to 1.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getNumberRssiMeasurements() {
        return read(ATTR_NUMBERRSSIMEASUREMENTS);
    }


    /**
     * The Set Absolute Location Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setAbsoluteLocationCommand() {
        return send(new SetAbsoluteLocationCommand());
    }


    /**
     * The Set Device Configuration Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setDeviceConfigurationCommand() {
        return send(new SetDeviceConfigurationCommand());
    }


    /**
     * The Get Device Configuration Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getDeviceConfigurationCommand() {
        return send(new GetDeviceConfigurationCommand());
    }


    /**
     * The Get Location Data Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getLocationDataCommand() {
        return send(new GetLocationDataCommand());
    }


    /**
     * The  RSSI Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> rssiResponse() {
        return send(new RssiResponse());
    }


    /**
     * The Send Pings Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> sendPingsCommand() {
        return send(new SendPingsCommand());
    }


    /**
     * The Anchor Node Announce Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> anchorNodeAnnounceCommand() {
        return send(new AnchorNodeAnnounceCommand());
    }


    /**
     * The  Device Configuration Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> deviceConfigurationResponse() {
        return send(new DeviceConfigurationResponse());
    }


    /**
     * The  Location Data Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> locationDataResponse() {
        return send(new LocationDataResponse());
    }


    /**
     * The Location Data Notification Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> locationDataNotificationCommand() {
        return send(new LocationDataNotificationCommand());
    }


    /**
     * The Compact Location Data Notification Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> compactLocationDataNotificationCommand() {
        return send(new CompactLocationDataNotificationCommand());
    }


    /**
     * The RSSI Ping Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> rssiPingCommand() {
        return send(new RssiPingCommand());
    }


    /**
     * The RSSI Request Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> rssiRequestCommand() {
        return send(new RssiRequestCommand());
    }


    /**
     * The Report RSSI Measurements Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> reportRssiMeasurementsCommand() {
        return send(new ReportRssiMeasurementsCommand());
    }


    /**
     * The Request Own Location Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> requestOwnLocationCommand() {
        return send(new RequestOwnLocationCommand());
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
