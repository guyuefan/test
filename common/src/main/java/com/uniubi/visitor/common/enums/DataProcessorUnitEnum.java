package com.uniubi.visitor.common.enums;


public enum DataProcessorUnitEnum {
    /**
     * 空值
     */
    EMPTY(0, "NULL"),

    /**
     * 电话
     */
    PHONE(2, "phone");
    private final int code;
    private final String type;

    DataProcessorUnitEnum(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public static com.uniubi.visitor.common.enums.DataProcessorUnitEnum findByType(int type) {
        for (com.uniubi.visitor.common.enums.DataProcessorUnitEnum rpe : com.uniubi.visitor.common.enums.DataProcessorUnitEnum.values()) {
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
