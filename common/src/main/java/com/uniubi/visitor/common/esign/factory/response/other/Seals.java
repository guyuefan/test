package com.uniubi.visitor.common.esign.factory.response.other;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;


public class Seals extends ArrayList {
    @Override
    public Seal get(int index) {
        Object o = super.get(index);
        Seal seal= JSON.parseObject(o.toString(), Seal.class);
        return seal;
    }
}
