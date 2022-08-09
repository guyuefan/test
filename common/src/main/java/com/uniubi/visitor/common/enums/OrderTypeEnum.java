package com.uniubi.visitor.common.enums;

import lombok.Getter;

@Getter
public enum OrderTypeEnum {
    TYPE_STATUS_ONE(0, "新订单"),
    PAY_STATUS_TWO(1, "新订单待处理"),
    PAY_STATUS_THREE(2, "确认已经支付"),
    PAY_STATUS_FOUR(3, "确认图发放错了"),
    PAY_STATUS_FIVE(4, "确认支付错了"),
    PAY_STATUS_SIX(5, "确认已经退款"),
    PAY_STATUS_(6, "确认已经发放");


    private Integer code;
    private String message;

    OrderTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public static OrderTypeEnum getOrderTypeEnum(Integer code) {
        if (code ==null) {
            return null;
        }

        for (OrderTypeEnum value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }
}
