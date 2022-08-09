package com.uniubi.visitor.common.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 2208595841431793319L;

    private int pageNum;

    private int pageSize;

    private String param;

    private Integer status;
}