package com.giannini.common;

/**
 * @author jiangningyu
 * @date 2017/11/8
 */
public enum  ErrorCode {
    TOKEN_VERIFY_FAILED(999601, "token验证失败"),
    SERVER_ERROR(701000, "服务内部错误"),
    PARAM_ERROR(701001, "参数错误"),
    PASSENGER_TICKET_ILLEGAL(701002, "ticket鉴权失败，请重新登录"),
    PASSENGER_LOGIN_TICKET_ILLEGAL(701003, "ticket验证失败，请重新登录"),
    EMP_NOT_JOIN_TEAM(701004, "未加入工作组无法开始工作，请联系管理员将你加入工作组"),
    EMP_STATUS_INVALID(701005, "账号处于禁用状态"),
    COMPANY_STATUS_INVALID(701006, "公司处于禁用状态"),
    GET_APP_VERSION_ERROR(701007, "当前没有可升级版本"),
    FIND_JOIN_EMPLOYEE_ERROR(701008, "查询交接人员失败"),
    FIND_JOIN_EMPLOYEE_COMPANY_ERROR(701009, "查询该城市运营公司失败"),
    FIND_JOIN_EMPLOYEE_TEAM_ERROR(701010, "查询交接人员运营小组失败"),
    VEHICLE_UNLOCK_ERROR(701011, "车辆开锁失败，请重试"),
    VEHICLE_LOCK_ERROR(701012, "车辆关锁失败，请重试"),
    MOB_NOT_EXIST(701013, "号码不是运维人员，请更换手机号码"),
    BATTERY_UNLOCK_ERROR(701014, "开电池锁失败"),
    EMPLOYEE_NOT_EXIST(701015, "员工信息不存在"),
    DUBBO_REMOTE_INVOKE_ERROR(701016, "系统超时，请重试"),
    VEHICLE_SEND_ERROR(701017, "车辆投放失败，请重试"),
    VEHICLE_NOTIFY_RINGBELL_ERROR(701018, "车辆响铃失败，请重试"),
    GET_OPERATOR_CENTER_ERROR(701019, "查询城市仓库信息失败"),
    VEHICLE_INFO_NULL_ERROR(701020, "查询不到该车辆的信息"),
    VEHICLE_BATTERY_INFO_NULL_ERROR(701021, "查询不到该车辆电池的信息"),
    VEHICLE_FAULT_REPORT_ERROR(701022, "上报故障失败"),
    VEHICLE_CHANGE_STATUS_ERROR(701023, "车辆运营状态变更失败"),
    NOT_ASSET_ADMIN(701024, "不是资产管理员,请联系管理员添加"),
    GET_VEHICLE_INFO_ERROR(701025, "查询车辆信息失败"),
    VEHICLE_STATUS_ERROR(701026, "车辆运营状态错误,无法操作"),
    BATTERY_CHANGE_STATUS_ERROR(701027, "电池运营状态变更失败"),
    QA_VEHICLE_NOT_EXIST(701100, "车辆信息不存在"),
    QA_RECORD_NOT_EXIST(701101, "该车辆检测记录不存在"),
    QA_ADD_VEHICLE_RECORD_ERROR(701102, "添加车辆检测记录失败"),
    QA_UNKNOWN_FUNCTION_TYPE(701103, "测试项目未知"),
    QA_UPDATE_DB_EXCEPTION(701104, "更新车辆检测功能结果失败"),
    QA_GET_REPORT_ERROR(701105, "获取产测报告失败"),
    QA_VEHICLE_OPERATION_STATUS_ERROR(701106, "车辆禁止操作");

    /**
     * 平台业务code. 返回给服务化调用着
     */
    private int    platformCode;
    /**
     * 描述信息, 用于平台内部使用
     */
    private String desc;

    private ErrorCode(int platformCode, String desc) {
        this.platformCode = platformCode;
        this.desc = desc;
    }
}
