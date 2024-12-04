package com.srq.ai.model;

import java.util.List;

/**
 * @author yitiansong
 * @since 9/28/24
 * 模型组
 */

public class ModelGroup {
    /**
     * 模型组名称
     */
    private String group;
    /**
     * 模型列表
     */
    private List<Model> models;









    // constructor

    public ModelGroup(String group, List<Model> models) {
        this.group = group;
        this.models = models;
    }
    public ModelGroup() {

    }

    // getter and setter
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
