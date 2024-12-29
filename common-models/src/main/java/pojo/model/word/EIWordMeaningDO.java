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
//    private Integer propertyId;
    private String property;
    private String meaning;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
