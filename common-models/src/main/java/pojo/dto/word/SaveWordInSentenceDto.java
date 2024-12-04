package pojo.dto.word;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

/**
 * @author yitiansong
 * 2024/5/4
 */
public class SaveWordInSentenceDto {
    @NotBlank
    private String word;
    @NotBlank
    private String pronunciation;
    @NotBlank
    private String exampleSentence;

    private String meaningInSentence;
    @NotBlank
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

    public @NotBlank String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(@NotBlank String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public String getMeaningInSentence() {
        return meaningInSentence;
    }

    public void setMeaningInSentence(String meaningInSentence) {
        this.meaningInSentence = meaningInSentence;
    }

    public @NotBlank List<WordMeaningDTO> getMeanings() {
        return meanings;
    }

    public void setMeanings(@NotBlank List<WordMeaningDTO> meanings) {
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
