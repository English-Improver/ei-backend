package com.ei.service.sentence;

import com.nlp.Token;

import java.util.List;

/**
 * @author yitiansong
 */
@Deprecated
public interface NlpProcessService {
    List<Token> analyzeSyntax(String sentence);

    /**
     * Returns the root word of a given word.
     *
     * @param word the word to process
     * @return the root word of the sentence
     */
    String getRootWord(String word);
}
