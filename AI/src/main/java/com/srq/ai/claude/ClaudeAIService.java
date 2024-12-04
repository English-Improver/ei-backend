package com.srq.ai.claude;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.srq.ai.model.GenericAIService;
import com.srq.ai.utils.CustomHttpHeaders;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.srq.ai.utils.DtoParse.parse;

/**
 * @author yitiansong
 * @since 9/29/24
 * claude的AI服务
 */
@EnableConfigurationProperties(ClaudeAutoCOnfiguration.class)
public class ClaudeAIService extends GenericAIService<ClaudeResult> {

    public ClaudeAIService () {
        init();
    }

    /**
     * set headers
     * and other actions
     */
    private void init() {
        setHeaders();
    }
   private void setHeaders() {
       CustomHttpHeaders customHttpHeaders = new CustomHttpHeaders();
       customHttpHeaders.add("x-api-key", "");
       customHttpHeaders.add("anthropic-version", "2023-06-01");
       customHttpHeaders.add("content-type", "application/json");
       setHeaders(customHttpHeaders);
   }

    @Override
    public String generateStringAnswer(String prompt) {

        ClaudeResult claudeResponse = generateResult(prompt);

        Message[] messages = claudeResponse.getContent();
        for (Message message : messages) {
            if (message.getType().equals(ReturnType.TEXT)) {
                return message.getText();
            }
        }

        return "error response from claude";
    }

    public ClaudeResult generateResult(String prompt) {
        String result = super.generateStringAnswer(prompt);
        logger.info("claude response: {}", result);
        try {
            ClaudeResult claudeResult = parse(result, ClaudeResult.class);
            if (claudeResult == null) {
                logger.error("解析claude响应数据失败, 响应结果:{}", result);

            }
            return claudeResult;
        } catch (JsonProcessingException e) {
            logger.error("json解析错误", e);
        }
        return null;
    }
    /**
     * 分析与大模型在该次请求中的token耗费数
     *
     * @param result claude结果
     * @return token数
     */
    @Override
    public int analyzeToken(ClaudeResult result) {
        UsageInfo usage = result.getUsage();
        Integer inputTokens = usage.getInput_tokens();
        Integer outputTokens = usage.getOutput_tokens();
        int totalConsumption = inputTokens + outputTokens;
        logger.info("token consumed: {}", totalConsumption);
        return totalConsumption;
    }
}
