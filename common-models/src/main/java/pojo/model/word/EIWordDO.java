package pojo.model.word;

import com.baomidou.mybatisplus.annotation.TableName;
import pojo.model.BasePOJO;

/**
 * @author yitiansong
 * 单词表
 */
@TableName("ei_word")
public class EIWordDO extends BasePOJO {
    private String word;
    private String pronunciation;
    private Integer posId;
    private Integer userId;
    private String property;

    @Override
    public String toString() {
        return "EIWordDO{" +
                "word='" + word + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", posId=" + posId +
                ", userId=" + userId +
                ", property='" + property + '\'' +
                '}';
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
