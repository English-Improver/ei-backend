package com.srq.ai.model;

import java.util.List;

/**
 * @author yitiansong
 * @since 9/28/24
 * 聊天上下文
 */

public class ChatContext {
    private String model;
    private List<Message> messages;

    public ChatContext(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
