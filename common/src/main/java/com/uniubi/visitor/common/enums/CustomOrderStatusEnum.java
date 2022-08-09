package com.uniubi.visitor.common.enums;

import lombok.Getter;

@Getter
public enum CustomOrderStatusEnum {
    PAY_STATUS_ONE(1, "未支付"),
    PAY_STATUS_TWO(2, "已支付"),
    PAY_STATUS_THREE(3, "已退款");

    private Integer code;
    private String message;

    CustomOrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
