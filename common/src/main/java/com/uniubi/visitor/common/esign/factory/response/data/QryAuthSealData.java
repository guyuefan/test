package com.uniubi.visitor.common.esign.factory.response.data;

import com.uniubi.visitor.common.esign.factory.response.other.AuthSealList;
import lombok.Data;

@Data
public class QryAuthSealData {

    private AuthSealList seals;
    private int total;

}
