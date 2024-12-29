package pojo.dto.word;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

/**
 * @author yitiansong
 * 2024/5/4
 */
public class SaveWordInSentenceDto {
    private Integer sentenceId;
    @NotBlank
    private String word;
    @NotBlank
    private String pronunciation;

    private String exampleSentence;

    private String meaningInSentence;

    /**
     * 是否为单词
     * 0 不是
     * 1 是
     */
    private Integer isWord;

    public Integer getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(Integer sentenceId) {
        this.sentenceId = sentenceId;
    }

    public Integer getIsWord() {
        return isWord;
    }

    public void setIsWord(Integer isWord) {
        this.isWord = isWord;
    }

    private List<WordMeaningDTO> meanings;

    public String getWord() {
        return word;
    }

    public void setWord(@NotBlank String word) {
        this.word = word;
    }

    public @NotBlank String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(@NotBlank String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public String getMeaningInSentence() {
        return meaningInSentence;
    }

    public void setMeaningInSentence(String meaningInSentence) {
        this.meaningInSentence = meaningInSentence;
    }

    public List<WordMeaningDTO> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<WordMeaningDTO> meanings) {
        this.meanings = meanings;
    }

    @Override
    public String toString() {
        return "SaveWordInSentenceDto{" +
                "word='" + word + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", exampleSentence='" + exampleSentence + '\'' +
                ", meaningInSentence='" + meaningInSentence + '\'' +
                ", meanings=" + meanings +
                '}';
    }
}
