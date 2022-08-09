package com.uniubi.visitor.common.esign.factory.response.other;


public class ConfigInfo {
    private String noticeDeveloperUrl;
    private String noticeType;
    private String redirectUrl;
    private String signPlatform;

    public String getNoticeDeveloperUrl() {
        return noticeDeveloperUrl;
    }

    public void setNoticeDeveloperUrl(String noticeDeveloperUrl) {
        this.noticeDeveloperUrl = noticeDeveloperUrl;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getSignPlatform() {
        return signPlatform;
    }

    public void setSignPlatform(String signPlatform) {
        this.signPlatform = signPlatform;
    }
}
