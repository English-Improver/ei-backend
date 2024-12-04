package pojo.dto.word;


/**
 * @author yitiansong
 * 单词意思DTO
 * 2024/5/2
 */
public class WordMeaningDTO {
    private String property;
    private String meaning;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "WordMeaningDTO{" +
                "property='" + property + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
