package com.uniubi.visitor.common.esign.factory.fileTemplate;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.QryFileStatusResponse;

/**
 * @description  查询文件上传状态
 * @author  bixing
 */
public class QryFileStatus extends Request<QryFileStatusResponse> {
    @JSONField(serialize = false)
    private String fileId;//文件id

    //禁止构造无参对象
    private QryFileStatus(){};

    public QryFileStatus(String fileId) {
        this.fileId = fileId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public void build() {
        super.setUrl("/v1/files/"+fileId+"/status");
        super.setRequestType(RequestType.GET);
    }
}
