package com.ei.util;

/**
 * @author 86157
 * 2024/1/7
 * 结果枚举类
 */

public enum ResultType {
    SUCCESS(200, "success"),
    FAIL(400, "fail");

    private final Integer code;
    private final String msg;

    ResultType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{\"code\":" + code + ",\"msg\":\"" + msg + "\"}";
    }
}
