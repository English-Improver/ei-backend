package com.ei.controller;

import com.ei.service.sentence.NlpProcessService;
import com.ei.service.sentence.SentenceService;
import com.nlp.Token;
import org.springframework.ai.client.AiClient;
import org.springframework.ai.client.AiResponse;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



/**
 * @author yitiansong
 */
@RestController
@RequestMapping("/processSentence/notdo")
@Deprecated
public class NlpController {
    private final NlpProcessService nlpProcessService;
    private final SentenceService sentenceService;

    private final AiClient aiClient;
    public NlpController(NlpProcessService nlpProcessService, SentenceService sentenceService, AiClient aiClient) {
        this.nlpProcessService = nlpProcessService;
        this.sentenceService = sentenceService;
        this.aiClient = aiClient;
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> processToken(@RequestBody String sentence) {
        var token = nlpProcessService.analyzeSyntax(sentence);
        Map<String, Object> map = new java.util.HashMap<>(Map.of("tokens", token));
        // 创建prompt，进行语法解析
        String promptStr =
                """
                我想让你充当一个英语助教。我会给你一些英语句子,你需要完成以下两个任务:
                             
                1.将这些句子精准地翻译成中文。
                2.对这些句子进行语法解析和解释,包括分析句子成分(主语、谓语、宾语等)、语法结构(从句、同位语等)、时态和语气等。
                在翻译和解释时,请尽量分段清晰地表达每个句子的中文含义和语法特点,确保我能够很好地理解句子的用法和结构。请以Markdown格式回复,使用適当的代码块区分中英文内容。
                句子:
                
                """;
        Prompt prompt = new Prompt(promptStr + sentence);
        AiResponse generate = aiClient.generate(prompt);
        System.out.println("generate = " + generate);
        map.put("analyze", generate.getGeneration());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
