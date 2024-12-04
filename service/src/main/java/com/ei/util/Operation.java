package com.ei.util;

/**
 * @author 86157
 * 操作枚举类
 * 2024/1/7
 */

public enum Operation {
    ADD(1, "add"),
    DELETE(2, "delete"),
    UPDATE(3, "update"),
    QUERY(4, "query");

    private final Integer code;
    private final String msg;

    Operation(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{\"code\":" + code + ",\"msg\":\"" + msg + "\"}";
    }
}
