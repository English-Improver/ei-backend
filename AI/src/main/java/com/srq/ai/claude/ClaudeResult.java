package com.srq.ai.claude;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author yitiansong
 * @since 9/29/24
 * claude的返回结果
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClaudeResult {
    /**
     * 消息
     */
    private Message[] content;
    /**
     * 消息id
     */
    private String id;
    /**
     * 模型
     */
    private String model;
    /**
     * 角色
     */
    private String role;
    /**
     * 停止原因
     */
    private String stop_reason;
    /**
     * 停止序列
     */
    private String stop_sequence;
    /**
     * 类型
     */
    private String type;
    /**
     * 使用信息
     */
    private UsageInfo usage;

    public Message[] getContent() {
        return content;
    }
    public void setContent(Message[] content) {
        this.content = content;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getStop_reason() {
        return stop_reason;
    }
    public void setStop_reason(String stop_reason) {
        this.stop_reason = stop_reason;
    }
    public String getStop_sequence() {
        return stop_sequence;
    }
    public void setStop_sequence(String stop_sequence) {
        this.stop_sequence = stop_sequence;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public UsageInfo getUsage() {
        return usage;
    }
    public void setUsage(UsageInfo usage) {
        this.usage = usage;
    }


}

class UsageInfo {
    private Integer input_tokens;
    private Integer output_tokens;

    public Integer getInput_tokens() {
        return input_tokens;
    }
    public void setInput_tokens(Integer input_tokens) {
        this.input_tokens = input_tokens;
    }
    public Integer getOutput_tokens() {
        return output_tokens;
    }
    public void setOutput_tokens(Integer output_tokens) {
        this.output_tokens = output_tokens;
    }
}
/**
 * claude的消息
 */
class Message {
    private String text;
    private String type;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}