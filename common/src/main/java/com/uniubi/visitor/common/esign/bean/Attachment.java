package com.uniubi.visitor.common.esign.bean;
/**
 * @description  附件信息
 * @author
 *
 */
public class Attachment {
    private String fileId;
    private String attachmentName;

    public String getFileId() {
        return fileId;
    }

    public Attachment setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public Attachment setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
        return this;
    }
}
