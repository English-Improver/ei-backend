package com.ei.service.word;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ei.mapper.word.EIWordMapper;
import com.ei.security.filter.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.dto.word.SaveWordInSentenceDto;
import pojo.model.word.EIWordDO;

/**
 * @author yitiansong
 */
@Service
public class WordServiceImpl implements WordService{

    private final SecurityContextHelper securityContextHelper;

    private final EIWordMapper wordMapper;

    public WordServiceImpl(SecurityContextHelper securityContextHelper, EIWordMapper wordMapper) {
        this.securityContextHelper = securityContextHelper;
        this.wordMapper = wordMapper;
    }


    @Override
    public Integer ifWordExist(String word) {
//        获取用户ID
        Integer currentUserId = securityContextHelper.getCurrentUserId();
        QueryWrapper<EIWordDO> wrapper = new QueryWrapper<>();
        wrapper.eq("word", word);
        wrapper.eq("user_id", currentUserId);
        EIWordDO wordDO = wordMapper.selectOne(wrapper);
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
