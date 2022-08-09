package com.uniubi.visitor.common.esign.factory.other;

import com.alibaba.fastjson.annotation.JSONField;
import com.uniubi.visitor.common.esign.enums.RequestType;
import com.uniubi.visitor.common.esign.factory.request.Request;
import com.uniubi.visitor.common.esign.factory.response.SearchWordsPositionResponse;

/**
 * @description  搜索关键字坐标
 * @author  bixing
 */
public class SearchWordsPosition extends Request<SearchWordsPositionResponse> {
    @JSONField(serialize = false)
    private String fileId;
    @JSONField(serialize = false)
    private String keywords;

    private SearchWordsPosition(){};
    public SearchWordsPosition(String fileId, String keywords) {
        this.fileId = fileId;
        this.keywords = keywords;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public void build() {
        super.setUrl("/v1/documents/"+fileId+"/searchWordsPosition?keywords="+keywords);
        super.setRequestType(RequestType.GET);
    }
}
