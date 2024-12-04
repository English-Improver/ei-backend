package com.ei.service.sentence.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ei.mapper.sentence.EIPosMapper;
import com.ei.service.sentence.NlpProcessService;
import com.nlp.Token;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.simple.Sentence;
import org.springframework.stereotype.Service;
import pojo.model.sentence.EIPosDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yitiansong
 */
@Service
@Deprecated
public class NlpProcessServiceImpl implements NlpProcessService {
    private final StanfordCoreNLP pipeline;
    EIPosMapper posMapper;
    public NlpProcessServiceImpl(EIPosMapper posMapper) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, parse");
        this.pipeline = new StanfordCoreNLP(props);
        this.posMapper = posMapper;
    }
    @Override
    public List<Token> analyzeSyntax(String sentence) {
        CoreDocument document = new CoreDocument(sentence);
        pipeline.annotate(document);
        List<Token> tokens = new ArrayList<>();
        for (CoreLabel tok : document.tokens()) {
            Token token = new Token(tok.word(), tok.tag());
            tokens.add(token);
        }
        // 将token中的词性转为字符串
        Function<Token, String> tokenToPosString = Token::getPos;
        List<String> posList = tokens.stream().map(tokenToPosString).toList();
        // 利用querywrapper查询列pos对应的color，根据posList
        QueryWrapper<EIPosDO> wrapper = new QueryWrapper<>();
        wrapper.in("pos", posList);
        List<EIPosDO> posDOList = posMapper.selectList(wrapper);
        // 将posDOList中的每个对象根据name和token的pos相匹配，如果相同则将posdo中的color、name，赋给token的color、name
        Map<String, EIPosDO> posMap = posDOList.stream().collect(Collectors.toMap(EIPosDO::getPos, pos -> pos));

        for (Token token : tokens) {
            EIPosDO correspondingPosDO = posMap.get(token.getPos());
            if (correspondingPosDO != null) {
                token.setColor(correspondingPosDO.getColor());
                token.setName(correspondingPosDO.getName());
            }
        }
        return tokens;
    }

    /**
     * 获取单词的词根
     * @param word 单词
     * @return 单词的词根
     */
    public String getRootWord(String word) {
        // 创建一个只包含单个单词的句子
        Sentence sentence = new Sentence(word);

        // 获取单词的词形还原形式
        return sentence.lemma(0);
    }
}
