package com.uniubi.visitor.common.esign.factory.response.data;


import com.uniubi.visitor.common.esign.factory.response.other.PositionList;

public class SearchWordsPositionData {
    private String fileId;
    private String keyword;
    private PositionList positionList;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public PositionList getPositionList() {
        return positionList;
    }

    public void setPositionList(PositionList positionList) {
        this.positionList = positionList;
    }
}
