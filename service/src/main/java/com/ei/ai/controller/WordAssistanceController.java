package com.ei.ai.controller;


import com.ei.ai.service.word.WordAssistanceService;
import jakarta.validation.Valid;
import org.springframework.ai.client.AiClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.dto.word.WordDto;
import pojo.vo.WordVO;


/**
 * AI 控制器
 * 将调用LLM的接口都放在这里
 * @author yitiansong
 */
@RestController
@RequestMapping("/assistant")
public class WordAssistanceController {
    // Spring AI chat client
    final AiClient aiClient;
    // word
    private final WordAssistanceService wordAssistanceService;

    public WordAssistanceController(AiClient aiClient, WordAssistanceService wordAssistanceService) {
        this.aiClient = aiClient;
        this.wordAssistanceService = wordAssistanceService;
    }

    /**
     * 获取指定单词在句子中的意思
     *
     */
    @PostMapping("/word")
    public ResponseEntity<WordVO> getWordMeaningInSentence(@Valid @RequestBody WordDto wordDto) {
        WordVO wordVO = wordAssistanceService.explainWordInSentence(wordDto);
        return ResponseEntity.ok(wordVO);
    }

    @PostMapping("/sentence")
    public ResponseEntity<String> processToken(@RequestBody String sentence) {
        // 创建prompt，进行语法解析
        String promptStr =
                """
                        我希望你充当我的英语助教。我会给你一些英文句子，这些句子可能不止一个。
                        你的任务是：首先将所有句子进行翻译，然后对每个句子分别进行语法解析和解释,包括分析句子成分(主语、谓语、宾语等)、语法结构(从句、同位语等)、时态和语气等;
                        如果句子中包含任何固定搭配或常用短语，请特别指出并解释。
                        句子:
                
                """;
        String generate = aiClient.generate(promptStr + sentence);
        // markdown 去掉
        String markdown = generate.replace("```", "").replace("markdown", "");
        System.out.println("generate = " + generate);
        System.out.println("markdown = " + markdown);
        return new ResponseEntity<>(markdown, HttpStatus.OK);
    }
}

