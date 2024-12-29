package pojo.vo;

import pojo.dto.word.WordMeaningDTO;

import java.util.List;

/**
 * @author yitiansong
 * 2024/5/2
 */
public class WordVO {
    private String word;
    private String pronunciation;
    private String meaningInSentence;
    private List<WordMeaningDTO> meanings;
    private Integer isWord;

    public Integer getIsWord() {
        return isWord;
    }

    public void setIsWord(Integer isWord) {
        this.isWord = isWord;
    }

    @Override
    public String toString() {
        return "WordVO{" +
                "word='" + word + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", meaningInSentence='" + meaningInSentence + '\'' +
                ", meanings=" + meanings +
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
}
