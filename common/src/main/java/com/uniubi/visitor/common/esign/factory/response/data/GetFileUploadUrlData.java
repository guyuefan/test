package com.uniubi.visitor.common.esign.factory.response.data;


public class GetFileUploadUrlData {
    private String fileId;
    private String uploadUrl;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }
}
