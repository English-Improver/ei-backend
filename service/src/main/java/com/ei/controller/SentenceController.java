package com.ei.controller;

import com.ei.security.filter.SecurityContextHelper;
import com.ei.service.sentence.SentenceService;
import com.ei.util.Result;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.dto.sentence.SaveSentenceDto;
import pojo.dto.word.SaveWordInSentenceDto;
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

    private final SecurityContextHelper securityContext;
    @Value("${login.auth}")
    private boolean productMode;

    @Autowired
    public SentenceController(SentenceService sentenceService, SecurityContextHelper securityContext) {
        this.sentenceService = sentenceService;
        this.securityContext = securityContext;
    }

    @PostMapping("/explain")
    public ResponseEntity<String> explainSentence(@RequestBody String sentence) {
        log.info("执行解释功能开始：{}", sentence);
        String sentenceExplanation = sentenceService.explainSentence(sentence);
//        EISentenceDO eiSentenceDO = sentenceService.saveSentence(sentence, sentenceExplanation);
//        Result success = Result.success(eiSentenceDO);
        //
        log.info("执行解释功能结束");
        return ResponseEntity.ok(sentenceExplanation);
    }

    @PostMapping("/explainWordInSentence")
    public ResponseEntity<WordVO> explainWordInSentence(@RequestBody WordDto wordDto) {
        WordVO word = sentenceService.explainWordInSentence(wordDto);
//         sentenceService.
        return ResponseEntity.ok(word);
    }

    @PostMapping("/saveWordInSentence")
    public ResponseEntity<Result> addWordInSentence(@RequestBody @Valid SaveWordInSentenceDto word) {
        Integer userId;
        if (productMode) {
            userId = securityContext.getCurrentUserId();
        } else {
            userId = 1;
        }
        Integer sentenceId = word.getSentenceId();
        if (sentenceId != null && sentenceId <= 0) {
            sentenceId = null;
        }
        log.info("用户【{}】保存句子【{}】单词【{}】", userId, sentenceId, word);
        sentenceService.saveWordInSentence(userId,sentenceId, word);

        return ResponseEntity.ok(Result.success("保存成功"));
    }

    @PostMapping("/save")
    public ResponseEntity<Result> saveSentence(@RequestBody @Valid SaveSentenceDto saveSentenceDto) {
//        log.info("用户【{}】保存句子[{}]", securityContext.getCurrentUserId(), saveSentenceDto);
        EISentenceDO sentenceDo;
        try {
            sentenceDo = sentenceService.saveSentence(saveSentenceDto);
        } catch (Exception e) {
            log.error("用户[{}]保存句子失败", securityContext.getCurrentUserId(), e);
            return ResponseEntity.internalServerError().body(Result.fail("服务器内部错误，保存句子失败"));
        }
        saveSentenceDto.setSentenceId(sentenceDo.getId());
        return ResponseEntity.ok(Result.success(saveSentenceDto));
    }
}
