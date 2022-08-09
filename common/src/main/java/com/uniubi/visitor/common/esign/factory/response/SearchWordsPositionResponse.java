package com.uniubi.visitor.common.esign.factory.response;


import com.uniubi.visitor.common.esign.factory.response.other.SearchWordsPositionDataList;

public class SearchWordsPositionResponse extends Response {
    private SearchWordsPositionDataList data;

    public SearchWordsPositionDataList getData() {
        return data;
    }

    public void setData(SearchWordsPositionDataList data) {
        this.data = data;
    }
}
