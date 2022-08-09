package com.uniubi.visitor.common.params;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;


@Data
public class SmsParamDTO implements Serializable {
    /**
     * 发送的手机号码
     */
    private String phone;
    /**
     * 模板
     */
    private String templateCode;

    /**
     * 发送的内容
     */
    private Map<String, Object> templateParam;
}
