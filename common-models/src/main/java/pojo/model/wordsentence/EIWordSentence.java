package pojo.model.wordsentence;

import pojo.model.BasePOJO;

/**
 * @author yitiansong
 */
public class EIWordSentence extends BasePOJO {
    private Integer wordMeaningId;

    @Override
    public String toString() {
        return "EIWordSentence{" +
                "wordMeaningId=" + wordMeaningId +
                '}';
    }

    public Integer getWordMeaningId() {
        return wordMeaningId;
    }

    public void setWordMeaningId(Integer wordMeaningId) {
        this.wordMeaningId = wordMeaningId;
    }
}
