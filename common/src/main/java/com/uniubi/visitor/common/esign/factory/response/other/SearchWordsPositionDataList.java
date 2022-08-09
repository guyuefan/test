package com.uniubi.visitor.common.esign.factory.response.other;

import com.alibaba.fastjson.JSON;
import com.uniubi.visitor.common.esign.factory.response.data.SearchWordsPositionData;

import java.util.ArrayList;


public class SearchWordsPositionDataList extends ArrayList {
    @Override
    public SearchWordsPositionData get(int index) {
        Object o = super.get(index);
        SearchWordsPositionData searchWordsPositionData = JSON.parseObject(o.toString(), SearchWordsPositionData.class);
        return searchWordsPositionData;
    }
}
