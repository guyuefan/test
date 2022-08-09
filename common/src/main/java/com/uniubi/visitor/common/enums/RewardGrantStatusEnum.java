package com.uniubi.visitor.common.enums;

import lombok.Getter;

@Getter
public enum RewardGrantStatusEnum {
    PAY_STATUS_ONE(0, "订单未完成"),
    PAY_STATUS_TWO(1, "订单未成功"),
    PAY_STATUS_THREE(2, "发放中"),
    PAY_STATUS_FOUR(3, "已发放");

    private Integer code;
    private String message;

    RewardGrantStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
