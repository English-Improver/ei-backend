package pojo.dto.word;

import jakarta.validation.constraints.NotBlank;

/**
 * @author 86157
 * 2024/1/8
 */
public class WordDto {
    // 单词
    @NotBlank
    private String word;
    // 单词属于的句子
    private String belongSentence;

    public @NotBlank String getWord() {
        return word;
    }

    public void setWord(@NotBlank String word) {
        this.word = word;
    }

    public String getBelongSentence() {
        return belongSentence;
    }

    public void setBelongSentence(String belongSentence) {
        this.belongSentence = belongSentence;
    }

    @Override
    public String toString() {
        return "WordDto{" +
                "word='" + word + '\'' +
                ", belongSentence='" + belongSentence + '\'' +
                '}';
    }
}
