package com.ei.service.word;

import pojo.dto.word.SaveWordInSentenceDto;

/**
 * @author yitiansong
 */
public interface WordService {
    /**
     * Check if the word exists in the database.
     *
     * @param word the word to check
     * @return word id if the word exists, null otherwise
     */
    Integer ifWordExist(String word);

    /**
     * 保存单词
     * @param saveWordInSentenceDto dto对象
     */
    void saveWord(SaveWordInSentenceDto saveWordInSentenceDto);

    /**
     * 保存单词意思
     * @param saveWordInSentenceDto dto对象
     */
    void saveWordMeaning(SaveWordInSentenceDto saveWordInSentenceDto);

    /**
     * 保存例句
     * @param saveWordInSentenceDto dto对象
     */
    void saveExampleSentence(SaveWordInSentenceDto saveWordInSentenceDto);


}
