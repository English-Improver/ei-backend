package pojo.dto.kafka;

import lombok.Data;

/**
 * @author: songrunqi
 * @since 18:05
 **/
@Data
// 1. 首先是下载任务的实体类
public class DownloadTask {
    private String taskId;
    private String downloadUrl;
    private String status;
    // getters and setters
}