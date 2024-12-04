package pojo.dto.kafka;

/**
 * @author: songrunqi
 * @since 12:59
 **/

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String id;
    private String content;
    private Long timestamp;
}
