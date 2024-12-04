package pojo.model.word;

import com.baomidou.mybatisplus.annotation.TableName;
import pojo.model.BasePOJO;

/**
 * @author yitiansong
 * 单词词义表
 */
@TableName("ei_word_meaning")
public class EIWordMeaningDO extends BasePOJO {
    private Integer wordId;
    // 外键：EIposDo id
    private Integer propertyId;
    private String meaning;

    @Override
    public String toString() {
        return "EIWordMeaningDO{" +
                "wordId=" + wordId +
                ", propertyId=" + propertyId +
                ", meaning='" + meaning + '\'' +
                '}';
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
