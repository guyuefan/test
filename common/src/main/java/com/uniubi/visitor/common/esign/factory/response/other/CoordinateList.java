package com.uniubi.visitor.common.esign.factory.response.other;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;


public class CoordinateList extends ArrayList {
    @Override
    public Coordinate get(int index) {
        Object o = super.get(index);
        Coordinate coordinate = JSON.parseObject(o.toString(), Coordinate.class);
        return coordinate;
    }
}
