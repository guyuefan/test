package com.uniubi.visitor.common.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;


/**
 * @author zqp
 */
@Configuration
@Data
@RefreshScope
public class SmsConfig {

    @Value("${phone.url}")
    private String url;

    @Value("${phone.sms}")
    private String sms;

    @Value("${phone.fieldTemplateCode}")
    private String fieldTemplateCode;

    @Value("${phone.agentTemplateCode}")
    private String agentTemplateCode;

    @Value("${phone.registerRemindTemplate}")
    private String registerRemindTemplate;

    @Value("${phone.codeUnnormalTemplate}")
    private String codeUnnormalTemplate;

    @Value("${phone.enable}")
    private Boolean enable;

    @Value("${phone.KanBanPermission:SMS_225126120}")
    private String KanBanPermission;

    @Value("${phone.registerAuth:SMS_227005216}")
    private String registerAuth;

    @Value("${phone.registerAuthResult:SMS_227010120}")
    private String registerAuthResult;

    @Value("${phone.sceneAuth:SMS_227005220}")
    private String sceneAuth;

    @Value("${phone.sceneAuthResult:SMS_227000203}")
    private String sceneAuthResult;


    @Value("${phone.placeAuthResult}")
    private String placeAuthResult;


}
