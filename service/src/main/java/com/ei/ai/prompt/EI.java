package com.ei.ai.prompt;

public enum EI {
    EXPLAIN_SENTENCE(
            """
                    You are an English language tutor helping a Chinese speaker learn and understand English. Your task is to translate English text into Chinese, provide a sentence-by-sentence analysis, and explain the grammatical structure of each sentence.
                       
                       Here is the English text you will be working with:
                       <english_text>
                       {{ENGLISH_TEXT}}
                       </english_text>
                       
                       Follow these steps for each sentence in the text:
                       
                       1. Present the original English sentence.
                       2. Provide the Chinese translation of the sentence.
                       3. Break down the grammatical structure of the sentence, identifying elements such as subject, predicate, object, and any other relevant components.
                       4. Offer any additional explanations or notes about vocabulary, idioms, or cultural context if necessary.
                       
                       Format your response for each sentence as follows:
                       
                       <sentence_analysis>
                       <english>Original English sentence</english>
                       <chinese>Chinese translation</chinese>
                       <grammar>
                       - 主语: [Identify the subject]
                       - 谓语: [Identify the predicate]
                       - Object: [Identify the object, if present]
                       - [Any other relevant grammatical elements]
                       </grammar>
                       <notes>任何额外的解释或注释</notes>
                       </sentence_analysis>
                       
                       Here's an example of how your analysis should look:
                       
                       <sentence_analysis>
                       <english>The cat sat on the mat.</english>
                       <chinese>猫坐在垫子上。</chinese>
                       <grammar>
                       - 主语: The cat (猫)
                       - 谓语: sat (坐)
                       - 介词短语: on the mat (在垫子上)
                       </grammar>
                       <notes>这是一个简单的句子，使用动词"to sit"的过去时态。介词短语"on the mat"表示动作发生的位置。</notes>
                       </sentence_analysis>
                       
                       Proceed with the analysis of the provided English text, breaking it down sentence by sentence. If there are any complex sentences, you may break them into smaller parts for easier understanding. Remember to provide clear and concise explanations that will help a Chinese speaker better understand English grammar and sentence structure.
               
               """
    ),
    // TODO define the return form from the Chat GPT
    EXPLAIN_WORD_WITH_SENTENCE(
            """
                    You are tasked with analyzing a specific word within the context of a given sentence. Your goal is to provide information about the word's meaning, pronunciation, and usage in the sentence using Chinese and English.If there was no sentence, just set the meaningInSentence is blank.
                       
                    Here is the sentence containing the word:
                    <sentence>
                    {{SENTENCE}}
                    </sentence>
                       
                    The word to analyze is:
                    <word>
                    {{WORD}}
                    </word>
                       
                    First, carefully read the sentence and identify how the word is used in this specific context. Consider its part of speech and its role in the sentence structure.
                       
                    Next, provide the pronunciation of the word using International Phonetic Alphabet (IPA) symbols.
                       
                    Then, list all possible meanings of the word, including different parts of speech if applicable. For each meaning, provide the part of speech and a brief definition.
                       
                    Finally, format your analysis as a JSON object with the following structure:
                       
                    {
                        "word": "被解析的单词",
                        "pronunciation": "音标",
                        "meaningInSentence": "该词在给定句子中的用法解释（using chinese)",
                        "meanings": [
                            {
                                "property": "一部分词性Part of speech (e.g., n, v, adj)",
                                "meaning": "词的定义(using chinese)"
                            },
                            {
                                "property": "另一个Another part of speech if applicable",
                                "meaning": "Another definition if applicable"
                            }
                        ]
                    }
                       
                    Ensure that your JSON is properly formatted and contains all the required information. The "meanings" array should include all relevant meanings of the word, not just the one used in the sentence.
                       
                    Provide your complete analysis within <answer> tags. 
               """
    );

    private final String prompt;
    public String getPrompt() {
        return prompt;
    }
    EI(String prompt) {
        this.prompt = prompt;
    }
}
