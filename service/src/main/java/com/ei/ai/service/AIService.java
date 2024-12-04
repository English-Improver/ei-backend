package com.ei.ai.service;

import org.springframework.ai.client.AiClient;

/**
 * @author yitiansong
 * 2024/5/2
 */
public class AIService {
    final AiClient chatClient;

    public AIService(AiClient chatClient) {
        this.chatClient = chatClient;
    }
}
