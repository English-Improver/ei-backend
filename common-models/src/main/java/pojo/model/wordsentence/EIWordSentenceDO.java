package pojo.model.wordsentence;

import com.baomidou.mybatisplus.annotation.TableName;
import pojo.model.BasePOJO;

/**
 * @author yitiansong
 */
@TableName("ei_word_sentence")
public class EIWordSentenceDO extends BasePOJO {
    // ?
    private Integer wordMeaningId;
    private String meaning;
    private Integer sentenceId;
    private Integer wordId;
    @Override
    public String toString() {
        return "EIWordSentence{" +
                "wordMeaningId=" + wordMeaningId +
                '}';
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public Integer getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(Integer sentenceId) {
        this.sentenceId = sentenceId;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Integer getWordMeaningId() {
        return wordMeaningId;
    }

    public void setWordMeaningId(Integer wordMeaningId) {
        this.wordMeaningId = wordMeaningId;
    }
}
