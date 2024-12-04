package com.ei.ai.service.word;

import pojo.dto.word.WordDto;
import pojo.vo.WordVO;

/**
 * @author yitiansong
 * 2024/5/2
 */
public interface WordAssistanceService {
    WordVO explainWordInSentence(WordDto wordDto);
}
