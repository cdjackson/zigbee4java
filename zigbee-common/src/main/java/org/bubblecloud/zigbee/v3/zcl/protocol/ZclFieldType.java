package org.bubblecloud.zigbee.v3.zcl.protocol;

public enum ZclFieldType {
    IDENTIFY_COMMAND_IDENTIFY_TIME(0, ZclCommandType.IDENTIFY_COMMAND, "Identify Time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    IDENTIFY_QUERY_RESPONSE_IDENTIFY_TIME(0, ZclCommandType.IDENTIFY_QUERY_RESPONSE, "Identify Time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ADD_GROUP_COMMAND_GROUP_ID(0, ZclCommandType.ADD_GROUP_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ADD_GROUP_COMMAND_GROUP_NAME(1, ZclCommandType.ADD_GROUP_COMMAND, "Group Name",ZclDataType.CHARACTER_STRING),
    VIEW_GROUP_COMMAND_GROUP_ID(0, ZclCommandType.VIEW_GROUP_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    GET_GROUP_MEMBERSHIP_COMMAND_GROUP_COUNT(0, ZclCommandType.GET_GROUP_MEMBERSHIP_COMMAND, "Group count",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    GET_GROUP_MEMBERSHIP_COMMAND_GROUP_LIST(1, ZclCommandType.GET_GROUP_MEMBERSHIP_COMMAND, "Group list",ZclDataType.N_X_UNSIGNED_16_BIT_INTEGER),
    REMOVE_GROUP_COMMAND_GROUP_ID(0, ZclCommandType.REMOVE_GROUP_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ADD_GROUP_IF_IDENTIFYING_COMMAND_GROUP_ID(0, ZclCommandType.ADD_GROUP_IF_IDENTIFYING_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ADD_GROUP_IF_IDENTIFYING_COMMAND_GROUP_NAME(1, ZclCommandType.ADD_GROUP_IF_IDENTIFYING_COMMAND, "Group Name",ZclDataType.CHARACTER_STRING),
    ADD_GROUP_RESPONSE_STATUS(0, ZclCommandType.ADD_GROUP_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    ADD_GROUP_RESPONSE_GROUP_ID(1, ZclCommandType.ADD_GROUP_RESPONSE, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    VIEW_GROUP_RESPONSE_STATUS(0, ZclCommandType.VIEW_GROUP_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    VIEW_GROUP_RESPONSE_GROUP_ID(1, ZclCommandType.VIEW_GROUP_RESPONSE, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    VIEW_GROUP_RESPONSE_GROUP_NAME(2, ZclCommandType.VIEW_GROUP_RESPONSE, "Group Name",ZclDataType.CHARACTER_STRING),
    GET_GROUP_MEMBERSHIP_RESPONSE_CAPACITY(0, ZclCommandType.GET_GROUP_MEMBERSHIP_RESPONSE, "Capacity",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    GET_GROUP_MEMBERSHIP_RESPONSE_GROUP_COUNT(1, ZclCommandType.GET_GROUP_MEMBERSHIP_RESPONSE, "Group count",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    GET_GROUP_MEMBERSHIP_RESPONSE_GROUP_LIST(2, ZclCommandType.GET_GROUP_MEMBERSHIP_RESPONSE, "Group list",ZclDataType.N_X_UNSIGNED_16_BIT_INTEGER),
    REMOVE_GROUP_RESPONSE_STATUS(0, ZclCommandType.REMOVE_GROUP_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    REMOVE_GROUP_RESPONSE_GROUP_ID(1, ZclCommandType.REMOVE_GROUP_RESPONSE, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ADD_SCENE_COMMAND_GROUP_ID(0, ZclCommandType.ADD_SCENE_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ADD_SCENE_COMMAND_SCENE_ID(1, ZclCommandType.ADD_SCENE_COMMAND, "Scene ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    ADD_SCENE_COMMAND_TRANSITION_TIME(2, ZclCommandType.ADD_SCENE_COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ADD_SCENE_COMMAND_SCENE_NAME(3, ZclCommandType.ADD_SCENE_COMMAND, "Scene Name",ZclDataType.CHARACTER_STRING),
    ADD_SCENE_COMMAND_EXTENSION_FIELD_SETS(4, ZclCommandType.ADD_SCENE_COMMAND, "Extension field sets",ZclDataType.N_X_EXTENSION_FIELD_SET),
    VIEW_SCENE_COMMAND_GROUP_ID(0, ZclCommandType.VIEW_SCENE_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    VIEW_SCENE_COMMAND_SCENE_ID(1, ZclCommandType.VIEW_SCENE_COMMAND, "Scene ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    REMOVE_SCENE_COMMAND_GROUP_ID(0, ZclCommandType.REMOVE_SCENE_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    REMOVE_SCENE_COMMAND_SCENE_ID(1, ZclCommandType.REMOVE_SCENE_COMMAND, "Scene ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    REMOVE_ALL_SCENES_COMMAND_GROUP_ID(0, ZclCommandType.REMOVE_ALL_SCENES_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    STORE_SCENE_COMMAND_GROUP_ID(0, ZclCommandType.STORE_SCENE_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    STORE_SCENE_COMMAND_SCENE_ID(1, ZclCommandType.STORE_SCENE_COMMAND, "Scene ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    RECALL_SCENE_COMMAND_GROUP_ID(0, ZclCommandType.RECALL_SCENE_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    RECALL_SCENE_COMMAND_SCENE_ID(1, ZclCommandType.RECALL_SCENE_COMMAND, "Scene ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    GET_SCENE_MEMBERSHIP_COMMAND_GROUP_ID(0, ZclCommandType.GET_SCENE_MEMBERSHIP_COMMAND, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ADD_SCENE_RESPONSE_STATUS(0, ZclCommandType.ADD_SCENE_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    ADD_SCENE_RESPONSE_GROUP_ID(1, ZclCommandType.ADD_SCENE_RESPONSE, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ADD_SCENE_RESPONSE_SCENE_ID(2, ZclCommandType.ADD_SCENE_RESPONSE, "Scene ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    VIEW_SCENE_RESPONSE_STATUS(0, ZclCommandType.VIEW_SCENE_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    VIEW_SCENE_RESPONSE_GROUP_ID(1, ZclCommandType.VIEW_SCENE_RESPONSE, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    VIEW_SCENE_RESPONSE_SCENE_ID(2, ZclCommandType.VIEW_SCENE_RESPONSE, "Scene ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    VIEW_SCENE_RESPONSE_TRANSITION_TIME(3, ZclCommandType.VIEW_SCENE_RESPONSE, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    VIEW_SCENE_RESPONSE_SCENE_NAME(4, ZclCommandType.VIEW_SCENE_RESPONSE, "Scene Name",ZclDataType.CHARACTER_STRING),
    VIEW_SCENE_RESPONSE_EXTENSION_FIELD_SETS(5, ZclCommandType.VIEW_SCENE_RESPONSE, "Extension field sets",ZclDataType.N_X_EXTENSION_FIELD_SET),
    REMOVE_SCENE_RESPONSE_STATUS(0, ZclCommandType.REMOVE_SCENE_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    REMOVE_SCENE_RESPONSE_GROUP_ID(1, ZclCommandType.REMOVE_SCENE_RESPONSE, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    REMOVE_SCENE_RESPONSE_SCENE_ID(2, ZclCommandType.REMOVE_SCENE_RESPONSE, "Scene ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    REMOVE_ALL_SCENES_RESPONSE_STATUS(0, ZclCommandType.REMOVE_ALL_SCENES_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    REMOVE_ALL_SCENES_RESPONSE_GROUP_ID(1, ZclCommandType.REMOVE_ALL_SCENES_RESPONSE, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    STORE_SCENE_RESPONSE_STATUS(0, ZclCommandType.STORE_SCENE_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    STORE_SCENE_RESPONSE_GROUP_ID(1, ZclCommandType.STORE_SCENE_RESPONSE, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    STORE_SCENE_RESPONSE_SCENE_ID(2, ZclCommandType.STORE_SCENE_RESPONSE, "Scene ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    GET_SCENE_MEMBERSHIP_RESPONSE_STATUS(0, ZclCommandType.GET_SCENE_MEMBERSHIP_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    GET_SCENE_MEMBERSHIP_RESPONSE_CAPACITY(1, ZclCommandType.GET_SCENE_MEMBERSHIP_RESPONSE, "Capacity",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    GET_SCENE_MEMBERSHIP_RESPONSE_GROUP_ID(2, ZclCommandType.GET_SCENE_MEMBERSHIP_RESPONSE, "Group ID",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    GET_SCENE_MEMBERSHIP_RESPONSE_SCENE_COUNT(3, ZclCommandType.GET_SCENE_MEMBERSHIP_RESPONSE, "Scene count",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    GET_SCENE_MEMBERSHIP_RESPONSE_SCENE_LIST(4, ZclCommandType.GET_SCENE_MEMBERSHIP_RESPONSE, "Scene list",ZclDataType.N_X_UNSIGNED_8_BIT_INTEGER),
    MOVE_TO_LEVEL_COMMAND_LEVEL(0, ZclCommandType.MOVE_TO_LEVEL_COMMAND, "Level",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    MOVE_TO_LEVEL_COMMAND_TRANSITION_TIME(1, ZclCommandType.MOVE_TO_LEVEL_COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE_COMMAND_MOVE_MODE(0, ZclCommandType.MOVE_COMMAND, "Move mode",ZclDataType.ENUMERATION_8_BIT),
    MOVE_COMMAND_RATE(1, ZclCommandType.MOVE_COMMAND, "Rate",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    STEP_COMMAND_STEP_MODE(0, ZclCommandType.STEP_COMMAND, "Step mode",ZclDataType.ENUMERATION_8_BIT),
    STEP_COMMAND_STEP_SIZE(1, ZclCommandType.STEP_COMMAND, "Step size",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    STEP_COMMAND_TRANSITION_TIME(2, ZclCommandType.STEP_COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE_TO_LEVEL__WITH_ON_OFF__COMMAND_LEVEL(0, ZclCommandType.MOVE_TO_LEVEL__WITH_ON_OFF__COMMAND, "Level",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    MOVE_TO_LEVEL__WITH_ON_OFF__COMMAND_TRANSITION_TIME(1, ZclCommandType.MOVE_TO_LEVEL__WITH_ON_OFF__COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE__WITH_ON_OFF__COMMAND_MOVE_MODE(0, ZclCommandType.MOVE__WITH_ON_OFF__COMMAND, "Move mode",ZclDataType.ENUMERATION_8_BIT),
    MOVE__WITH_ON_OFF__COMMAND_RATE(1, ZclCommandType.MOVE__WITH_ON_OFF__COMMAND, "Rate",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    STEP__WITH_ON_OFF__COMMAND_STEP_MODE(0, ZclCommandType.STEP__WITH_ON_OFF__COMMAND, "Step mode",ZclDataType.ENUMERATION_8_BIT),
    STEP__WITH_ON_OFF__COMMAND_STEP_SIZE(1, ZclCommandType.STEP__WITH_ON_OFF__COMMAND, "Step size",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    STEP__WITH_ON_OFF__COMMAND_TRANSITION_TIME(2, ZclCommandType.STEP__WITH_ON_OFF__COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    RESET_ALARM_COMMAND_ALARM_CODE(0, ZclCommandType.RESET_ALARM_COMMAND, "Alarm code",ZclDataType.ENUMERATION_8_BIT),
    RESET_ALARM_COMMAND_CLUSTER_IDENTIFIER(1, ZclCommandType.RESET_ALARM_COMMAND, "Cluster identifier",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ALARM_COMMAND_ALARM_CODE(0, ZclCommandType.ALARM_COMMAND, "Alarm code",ZclDataType.ENUMERATION_8_BIT),
    ALARM_COMMAND_CLUSTER_IDENTIFIER(1, ZclCommandType.ALARM_COMMAND, "Cluster identifier",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    GET_ALARM_RESPONSE_STATUS(0, ZclCommandType.GET_ALARM_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    GET_ALARM_RESPONSE_ALARM_CODE(1, ZclCommandType.GET_ALARM_RESPONSE, "Alarm code",ZclDataType.ENUMERATION_8_BIT),
    GET_ALARM_RESPONSE_CLUSTER_IDENTIFIER(2, ZclCommandType.GET_ALARM_RESPONSE, "Cluster identifier",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    GET_ALARM_RESPONSE_TIMESTAMP(3, ZclCommandType.GET_ALARM_RESPONSE, "Timestamp",ZclDataType.UNSIGNED_32_BIT_INTEGER),
    SET_ABSOLUTE_LOCATION_COMMAND_COORDINATE_1(0, ZclCommandType.SET_ABSOLUTE_LOCATION_COMMAND, "Coordinate 1",ZclDataType.SIGNED_16_BIT_INTEGER),
    SET_ABSOLUTE_LOCATION_COMMAND_COORDINATE_2(1, ZclCommandType.SET_ABSOLUTE_LOCATION_COMMAND, "Coordinate 2",ZclDataType.SIGNED_16_BIT_INTEGER),
    SET_ABSOLUTE_LOCATION_COMMAND_COORDINATE_3(2, ZclCommandType.SET_ABSOLUTE_LOCATION_COMMAND, "Coordinate 3",ZclDataType.SIGNED_16_BIT_INTEGER),
    SET_ABSOLUTE_LOCATION_COMMAND_POWER(3, ZclCommandType.SET_ABSOLUTE_LOCATION_COMMAND, "Power",ZclDataType.SIGNED_16_BIT_INTEGER),
    SET_ABSOLUTE_LOCATION_COMMAND_PATH_LOSS_EXPONENT(4, ZclCommandType.SET_ABSOLUTE_LOCATION_COMMAND, "Path Loss Exponent",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    SET_DEVICE_CONFIGURATION_COMMAND_POWER(0, ZclCommandType.SET_DEVICE_CONFIGURATION_COMMAND, "Power",ZclDataType.SIGNED_16_BIT_INTEGER),
    SET_DEVICE_CONFIGURATION_COMMAND_PATH_LOSS_EXPONENT(1, ZclCommandType.SET_DEVICE_CONFIGURATION_COMMAND, "Path Loss Exponent",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    SET_DEVICE_CONFIGURATION_COMMAND_CALCULATION_PERIOD(2, ZclCommandType.SET_DEVICE_CONFIGURATION_COMMAND, "Calculation Period",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    SET_DEVICE_CONFIGURATION_COMMAND_NUMBER_RSSI_MEASUREMENTS(3, ZclCommandType.SET_DEVICE_CONFIGURATION_COMMAND, "Number RSSI Measurements",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    SET_DEVICE_CONFIGURATION_COMMAND_REPORTING_PERIOD(4, ZclCommandType.SET_DEVICE_CONFIGURATION_COMMAND, "Reporting Period",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    GET_DEVICE_CONFIGURATION_COMMAND_TARGET_ADDRESS(0, ZclCommandType.GET_DEVICE_CONFIGURATION_COMMAND, "Target Address",ZclDataType.IEEE_ADDRESS),
    GET_LOCATION_DATA_COMMAND_HEADER(0, ZclCommandType.GET_LOCATION_DATA_COMMAND, "Header",ZclDataType.BITMAP_8_BIT),
    GET_LOCATION_DATA_COMMAND_NUMBER_RESPONSES(1, ZclCommandType.GET_LOCATION_DATA_COMMAND, "Number Responses",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    GET_LOCATION_DATA_COMMAND_TARGET_ADDRESS(2, ZclCommandType.GET_LOCATION_DATA_COMMAND, "Target Address",ZclDataType.IEEE_ADDRESS),
    RSSI_RESPONSE_REPLYING_DEVICE(0, ZclCommandType.RSSI_RESPONSE, "Replying Device",ZclDataType.IEEE_ADDRESS),
    RSSI_RESPONSE_COORDINATE_1(1, ZclCommandType.RSSI_RESPONSE, "Coordinate 1",ZclDataType.SIGNED_16_BIT_INTEGER),
    RSSI_RESPONSE_COORDINATE_2(2, ZclCommandType.RSSI_RESPONSE, "Coordinate 2",ZclDataType.SIGNED_16_BIT_INTEGER),
    RSSI_RESPONSE_COORDINATE_3(3, ZclCommandType.RSSI_RESPONSE, "Coordinate 3",ZclDataType.SIGNED_16_BIT_INTEGER),
    RSSI_RESPONSE_RSSI(4, ZclCommandType.RSSI_RESPONSE, "RSSI",ZclDataType.SIGNED_8_BIT_INTEGER),
    RSSI_RESPONSE_NUMBER_RSSI_MEASUREMENTS(5, ZclCommandType.RSSI_RESPONSE, "Number RSSI Measurements",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    SEND_PINGS_COMMAND_TARGET_ADDRESS(0, ZclCommandType.SEND_PINGS_COMMAND, "Target Address",ZclDataType.IEEE_ADDRESS),
    SEND_PINGS_COMMAND_NUMBER_RSSI_MEASUREMENTS(1, ZclCommandType.SEND_PINGS_COMMAND, "Number RSSI Measurements",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    SEND_PINGS_COMMAND_CALCULATION_PERIOD(2, ZclCommandType.SEND_PINGS_COMMAND, "Calculation Period",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ANCHOR_NODE_ANNOUNCE_COMMAND_ANCHOR_NODE_ADDRESS(0, ZclCommandType.ANCHOR_NODE_ANNOUNCE_COMMAND, "Anchor Node Address",ZclDataType.IEEE_ADDRESS),
    ANCHOR_NODE_ANNOUNCE_COMMAND_COORDINATE_1(1, ZclCommandType.ANCHOR_NODE_ANNOUNCE_COMMAND, "Coordinate 1",ZclDataType.SIGNED_16_BIT_INTEGER),
    ANCHOR_NODE_ANNOUNCE_COMMAND_COORDINATE_2(2, ZclCommandType.ANCHOR_NODE_ANNOUNCE_COMMAND, "Coordinate 2",ZclDataType.SIGNED_16_BIT_INTEGER),
    ANCHOR_NODE_ANNOUNCE_COMMAND_COORDINATE_3(3, ZclCommandType.ANCHOR_NODE_ANNOUNCE_COMMAND, "Coordinate 3",ZclDataType.SIGNED_16_BIT_INTEGER),
    DEVICE_CONFIGURATION_RESPONSE_STATUS(0, ZclCommandType.DEVICE_CONFIGURATION_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    DEVICE_CONFIGURATION_RESPONSE_POWER(1, ZclCommandType.DEVICE_CONFIGURATION_RESPONSE, "Power",ZclDataType.SIGNED_16_BIT_INTEGER),
    DEVICE_CONFIGURATION_RESPONSE_PATH_LOSS_EXPONENT(2, ZclCommandType.DEVICE_CONFIGURATION_RESPONSE, "Path Loss Exponent",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    DEVICE_CONFIGURATION_RESPONSE_CALCULATION_PERIOD(3, ZclCommandType.DEVICE_CONFIGURATION_RESPONSE, "Calculation Period",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    DEVICE_CONFIGURATION_RESPONSE_NUMBER_RSSI_MEASUREMENTS(4, ZclCommandType.DEVICE_CONFIGURATION_RESPONSE, "Number RSSI Measurements",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    DEVICE_CONFIGURATION_RESPONSE_REPORTING_PERIOD(5, ZclCommandType.DEVICE_CONFIGURATION_RESPONSE, "Reporting Period",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    LOCATION_DATA_RESPONSE_STATUS(0, ZclCommandType.LOCATION_DATA_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    LOCATION_DATA_RESPONSE_LOCATION_TYPE(1, ZclCommandType.LOCATION_DATA_RESPONSE, "Location Type",ZclDataType.DATA_8_BIT),
    LOCATION_DATA_RESPONSE_COORDINATE_1(2, ZclCommandType.LOCATION_DATA_RESPONSE, "Coordinate 1",ZclDataType.SIGNED_16_BIT_INTEGER),
    LOCATION_DATA_RESPONSE_COORDINATE_2(3, ZclCommandType.LOCATION_DATA_RESPONSE, "Coordinate 2",ZclDataType.SIGNED_16_BIT_INTEGER),
    LOCATION_DATA_RESPONSE_COORDINATE_3(4, ZclCommandType.LOCATION_DATA_RESPONSE, "Coordinate 3",ZclDataType.SIGNED_16_BIT_INTEGER),
    LOCATION_DATA_RESPONSE_POWER(5, ZclCommandType.LOCATION_DATA_RESPONSE, "Power",ZclDataType.SIGNED_16_BIT_INTEGER),
    LOCATION_DATA_RESPONSE_PATH_LOSS_EXPONENT(6, ZclCommandType.LOCATION_DATA_RESPONSE, "Path Loss Exponent",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    LOCATION_DATA_RESPONSE_LOCATION_METHOD(7, ZclCommandType.LOCATION_DATA_RESPONSE, "Location Method",ZclDataType.ENUMERATION_8_BIT),
    LOCATION_DATA_RESPONSE_QUALITY_MEASURE(8, ZclCommandType.LOCATION_DATA_RESPONSE, "Quality Measure",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    LOCATION_DATA_RESPONSE_LOCATION_AGE(9, ZclCommandType.LOCATION_DATA_RESPONSE, "Location Age",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    LOCATION_DATA_NOTIFICATION_COMMAND_LOCATION_TYPE(0, ZclCommandType.LOCATION_DATA_NOTIFICATION_COMMAND, "Location Type",ZclDataType.DATA_8_BIT),
    LOCATION_DATA_NOTIFICATION_COMMAND_COORDINATE_1(1, ZclCommandType.LOCATION_DATA_NOTIFICATION_COMMAND, "Coordinate 1",ZclDataType.SIGNED_16_BIT_INTEGER),
    LOCATION_DATA_NOTIFICATION_COMMAND_COORDINATE_2(2, ZclCommandType.LOCATION_DATA_NOTIFICATION_COMMAND, "Coordinate 2",ZclDataType.SIGNED_16_BIT_INTEGER),
    LOCATION_DATA_NOTIFICATION_COMMAND_COORDINATE_3(3, ZclCommandType.LOCATION_DATA_NOTIFICATION_COMMAND, "Coordinate 3",ZclDataType.SIGNED_16_BIT_INTEGER),
    LOCATION_DATA_NOTIFICATION_COMMAND_POWER(4, ZclCommandType.LOCATION_DATA_NOTIFICATION_COMMAND, "Power",ZclDataType.SIGNED_16_BIT_INTEGER),
    LOCATION_DATA_NOTIFICATION_COMMAND_PATH_LOSS_EXPONENT(5, ZclCommandType.LOCATION_DATA_NOTIFICATION_COMMAND, "Path Loss Exponent",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    LOCATION_DATA_NOTIFICATION_COMMAND_LOCATION_METHOD(6, ZclCommandType.LOCATION_DATA_NOTIFICATION_COMMAND, "Location Method",ZclDataType.ENUMERATION_8_BIT),
    LOCATION_DATA_NOTIFICATION_COMMAND_QUALITY_MEASURE(7, ZclCommandType.LOCATION_DATA_NOTIFICATION_COMMAND, "Quality Measure",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    LOCATION_DATA_NOTIFICATION_COMMAND_LOCATION_AGE(8, ZclCommandType.LOCATION_DATA_NOTIFICATION_COMMAND, "Location Age",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    RSSI_PING_COMMAND_LOCATION_TYPE(0, ZclCommandType.RSSI_PING_COMMAND, "Location Type",ZclDataType.DATA_8_BIT),
    REPORT_RSSI_MEASUREMENTS_COMMAND_REPORTING_ADDRESS(0, ZclCommandType.REPORT_RSSI_MEASUREMENTS_COMMAND, "Reporting Address",ZclDataType.IEEE_ADDRESS),
    REPORT_RSSI_MEASUREMENTS_COMMAND_NUMBER_OF_NEIGHBORS(1, ZclCommandType.REPORT_RSSI_MEASUREMENTS_COMMAND, "Number of Neighbors",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    REPORT_RSSI_MEASUREMENTS_COMMAND_NEIGHBORS_INFORMATION(2, ZclCommandType.REPORT_RSSI_MEASUREMENTS_COMMAND, "Neighbors Information",ZclDataType.N_X_NEIGHBORS_INFORMATION),
    REQUEST_OWN_LOCATION_COMMAND_REQUESTING_ADDRESS(0, ZclCommandType.REQUEST_OWN_LOCATION_COMMAND, "Requesting Address",ZclDataType.IEEE_ADDRESS),
    RESTART_DEVICE_COMMAND_OPTION(0, ZclCommandType.RESTART_DEVICE_COMMAND, "Option",ZclDataType.BITMAP_8_BIT),
    RESTART_DEVICE_COMMAND_DELAY(1, ZclCommandType.RESTART_DEVICE_COMMAND, "Delay",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    RESTART_DEVICE_COMMAND_JITTER(2, ZclCommandType.RESTART_DEVICE_COMMAND, "Jitter",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    SAVE_STARTUP_PARAMETERS_COMMAND_OPTION(0, ZclCommandType.SAVE_STARTUP_PARAMETERS_COMMAND, "Option",ZclDataType.BITMAP_8_BIT),
    SAVE_STARTUP_PARAMETERS_COMMAND_INDEX(1, ZclCommandType.SAVE_STARTUP_PARAMETERS_COMMAND, "Index",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    RESTORE_STARTUP_PARAMETERS_COMMAND_OPTION(0, ZclCommandType.RESTORE_STARTUP_PARAMETERS_COMMAND, "Option",ZclDataType.BITMAP_8_BIT),
    RESTORE_STARTUP_PARAMETERS_COMMAND_INDEX(1, ZclCommandType.RESTORE_STARTUP_PARAMETERS_COMMAND, "Index",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    RESET_STARTUP_PARAMETERS_COMMAND_OPTION(0, ZclCommandType.RESET_STARTUP_PARAMETERS_COMMAND, "Option",ZclDataType.BITMAP_8_BIT),
    RESET_STARTUP_PARAMETERS_COMMAND_INDEX(1, ZclCommandType.RESET_STARTUP_PARAMETERS_COMMAND, "Index",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    RESTART_DEVICE_RESPONSE_RESPONSE_STATUS(0, ZclCommandType.RESTART_DEVICE_RESPONSE_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    SAVE_STARTUP_PARAMETERS_RESPONSE_STATUS(0, ZclCommandType.SAVE_STARTUP_PARAMETERS_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    RESTORE_STARTUP_PARAMETERS_RESPONSE_STATUS(0, ZclCommandType.RESTORE_STARTUP_PARAMETERS_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    RESET_STARTUP_PARAMETERS_RESPONSE_STATUS(0, ZclCommandType.RESET_STARTUP_PARAMETERS_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    LOCK_DOOR_COMMAND_PIN_CODE(0, ZclCommandType.LOCK_DOOR_COMMAND, "Pin code",ZclDataType.OCTET_STRING),
    UNLOCK_DOOR_COMMAND_PIN_CODE(0, ZclCommandType.UNLOCK_DOOR_COMMAND, "Pin code",ZclDataType.OCTET_STRING),
    LOCK_DOOR_RESPONSE_STATUS(0, ZclCommandType.LOCK_DOOR_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    UNLOCK_DOOR_RESPONSE_STATUS(0, ZclCommandType.UNLOCK_DOOR_RESPONSE, "Status",ZclDataType.ENUMERATION_8_BIT),
    SETPOINT_RAISE_LOWER_COMMAND_MODE(0, ZclCommandType.SETPOINT_RAISE_LOWER_COMMAND, "Mode",ZclDataType.ENUMERATION_8_BIT),
    SETPOINT_RAISE_LOWER_COMMAND_AMOUNT(1, ZclCommandType.SETPOINT_RAISE_LOWER_COMMAND, "Amount",ZclDataType.SIGNED_8_BIT_INTEGER),
    MOVE_TO_HUE_COMMAND_HUE(0, ZclCommandType.MOVE_TO_HUE_COMMAND, "Hue",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    MOVE_TO_HUE_COMMAND_DIRECTION(1, ZclCommandType.MOVE_TO_HUE_COMMAND, "Direction",ZclDataType.ENUMERATION_8_BIT),
    MOVE_TO_HUE_COMMAND_TRANSITION_TIME(2, ZclCommandType.MOVE_TO_HUE_COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE_HUE_COMMAND_MOVE_MODE(0, ZclCommandType.MOVE_HUE_COMMAND, "Move mode",ZclDataType.ENUMERATION_8_BIT),
    MOVE_HUE_COMMAND_RATE(1, ZclCommandType.MOVE_HUE_COMMAND, "Rate",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    STEP_HUE_COMMAND_STEP_MODE(0, ZclCommandType.STEP_HUE_COMMAND, "Step mode",ZclDataType.ENUMERATION_8_BIT),
    STEP_HUE_COMMAND_STEP_SIZE(1, ZclCommandType.STEP_HUE_COMMAND, "Step size",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    STEP_HUE_COMMAND_TRANSITION_TIME(2, ZclCommandType.STEP_HUE_COMMAND, "Transition time",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    MOVE_TO_SATURATION_COMMAND_SATURATION(0, ZclCommandType.MOVE_TO_SATURATION_COMMAND, "Saturation",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    MOVE_TO_SATURATION_COMMAND_TRANSITION_TIME(1, ZclCommandType.MOVE_TO_SATURATION_COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE_SATURATION_COMMAND_MOVE_MODE(0, ZclCommandType.MOVE_SATURATION_COMMAND, "Move mode",ZclDataType.ENUMERATION_8_BIT),
    MOVE_SATURATION_COMMAND_RATE(1, ZclCommandType.MOVE_SATURATION_COMMAND, "Rate",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    STEP_SATURATION_COMMAND_STEP_MODE(0, ZclCommandType.STEP_SATURATION_COMMAND, "Step mode",ZclDataType.ENUMERATION_8_BIT),
    STEP_SATURATION_COMMAND_STEP_SIZE(1, ZclCommandType.STEP_SATURATION_COMMAND, "Step size",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    STEP_SATURATION_COMMAND_TRANSITION_TIME(2, ZclCommandType.STEP_SATURATION_COMMAND, "Transition time",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    MOVE_TO_HUE_AND_SATURATION_COMMAND_HUE(0, ZclCommandType.MOVE_TO_HUE_AND_SATURATION_COMMAND, "Hue",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    MOVE_TO_HUE_AND_SATURATION_COMMAND_SATURATION(1, ZclCommandType.MOVE_TO_HUE_AND_SATURATION_COMMAND, "Saturation",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    MOVE_TO_HUE_AND_SATURATION_COMMAND_TRANSITION_TIME(2, ZclCommandType.MOVE_TO_HUE_AND_SATURATION_COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE_TO_COLOR_COMMAND_COLORX(0, ZclCommandType.MOVE_TO_COLOR_COMMAND, "ColorX",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE_TO_COLOR_COMMAND_COLORY(1, ZclCommandType.MOVE_TO_COLOR_COMMAND, "ColorY",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE_TO_COLOR_COMMAND_TRANSITION_TIME(2, ZclCommandType.MOVE_TO_COLOR_COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE_COLOR_COMMAND_RATEX(0, ZclCommandType.MOVE_COLOR_COMMAND, "RateX",ZclDataType.SIGNED_16_BIT_INTEGER),
    MOVE_COLOR_COMMAND_RATEY(1, ZclCommandType.MOVE_COLOR_COMMAND, "RateY",ZclDataType.SIGNED_16_BIT_INTEGER),
    STEP_COLOR_COMMAND_STEPX(0, ZclCommandType.STEP_COLOR_COMMAND, "StepX",ZclDataType.SIGNED_16_BIT_INTEGER),
    STEP_COLOR_COMMAND_STEPY(1, ZclCommandType.STEP_COLOR_COMMAND, "StepY",ZclDataType.SIGNED_16_BIT_INTEGER),
    STEP_COLOR_COMMAND_TRANSITION_TIME(2, ZclCommandType.STEP_COLOR_COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE_TO_COLOR_TEMPERATURE_COMMAND_COLOR_TEMPERATURE(0, ZclCommandType.MOVE_TO_COLOR_TEMPERATURE_COMMAND, "Color Temperature",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    MOVE_TO_COLOR_TEMPERATURE_COMMAND_TRANSITION_TIME(1, ZclCommandType.MOVE_TO_COLOR_TEMPERATURE_COMMAND, "Transition time",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ZONE_ENROLL_RESPONSE_ENROLL_RESPONSE_CODE(0, ZclCommandType.ZONE_ENROLL_RESPONSE, "Enroll response code",ZclDataType.ENUMERATION_8_BIT),
    ZONE_ENROLL_RESPONSE_ZONE_ID(1, ZclCommandType.ZONE_ENROLL_RESPONSE, "Zone ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    ZONE_STATUS_CHANGE_NOTIFICATION_COMMAND_ZONE_STATUS(0, ZclCommandType.ZONE_STATUS_CHANGE_NOTIFICATION_COMMAND, "Zone Status",ZclDataType.ENUMERATION_16_BIT),
    ZONE_STATUS_CHANGE_NOTIFICATION_COMMAND_EXTENDED_STATUS(1, ZclCommandType.ZONE_STATUS_CHANGE_NOTIFICATION_COMMAND, "Extended Status",ZclDataType.ENUMERATION_8_BIT),
    ZONE_ENROLL_REQUEST_COMMAND_ZONE_TYPE(0, ZclCommandType.ZONE_ENROLL_REQUEST_COMMAND, "Zone Type",ZclDataType.ENUMERATION_16_BIT),
    ZONE_ENROLL_REQUEST_COMMAND_MANUFACTURER_CODE(1, ZclCommandType.ZONE_ENROLL_REQUEST_COMMAND, "Manufacturer Code",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    ARM_COMMAND_ARM_MODE(0, ZclCommandType.ARM_COMMAND, "Arm Mode",ZclDataType.ENUMERATION_8_BIT),
    BYPASS_COMMAND_NUMBER_OF_ZONES(0, ZclCommandType.BYPASS_COMMAND, "Number of Zones",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    BYPASS_COMMAND_ZONE_IDS(1, ZclCommandType.BYPASS_COMMAND, "Zone IDs",ZclDataType.N_X_UNSIGNED_8_BIT_INTEGER),
    GET_ZONE_INFORMATION_COMMAND_ZONE_ID(0, ZclCommandType.GET_ZONE_INFORMATION_COMMAND, "Zone ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    ARM_RESPONSE_ARM_NOTIFICATION(0, ZclCommandType.ARM_RESPONSE, "Arm Notification",ZclDataType.ENUMERATION_8_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_0(0, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 0",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_1(1, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 1",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_2(2, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 2",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_3(3, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 3",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_4(4, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 4",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_5(5, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 5",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_6(6, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 6",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_7(7, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 7",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_8(8, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 8",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_9(9, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 9",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_10(10, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 10",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_11(11, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 11",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_12(12, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 12",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_13(13, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 13",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_14(14, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 14",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_ID_MAP_RESPONSE_ZONE_ID_MAP_SECTION_15(15, ZclCommandType.GET_ZONE_ID_MAP_RESPONSE, "Zone ID Map section 15",ZclDataType.BITMAP_16_BIT),
    GET_ZONE_INFORMATION_RESPONSE_ZONE_ID(0, ZclCommandType.GET_ZONE_INFORMATION_RESPONSE, "Zone ID",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    GET_ZONE_INFORMATION_RESPONSE_ZONE_TYPE(1, ZclCommandType.GET_ZONE_INFORMATION_RESPONSE, "Zone Type",ZclDataType.ENUMERATION_16_BIT),
    GET_ZONE_INFORMATION_RESPONSE_IEEE_ADDRESS(2, ZclCommandType.GET_ZONE_INFORMATION_RESPONSE, "IEEE address",ZclDataType.IEEE_ADDRESS),
    START_WARNING_COMMAND_HEADER(0, ZclCommandType.START_WARNING_COMMAND, "Header",ZclDataType.DATA_8_BIT),
    START_WARNING_COMMAND_WARNING_DURATION(1, ZclCommandType.START_WARNING_COMMAND, "Warning duration",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    SQUAWK_COMMAND_HEADER(0, ZclCommandType.SQUAWK_COMMAND, "Header",ZclDataType.DATA_8_BIT),
    READ_ATTRIBUTES_COMMAND_IDENTIFIERS(0, ZclCommandType.READ_ATTRIBUTES_COMMAND, "Identifiers",ZclDataType.N_X_ATTRIBUTE_IDENTIFIER),
    READ_ATTRIBUTES_RESPONSE_RECORDS(0, ZclCommandType.READ_ATTRIBUTES_RESPONSE, "Records",ZclDataType.N_X_READ_ATTRIBUTE_STATUS_RECORD),
    WRITE_ATTRIBUTES_COMMAND_RECORDS(0, ZclCommandType.WRITE_ATTRIBUTES_COMMAND, "Records",ZclDataType.N_X_WRITE_ATTRIBUTE_RECORD),
    WRITE_ATTRIBUTES_UNDIVIDED_COMMAND_RECORDS(0, ZclCommandType.WRITE_ATTRIBUTES_UNDIVIDED_COMMAND, "Records",ZclDataType.N_X_WRITE_ATTRIBUTE_RECORD),
    WRITE_ATTRIBUTES_RESPONSE_RECORDS(0, ZclCommandType.WRITE_ATTRIBUTES_RESPONSE, "Records",ZclDataType.N_X_WRITE_ATTRIBUTE_STATUS_RECORD),
    WRITE_ATTRIBUTES_NO_RESPONSE_RECORDS(0, ZclCommandType.WRITE_ATTRIBUTES_NO_RESPONSE, "Records",ZclDataType.N_X_WRITE_ATTRIBUTE_RECORD),
    CONFIGURE_REPORTING_COMMAND_RECORDS(0, ZclCommandType.CONFIGURE_REPORTING_COMMAND, "Records",ZclDataType.N_X_ATTRIBUTE_REPORTING_CONFIGURATION_RECORD),
    CONFIGURE_REPORTING_RESPONSE_RECORDS(0, ZclCommandType.CONFIGURE_REPORTING_RESPONSE, "Records",ZclDataType.N_X_ATTRIBUTE_STATUS_RECORD),
    READ_REPORTING_CONFIGURATION_COMMAND_RECORDS(0, ZclCommandType.READ_REPORTING_CONFIGURATION_COMMAND, "Records",ZclDataType.N_X_ATTRIBUTE_RECORD),
    READ_REPORTING_CONFIGURATION_RESPONSE_RECORDS(0, ZclCommandType.READ_REPORTING_CONFIGURATION_RESPONSE, "Records",ZclDataType.N_X_ATTRIBUTE_REPORTING_CONFIGURATION_RECORD),
    REPORT_ATTRIBUTES_COMMAND_REPORTS(0, ZclCommandType.REPORT_ATTRIBUTES_COMMAND, "Reports",ZclDataType.N_X_ATTRIBUTE_REPORT),
    DEFAULT_RESPONSE_COMMAND_IDENTIFIER(0, ZclCommandType.DEFAULT_RESPONSE, "Command identifier",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    DEFAULT_RESPONSE_STATUS_CODE(1, ZclCommandType.DEFAULT_RESPONSE, "Status code",ZclDataType.ENUMERATION_8_BIT),
    DISCOVER_ATTRIBUTES_COMMAND_START_ATTRIBUTE_IDENTIFIER(0, ZclCommandType.DISCOVER_ATTRIBUTES_COMMAND, "Start attribute identifier",ZclDataType.UNSIGNED_16_BIT_INTEGER),
    DISCOVER_ATTRIBUTES_COMMAND_MAXIMUM_ATTRIBUTE_IDENTIFIERS(1, ZclCommandType.DISCOVER_ATTRIBUTES_COMMAND, "Maximum attribute identifiers",ZclDataType.UNSIGNED_8_BIT_INTEGER),
    DISCOVER_ATTRIBUTES_RESPONSE_COMMAND_IDENTIFIER(0, ZclCommandType.DISCOVER_ATTRIBUTES_RESPONSE, "Command identifier",ZclDataType.BOOLEAN),
    DISCOVER_ATTRIBUTES_RESPONSE_INFORMATION(1, ZclCommandType.DISCOVER_ATTRIBUTES_RESPONSE, "Information",ZclDataType.N_X_ATTRIBUTE_INFORMATION),
    READ_ATTRIBUTES_STRUCTURED_COMMAND_ATTRIBUTE_SELECTORS(0, ZclCommandType.READ_ATTRIBUTES_STRUCTURED_COMMAND, "Attribute selectors",ZclDataType.N_X_ATTRIBUTE_SELECTOR),
    WRITE_ATTRIBUTES_STRUCTURED_COMMAND_ATTRIBUTE_SELECTORS(0, ZclCommandType.WRITE_ATTRIBUTES_STRUCTURED_COMMAND, "Attribute selectors",ZclDataType.N_X_ATTRIBUTE_SELECTOR),
    WRITE_ATTRIBUTES_STRUCTURED_RESPONSE_RECORDS(0, ZclCommandType.WRITE_ATTRIBUTES_STRUCTURED_RESPONSE, "Records",ZclDataType.N_X_WRITE_ATTRIBUTE_STATUS_RECORD);

    private final int id;
    private final ZclCommandType commandType;
    private final String label;
    private final ZclDataType dataType;

    ZclFieldType(final int id, final ZclCommandType commandType, final String label, final ZclDataType dataType) {
        this.id = id;
        this.commandType = commandType;
        this.label = label;
        this.dataType = dataType;
    }

    public int getId() { return id; }
    public ZclCommandType getCommandType() { return commandType; }
    public String getLabel() { return label; }
    public ZclDataType getDataType() { return dataType; }

}
