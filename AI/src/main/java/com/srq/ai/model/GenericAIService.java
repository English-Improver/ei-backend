package com.srq.ai.model;


import com.srq.ai.utils.CustomHttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author yitiansong
 * @since 9/28/24
 * @param <R> 大模型返回类型
 * 通用AI服务
 */

public abstract class GenericAIService<R> implements AIService, TokenAnalyzer<R> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 密钥
     */
    private String key;
    /**
     * 模型
     */
    private Model currentModel;

    /**
     * headers
     */
    private CustomHttpHeaders headers;

    /**
     * 可选模型
     */
    private ModelGroup modelGroup;

    /**
     * 单条信息
     * @param prompt 提示词
     * @return ai response
     */
    @Override
    public String generateStringAnswer(String prompt) {
        try (HttpClient client= HttpClient.newBuilder().build()) {
            HttpRequest.Builder builder = HttpRequest.newBuilder();
            HttpRequest request = builder.uri(URI.create(currentModel.getEndpoint()))
                    .POST(HttpRequest.BodyPublishers.ofString(prompt))
                    .build();
            // 添加headers
            headers.applyTo(builder);
            String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            logger.info("请求{}成功, 响应数据:{}", currentModel.getModel(), response);
            return response;
        } catch (IOException | InterruptedException e) {
            logger.error("请求{}失败", currentModel.getModel(),e);
        }
        logger.error("请求{}失败", currentModel.getModel());
        return "";
    }

    // getter and setter
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public Model getCurrentModel() {
        return currentModel;
    }
    public void setCurrentModel(Model currentModel) {
        this.currentModel = currentModel;
    }
    public ModelGroup getModelGroup() {
        return modelGroup;
    }
    public void setModelGroup(ModelGroup modelGroup) {
        this.modelGroup = modelGroup;
    }
    public CustomHttpHeaders getHeaders() {
        return headers;
    }
    public void setHeaders(CustomHttpHeaders headers) {
        this.headers = headers;
    }
}
