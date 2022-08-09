package com.uniubi.visitor.common.enums;

/**
 * @author zhaoyanbo
 * @date 2021/11/10
 */
public enum DeviceTTSEnum {


    /**
     * 绑定设备
     */
    DEVICE_BIND_SUCCESS("10000", "绑定成功"),
    DEVICE_BIND_FAIL("10001", "绑定失败"),
    /**
     * 扫码
     */
    QR_FAIL("20001", "二维码识别失败"),
    RED("20002", "健康码为红色"),
    YELLOW("20003", "健康码为黄色"),
    /**
     * 服务端异常
     */
    SERVER_FAIL("30001", "网络连接失败");


    private String code;

    private String desc;

    DeviceTTSEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
