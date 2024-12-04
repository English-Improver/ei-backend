package com.ei.ai.service.word;

import com.util.CommonUtils;
import com.util.JSONUtils;
import org.springframework.ai.client.AiClient;
import org.springframework.stereotype.Service;
import pojo.dto.word.WordDto;
import pojo.vo.WordVO;

/**
 * @author yitiansong
 * 2024/5/2
 */
@Service
public class WordAssistanceServiceImpl implements WordAssistanceService {

    private final AiClient aiClient;

    public WordAssistanceServiceImpl(AiClient aiClient) {
        this.aiClient = aiClient;
    }

    @Override
    public WordVO explainWordInSentence(WordDto wordDto) {
        // if no sentence
        String belongSentence = wordDto.getBelongSentence();
        String prompt = "";

        prompt = """
                我会提供一个单词和一个句子，这个句子可能不存在，如果我提供了句子，解释这个单词在句子中的意思。单词翻译这个单词的意思，并以JSON的形式返回给我这个单词的音标、词性、意思；如果有多个词性和相应的意思，以数组的形式返回给我;
                如果一个词性有多个意思，则放在一起； 
                例子，input word: example, sentence: Here is the example
                以json的形式返回给我如下格式：
                {
                    word : 'example',
                    pronunciation: '/prəˌnʌnsiˈeɪʃ(ə)n/',
                    meaningInSentence: '在这个句子中，example的意思是xxx，词性为xxx，时态为xxx',
                    meanings: [
                    {
                        property: 'NN',
                        meaning: '发音,发音读法;(某人的)发音'
                    },
                    {
                    ..
                    }
                    ]
                }
                                    
                以下是我提供的信息：
                """;

        prompt += "word: " + wordDto.getWord() + '\n';

        String sentence = wordDto.getBelongSentence();
        boolean hasSentence = CommonUtils.isNotEmpty(sentence);
        prompt += hasSentence ? "" : "sentence: " + wordDto.getBelongSentence() + '\n';
        String generateWordResult = aiClient.generate(prompt);
        return JSONUtils.toObject(generateWordResult, WordVO.class);
    }
}
