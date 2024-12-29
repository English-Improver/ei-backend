package pojo.dto.sentence;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: songrunqi
 * @since 22:55
 **/
@Setter
@Getter
public class SaveSentenceDto {
    @NotBlank
    private String sentence;
    @NotBlank
    private String explanation;

    // 单词拥有人
    private Integer userId;
    private Integer sentenceId;
}
