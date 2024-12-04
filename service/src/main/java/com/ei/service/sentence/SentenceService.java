package com.ei.service.sentence;

import customException.PosColorNotFoundException;
import pojo.dto.word.WordDto;
import pojo.model.sentence.EIPosDO;
import pojo.model.sentence.EISentenceDO;
import pojo.vo.WordVO;


import java.util.List;

/**
 * @author yitiansong
 */
public interface SentenceService {
    /**
     * 根据词性获取其颜色
     * @param pos
     * @return color String
     */
    String getColorByPos(String pos) throws PosColorNotFoundException;

    /**
     * 获取所有词性的颜色
     * @return List<EIPosDO>
     *
     */
    List<EIPosDO> listAll();

    /**
     * 保存新的句子
     * @param sentence 句子
     * @return 句子id
     */
    Integer saveNewSentence(EISentenceDO sentence);

    /**
     * 解释句子
     * @param sentence 句子
     * @return 解释
     */
    String explainSentence(String sentence);

    WordVO explainWordInSentence(WordDto wordDto);
    /**
     *  根据句子和解释进行保存, 返回记录
     * @param sentence 句子
     * @param sentenceExplain 句子解释
     * @return EISentenceDO
     */
    EISentenceDO saveSentence(String sentence, String sentenceExplain);

}
