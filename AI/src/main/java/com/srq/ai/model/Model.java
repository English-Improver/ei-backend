package com.srq.ai.model;

import java.time.LocalDate;

/**
 * @author yitiansong
 * @since 9/28/24
 * 模型
 */

public class Model {
    /**
     * 模型名称
     */
    private String model;
    /**
     * endpoint
     */
    private String endpoint;
    /**
     * 版本
     */
    private String version;
    /**
     * 描述
     */
    private String description;
    /**
     * 上下文窗口
     */
    private Long contextWindow;
    /**
     * 最大输出token数
     */
    private Integer maxOutputTokens;
    /**
     * 训练日期
     */
    private LocalDate trainingDate;








    // constructor
    public Model(String model, String version, String description, Long contextWindow, Integer maxOutputTokens, LocalDate trainingDate, String endpoint) {
        this.model = model;
        this.version = version;
        this.description = description;
        this.contextWindow = contextWindow;
        this.maxOutputTokens = maxOutputTokens;
        this.trainingDate = trainingDate;
    }

    public Model() {

    }




    // getter and setter
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getContextWindow() {
        return contextWindow;
    }
    public void setContextWindow(Long contextWindow) {
        this.contextWindow = contextWindow;
    }
    public Integer getMaxOutputTokens() {
        return maxOutputTokens;
    }
    public void setMaxOutputTokens(Integer maxOutputTokens) {
        this.maxOutputTokens = maxOutputTokens;
    }
    public LocalDate getTrainingDate() {
        return trainingDate;
    }
    public void setTrainingDate(LocalDate trainingDate) {
        this.trainingDate = trainingDate;
    }
    public String getEndpoint() {
        return endpoint;
    }
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
