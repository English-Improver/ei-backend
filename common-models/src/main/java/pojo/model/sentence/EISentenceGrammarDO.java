package pojo.model.sentence;

import pojo.model.BasePOJO;

/**
 * @author yitiansong
 */
public class EISentenceGrammarDO extends BasePOJO {
    private Integer sentenceId;
    private Integer constituentId;
    private Integer seq;

    @Override
    public String toString() {
        return "EISentenceGrammarDO{" +
                "sentenceId=" + sentenceId +
                ", constituentId=" + constituentId +
                ", seq=" + seq +
                '}';
    }

    public Integer getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(Integer sentenceId) {
        this.sentenceId = sentenceId;
    }

    public Integer getConstituentId() {
        return constituentId;
    }

    public void setConstituentId(Integer constituentId) {
        this.constituentId = constituentId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
