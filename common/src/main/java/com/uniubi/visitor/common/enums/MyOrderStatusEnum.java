package com.uniubi.visitor.common.enums;

import lombok.Getter;

@Getter
public enum MyOrderStatusEnum {
    PAY_STATUS_ONE(1, "待确认"),
    PAY_STATUS_TWO(2, "已支付"),
    PAY_STATUS_THREE(2, "已退款");

    private Integer code;
    private String message;

    MyOrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
