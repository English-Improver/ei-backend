package pojo.dto.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: songrunqi
 * @since 00:15
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DownloadStatus {
    private String taskId;
    private String status;
    private String error;

    public DownloadStatus(String taskId, String status) {
        this.taskId = taskId;
        this.status = status;
        this.error = null;
    }
}
