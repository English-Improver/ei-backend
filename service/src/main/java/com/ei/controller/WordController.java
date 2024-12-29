package com.ei.controller;

import com.ei.service.sentence.NlpProcessService;
import com.ei.service.user.EIUserService;
import com.ei.service.word.WordService;
import com.ei.util.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.dto.word.WordDto;
import pojo.vo.WordVO;

/**
 * @author yitiansong
 */
@RestController
@RequestMapping("/word")
public class WordController {
    private final WordService wordService;

    private final NlpProcessService nlpProcessService;

    private final EIUserService userService;

    public WordController(WordService wordService, NlpProcessService nlpProcessService, EIUserService userService) {
        this.wordService = wordService;
        this.nlpProcessService = nlpProcessService;
        this.userService = userService;
    }

    /**
     * 单纯的保存单词
     *
     * @param wordVO
     * @return
     */
    @PostMapping
    public ResponseEntity<WordDto> saveWord(@RequestBody WordVO wordVO) {

        return null;

    }

    @PostMapping("/saveWordInSentence")
    public ResponseEntity<Result> saveWordInSentence() {
        return null;
    }
}
