package com.ei.service;

import com.ei.constant.UrlParamsEnum;

/**
 * @author yitiansong
 * @since 11/5/24
 */

public interface InterfacePlatformService{
     String getUrl(UrlParamsEnum platform, UrlParamsEnum appCode, String esType);
}
