package com.uniubi.visitor.common.enums;

/**
 * 发放状态
 * @author zhaoyanbo
 * @date 2021/08/19
 */
public enum AgentAwardPayStatusEnum {

    /**
     *   订单  0，1 ，3，4
     */
    TRADE_UNCOMPLETE(10, "交易未完成"),

    /**
     *  订单 5
     */
    TRADE_UNSUCCESS(20, "交易未成功"),

    /**
     *  订单 2
     */
    AWARD_SEND(30, "奖金发放中"),

    /**
     *  订单 6
     */
    AWARD_SUCCESS(40, "奖金已发放");



    private Integer code;
    private String message;

    AgentAwardPayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
