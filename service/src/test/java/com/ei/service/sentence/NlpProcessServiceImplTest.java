package com.ei.service.sentence;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ei.mapper.sentence.EIPosMapper;
import com.ei.service.sentence.impl.NlpProcessServiceImpl;
import com.nlp.Token;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pojo.model.sentence.EIPosDO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Test for {@link NlpProcessServiceImpl} class.
 */
public class NlpProcessServiceImplTest {
    EIPosMapper posMapper = Mockito.mock(EIPosMapper.class);
    NlpProcessServiceImpl nlpService = new NlpProcessServiceImpl(posMapper);

    /**
     * This test focuses on the method {@link NlpProcessServiceImpl#analyzeSyntax(String)}.
     * The method is expected to annotate a given string (sentence) and return a list of {@link Token} objects.
     */
    @Test
    void testAnalyzeSyntax() throws IOException {
        String sentence = "This is a test sentence.";

        List<EIPosDO> posDOList = new ArrayList<>();
        EIPosDO posDO = new EIPosDO();
        posDO.setName("NN");
        posDO.setColor("green");
        posDOList.add(posDO);

        when(posMapper.selectList(any(QueryWrapper.class))).thenReturn(posDOList);
        List<Token> result = nlpService.analyzeSyntax(sentence);
        assertEquals(5, result.size());
        for (Token token : result) {
            if ("sentence".equals(token.getWord())) {
                assertEquals("green", token.getColor());
            }
        }
    }
}