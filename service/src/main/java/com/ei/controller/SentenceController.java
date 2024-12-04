package com.ei.controller;

import com.ei.service.sentence.SentenceService;
import com.ei.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.dto.word.WordDto;
import pojo.model.sentence.EISentenceDO;
import pojo.vo.WordVO;

/**
 * @author yitiansong
 */
@RestController
@RequestMapping("/sentence")
@Slf4j
public class SentenceController {
    private final SentenceService sentenceService;

    public SentenceController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @PostMapping("/explain")
    public ResponseEntity<String> explainSentence(@RequestBody String sentence) {
        log.info("执行解释功能开始：{}", sentence);
        String sentenceExplanation = sentenceService.explainSentence(sentence);
        EISentenceDO eiSentenceDO = sentenceService.saveSentence(sentence, sentenceExplanation);
        Result success = Result.success(eiSentenceDO);
        //
        log.info("执行解释功能结束");
        return ResponseEntity.ok(sentenceExplanation);
    }

    @PostMapping("/explainWordInSentence")
    public ResponseEntity<WordVO> explainWordInSentence(@RequestBody WordDto wordDto) {
        WordVO word = sentenceService.explainWordInSentence(wordDto);
        return ResponseEntity.ok(word);
    }
}
