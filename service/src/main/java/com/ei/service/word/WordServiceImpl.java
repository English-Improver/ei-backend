package com.ei.service.word;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ei.mapper.word.EIWordMapper;
import com.ei.security.filter.SecurityContextHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.dto.word.SaveWordInSentenceDto;
import pojo.model.word.EIWordDO;

/**
 * @author yitiansong
 */
@Service
@Slf4j
public class WordServiceImpl implements WordService{

    private final SecurityContextHelper securityContextHelper;

    private final EIWordMapper wordMapper;

    public WordServiceImpl(SecurityContextHelper securityContextHelper, EIWordMapper wordMapper) {
        this.securityContextHelper = securityContextHelper;
        this.wordMapper = wordMapper;
    }

    /**
     *
     * @param word the word to check
     * @return word id if the word exists otherwise return null
     */
    @Override
    public Integer ifWordExist(String word) {
//        获取用户ID
        Integer currentUserId = securityContextHelper.getCurrentUserId();
        log.info("用户[{}], 存储单词[{}]", currentUserId, word);
        QueryWrapper<EIWordDO> wrapper = new QueryWrapper<>();
        wrapper.eq("word", word);
        // 如果用户为空，查整体
        if (currentUserId == null) {
            wrapper.eq("user_id", currentUserId);
        }
        EIWordDO wordDO = wordMapper.selectOne(wrapper);
        log.info("用户[{}], 已找到单词[{}]", currentUserId, wordDO);
        return wordDO != null ? wordDO.getId() : null;
    }

    /**
     * 保存单词
     *
     * @param saveWordInSentenceDto dto对象
     */
    @Override
    public void saveWord(SaveWordInSentenceDto saveWordInSentenceDto) {
        String word = saveWordInSentenceDto.getWord();
        Integer rootWordId = ifWordExist(word);
        if (rootWordId != null) {
//            Word
        }
    }

    /**
     * 保存单词意思
     *
     * @param saveWordInSentenceDto dto对象
     */
    @Override
    public void saveWordMeaning(SaveWordInSentenceDto saveWordInSentenceDto) {

    }

    /**
     * 保存例句
     *
     * @param saveWordInSentenceDto dto对象
     */
    @Override
    public void saveExampleSentence(SaveWordInSentenceDto saveWordInSentenceDto) {

    }
}
