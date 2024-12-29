package com.ei.dao;

import com.ei.mapper.word.EIWOrdSentenceMapper;
import com.ei.mapper.word.EIWordMapper;
import com.ei.mapper.word.EIWordMeaningMapper;
import com.ei.service.word.PosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pojo.dto.word.SaveWordInSentenceDto;
import pojo.dto.word.WordMeaningDTO;
import pojo.model.word.EIWordDO;
import pojo.model.word.EIWordMeaningDO;
import pojo.model.wordsentence.EIWordSentenceDO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: songrunqi
 * @since 10:17
 **/
@Repository
@Slf4j
public class SentenceDao {
    @Autowired
    private EIWOrdSentenceMapper wordSentenceMapper;
    @Autowired
    private EIWordMapper wordMapper;
    @Autowired
    private EIWordMeaningMapper wordMeaningMapper;

    private PosService posService;

    /**
     * 保存EIWordDO
     * @param word
     * @param userId
     * @return wordId
     */
    public Integer saveWord(SaveWordInSentenceDto word, Integer userId) {
        EIWordDO wordDo = new EIWordDO();
        wordDo.setUserId(userId);
        wordDo.setWord(word.getWord());
        wordDo.setPronunciation(word.getPronunciation());
        wordDo.setIsWord(1);
        wordMapper.insert(wordDo);
        return wordDo.getId();
    }

    /**
     * 保存EIWordMeaningDO
     * @param word
     * @param wordId
     * @return
     */
    public List<EIWordMeaningDO> saveWordMeaning(SaveWordInSentenceDto word, Integer wordId) {
        List<EIWordMeaningDO>  wordMeanings = new ArrayList<>();
        List<WordMeaningDTO> toSaveWordMeaning = word.getMeanings();
        AtomicInteger errorCount = new AtomicInteger();
        // save all meanings
        toSaveWordMeaning.forEach(wordMeaning -> {
            EIWordMeaningDO wordMeaningDO = new EIWordMeaningDO();
            wordMeaningDO.setWordId(wordId);
            wordMeaningDO.setMeaning(wordMeaning.getMeaning());
            wordMeaningDO.setProperty(wordMeaning.getProperty());
            wordMeaningDO.setCreateTime(new Date());
            try {
                wordMeaningMapper.insert(wordMeaningDO);
                boolean add = wordMeanings.add(wordMeaningDO);
            } catch (Exception e) {
                log.error("单词意思保存失败：{}", wordMeaningDO, e);
                errorCount.getAndIncrement();
            }
        });
        if (errorCount.get() > 0) {
            log.error("单词意思保存失败，单词id：{}", wordId);
        }
        return wordMeanings;
    }

    /**
     * 保存单词和句子之间的关联关系
     * @param sentenceId
     * @param wordId
     * @param word
     * @return
     */
    public boolean saveWordRelationWithSentence(Integer sentenceId, Integer wordId, SaveWordInSentenceDto word) {
        EIWordSentenceDO wordSentence = new EIWordSentenceDO();
        wordSentence.setWordId(wordId);
        wordSentence.setSentenceId(sentenceId);
        wordSentence.setMeaning(word.getMeaningInSentence());
        wordSentence.setCreateTime(new Date());
        int affectedRow = wordSentenceMapper.insert(wordSentence);
        return affectedRow > 0;
    }

    /**
     * 保存短语
     * @param userId
     * @param sentenceId
     * @param word
     * @return
     */
    public boolean savePhrase(Integer userId, Integer sentenceId, SaveWordInSentenceDto word) {
        EIWordDO wordDO = new EIWordDO();
        wordDO.setWord(word.getWord());
        wordDO.setPronunciation(word.getPronunciation());
        wordDO.setUserId(userId);
        wordDO.setIsWord(0);
        int inserted = wordMapper.insert(wordDO);
        return inserted > 0;
    }
}
