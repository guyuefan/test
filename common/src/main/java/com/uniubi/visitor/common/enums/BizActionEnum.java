package com.uniubi.visitor.common.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author zhaoyanbo
 * @date 2021/08/24
 */
public enum BizActionEnum {

    WEBS("WEBS", "网页登录行为"),
    SCEN("SCEN", "签到行为"),
    AGEN("AGEN", "代理商分享行为"),
    BIZA("BIZA", "统一业务处理行为");


    private String code;

    private String desc;

    BizActionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static BizActionEnum codeOf(String code) {
        return Arrays.stream(BizActionEnum.values()).filter(e -> StringUtils.equals(e.getCode(), code)).findFirst().orElse(null);
    }


    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
