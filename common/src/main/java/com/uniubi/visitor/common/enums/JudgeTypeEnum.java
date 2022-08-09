package com.uniubi.visitor.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 小区防范类型枚举
 *
 * @author zhaoyanbo
 * @date 2022/03/13
 */
@Getter
public enum JudgeTypeEnum {


    CLOSE("0", "封控小区"),

    CONTROL("1", "管控小区"),

    PREVENT("2", "防范小区"),

    OTHER("100", "正常小区");

    public final String code;
    public final String message;

    JudgeTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public static JudgeTypeEnum typeOf(String typeCode) {
        return Arrays.stream(JudgeTypeEnum.values()).filter(e -> e.getCode().equals(typeCode)).findFirst().orElse(JudgeTypeEnum.OTHER);
    }

    public static JudgeTypeEnum getValueByMessage(String message) {
        return Arrays.stream(JudgeTypeEnum.values()).filter(e -> e.getMessage().equals(message)).findFirst().orElse(JudgeTypeEnum.OTHER);
    }

}
