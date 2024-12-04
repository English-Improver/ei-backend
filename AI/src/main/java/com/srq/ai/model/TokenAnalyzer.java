package com.srq.ai.model;

/**
 * @author yitiansong
 * @since 10/11/24
 * @param <R> 大模型响应类型
 * token分析
 */

public interface TokenAnalyzer<R> {
    /**
     * 分析与大模型在该次请求中的token耗费数
     *
     *
     * @return token数
     */
    int analyzeToken(R result);
}
