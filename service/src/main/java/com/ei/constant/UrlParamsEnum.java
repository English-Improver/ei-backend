package com.ei.constant;

/**
 * @author yitiansong
 * @since 11/5/24
 */

public enum UrlParamsEnum {
    USER_CENTER_PLATFORM("usercetner");
    private final String codeType;

    UrlParamsEnum(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeType() {
        return codeType;
    }
}
