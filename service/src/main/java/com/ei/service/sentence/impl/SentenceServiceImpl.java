package com.ei.service.sentence.impl;

import com.ei.ai.prompt.EI;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ei.mapper.sentence.EIPosMapper;
import com.ei.mapper.sentence.EISentenceMapper;
import com.ei.service.sentence.SentenceService;
import com.util.JSONUtils;
import customException.PosColorNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.client.AiClient;
import org.springframework.ai.client.AiResponse;
import org.springframework.ai.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.dto.word.WordDto;
import pojo.model.sentence.EIPosDO;
import pojo.model.sentence.EISentenceDO;
import pojo.vo.WordVO;

import java.util.Date;
import java.util.List;

/**
 * @author yitiansong
 */
@Service
@Slf4j
public class SentenceServiceImpl implements SentenceService {

    private final EIPosMapper posMapper;
    private final EISentenceMapper sentenceMapper;
    private final AiClient aiClient;
    private final Logger logger = LoggerFactory.getLogger(SentenceServiceImpl.class);

    @Autowired
    public SentenceServiceImpl(EIPosMapper posMapper, EISentenceMapper sentenceMapper, AiClient aiClient) {
        this.posMapper = posMapper;
        this.sentenceMapper = sentenceMapper;
        this.aiClient = aiClient;
    }


    @Override
    public String getColorByPos(String pos) throws PosColorNotFoundException {
        QueryWrapper<EIPosDO> queryColorByPosDO = new QueryWrapper<>();
        queryColorByPosDO.eq("pos",pos);
        EIPosDO posDO = posMapper.selectOne(queryColorByPosDO);
        if (posDO != null) {
            return posDO.getColor();
        } else {
            throw new PosColorNotFoundException();
        }
    }

    @Override
    public List<EIPosDO> listAll() {
        return posMapper.selectList(null);
    }


    @Override
    public Integer saveNewSentence(EISentenceDO sentence) {
        return sentenceMapper.insert(sentence);
    }

    @Override
    public String explainSentence(String sentence) {
        Prompt prompt = new Prompt(EI.EXPLAIN_SENTENCE.getPrompt().replace("{{ENGLISH_TEXT}}", sentence));
        AiResponse generate = aiClient.generate(prompt);
        String text = generate.getGeneration().getText();
        logger.info("");

        return text;
    }

    @Override
    public WordVO explainWordInSentence(WordDto wordDto) {
        Prompt prompt = new Prompt(EI.EXPLAIN_WORD_WITH_SENTENCE.getPrompt().replace("{{SENTENCE}}",wordDto.getBelongSentence()).replace("{{WORD}}", wordDto.getWord()));
        AiResponse generate = aiClient.generate(prompt);
        String content = generate.getGeneration().getText();
        log.info("explainWordInSentence返回结果：{}", content);
        // 移除<answer>标签
        WordVO wordvo = null;
        String wordStr = content.replace("<answer>", "").replace("</answer>", "");
        try {
            wordvo = JSONUtils.toObject(wordStr, WordVO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return wordvo;
    }

    @Override
    public EISentenceDO saveSentence(String sentence, String sentenceExplain) {
        EISentenceDO sentenceDO = new EISentenceDO();
        sentenceDO.setSentence(sentence);
        sentenceDO.setSentenceExplain(sentenceExplain);
        sentenceDO.setCreateTime(new Date());
        saveNewSentence(sentenceDO);
        return sentenceDO;
    }

    void recordUpdateInfo(EISentenceDO sentenceDO) {
        sentenceDO.setUpdateTime(new Date());
    }
}
