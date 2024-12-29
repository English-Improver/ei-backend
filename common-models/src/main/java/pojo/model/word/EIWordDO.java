package pojo.model.word;

import com.baomidou.mybatisplus.annotation.TableName;
import pojo.model.BasePOJO;

/**
 * @author yitiansong
 * 单词表短语表,如果是单词，意思存储在ei_word_meaning表中，如果是短语，意思存储在ei_word表中
 */
@TableName("ei_word")
public class EIWordDO extends BasePOJO {
    private String word;
    private String pronunciation;
    private Integer userId;
    /**
     * 是否为单词
     * 0 不是
     * 1 是
     */
    private Integer isWord;

    /**
     * 短语的意思
     */
    private String meaning;

    public Integer getIsWord() {
        return isWord;
    }

    public void setIsWord(Integer isWord) {
        this.isWord = isWord;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
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


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "EIWordDO{" +
                "word='" + word + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", userId=" + userId +
                ", isWord=" + isWord +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
