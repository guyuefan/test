package com.uniubi.visitor.common.esign.factory.signfile.documents;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.DownDocumentsResponse;

/**
 * @description  流程文档下载
 * @author  bixing
 */
public class DownDocuments extends Request<DownDocumentsResponse> {
    @JSONField(serialize = false)
    private String flowId;

    private DownDocuments(){};
    public DownDocuments(String flowId) {
        this.flowId = flowId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    @Override
    public void build() {
        super.setUrl("/v1/signflows/"+flowId+"/documents");
        super.setRequestType(RequestType.GET);
    }
}
