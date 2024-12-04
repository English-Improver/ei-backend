package com.ei.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author yitiansong
 * @since 11/13/24
 */
@Configuration
public class DingdingConfig {
    @Value("$dingding.clientId")
    private String clientId;
    @Value("$dingding.clientSecret")
    private String clientSecret;
    private final String topic = "/v1.0/im/bot/messages/get";

    public String getClientId() {
        return clientId;
    }



    public String getClientSecret() {
        return clientSecret;
    }



    public String getTopic() {
        return topic;
    }
}
