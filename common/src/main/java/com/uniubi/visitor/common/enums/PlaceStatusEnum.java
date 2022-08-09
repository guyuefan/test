package com.uniubi.visitor.common.enums;

/**
 * 场所状态
 * @author zhaoyanbo
 * @date 2021/08/18
 */
public enum PlaceStatusEnum {
    /**
     * 空值
     */
    INIT(5, "初始化"),
    /**
     * 未支付  //   订单 0,3
     */
    UNPAYED(10, "未支付"),

    /**
     * 审核中  订单 1
     */
    JUDGE(20, "审核中"),
    /**
     * 审核未通过  订单  4,5
     */
    FAIL(30, "审核失败"),
    /**
     * 审核通过   订单 2,6
     */
    SUCCESS(40, "已启用"),
    /**
     * 已过期，宇泛禁用
     */
    STOP(50, "已过期");


    private final int code;
    private final String type;


    PlaceStatusEnum(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public static PlaceStatusEnum findByType(int type) {
        for (PlaceStatusEnum rpe : PlaceStatusEnum.values()) {
            if (rpe.code == type) {
                return rpe;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
