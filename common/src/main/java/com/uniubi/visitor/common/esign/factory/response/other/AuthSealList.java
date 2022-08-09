package com.uniubi.visitor.common.esign.factory.response.other;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;


public class AuthSealList extends ArrayList {
    @Override
    public AuthSeal get(int index) {
        Object o = super.get(index);
        AuthSeal authSeal = JSON.parseObject(o.toString(), AuthSeal.class);
        return authSeal;
    }
}
