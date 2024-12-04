package com.ei.service.sentence.impl;

import com.ei.mapper.sentence.EIPosMapper;
import com.ei.service.sentence.NlpProcessService;
import com.nlp.Token;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NlpProcessServiceImplTest {
    @Mock
    private EIPosMapper posMapper;

    @Mock
    private CoreDocument coreDocument;

    @Mock
    private Token token;
    @Mock
    private NlpProcessService nipProcessService;

    @Test
    public void analyzeSyntax_returnsListOfTokens() {
        MockitoAnnotations.openMocks(this);

        String sentence = "Stumbled upon a yet another AI-generated blog post. As much as I appreciate and admire AI, I think we are moving blazing fast towards the place where genuine content created by people who know what they are talking about will be invaluableTest sentence";
        List<CoreLabel> coreLabels = new ArrayList<>();
        List<Token> tokens = nipProcessService.analyzeSyntax(sentence);


    }
}