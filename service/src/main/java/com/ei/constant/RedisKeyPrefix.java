package com.ei.constant;

/**
 * @author yitiansong
 * @since 2024/8/11
 * 用来存储redis key的前缀
 */

public enum RedisKeyPrefix {
    /**
     * 全局统一前缀和分隔符
     */
    APP("eiapp"),
    SEPARATOR(":"),

    /**
     * 用户模块
     */
    USER("user"),

    /**
     * url_parts
     */
    URL_PARAMS("urlParams");

    private String v;

    RedisKeyPrefix(String v) {
        this.v = v;
    }


    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }
}
