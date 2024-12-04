package com.ei.constant;

import static com.ei.constant.RedisKeyPrefix.*;

/**
 * @author yitiansong
 * @since 2024/8/11
 */

public enum RedisKey {
    /**
     * 用户token对应的key
     */
    TOKEN(APP.getV(), USER.getV(), "token"),
    /**
     * 接口地址组成部分，ip或平台参数
     */
    URL_PARTS(APP.getV(), URL_PARAMS.getV())
    ;

    private final String v1;

    RedisKey(String... v1) {
        StringBuilder sb = new StringBuilder();
        for (String s : v1) {
            sb.append(s).append(SEPARATOR.getV());
        }
        this.v1 = sb.toString();
    }

    public String getV1() {
        return v1;
    }

    /**
     * 拼接redis key
     * @param keyPrefix key的前缀
     * @param value 唯一标识key的值
     * @return 唯一redis key
     */
    public static String generate(RedisKey keyPrefix, String value) {
        return keyPrefix.getV1() + value;
    }
}
