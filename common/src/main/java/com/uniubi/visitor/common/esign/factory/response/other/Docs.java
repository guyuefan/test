package com.uniubi.visitor.common.esign.factory.response.other;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;


public class Docs extends ArrayList {
    @Override
    public Doc get(int index) {
        Object o = super.get(index);
        Doc doc = JSON.parseObject(o.toString(), Doc.class);
        return doc;
    }
}
