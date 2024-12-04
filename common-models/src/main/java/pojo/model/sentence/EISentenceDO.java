package pojo.model.sentence;

import com.baomidou.mybatisplus.annotation.TableName;
import pojo.model.BasePOJO;

import java.util.Date;

/**
 * @author yitiansong
 */
@TableName("ei_sentence")
public class EISentenceDO extends BasePOJO {
    private Integer userId;
    private String sentence;
    private Date lastReadTime;
    private String sentenceExplain;

    @Override
    public String toString() {
        return "EISentenceDO{" +
                "userId=" + userId +
                ", sentence='" + sentence + '\'' +
                ", lastReadTime=" + lastReadTime +
                ", sentenceExplain='" + sentenceExplain + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Date getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(Date lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public String getSentenceExplain() {
        return sentenceExplain;
    }

    public void setSentenceExplain(String sentenceExplain) {
        this.sentenceExplain = sentenceExplain;
    }
}
