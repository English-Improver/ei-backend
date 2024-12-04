package com.util;

import com.ei.mapper.sentence.EIPosMapper;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

/**
 * @author yitiansong
 * stanford nlp工具类
 * 2024/5/4
 */
public class NlpUtils {
    private static final StanfordCoreNLP pipeline;
    private EIPosMapper posMapper;
    static {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, parse");
        pipeline = new StanfordCoreNLP(props);
    }

}
