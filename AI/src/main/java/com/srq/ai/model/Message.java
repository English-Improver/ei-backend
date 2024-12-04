package com.srq.ai.model;

/**
 * @author yitiansong
 * @since 9/28/24
 * 在请求中传递的一条消息, 包含角色和内容
 */

public class Message {
    /**
     * 角色
     */
    private String role;
    /**
     * 内容
     */
    private String content;

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
