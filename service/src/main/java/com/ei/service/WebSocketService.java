package com.ei.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import pojo.dto.kafka.DownloadStatus;
import pojo.dto.kafka.DownloadTask;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
// 7. WebSocket服务
/**
 * @author: songrunqi
 * @since 18:17
 **/

@Service
public class WebSocketService {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void notifyDownloadComplete(DownloadTask task) {
        messagingTemplate.convertAndSend(
                "/topic/downloads/" + task.getTaskId(),
                new DownloadStatus(task.getTaskId(), "COMPLETED")
        );
    }

    public void notifyDownloadError(DownloadTask task, String error) {
        messagingTemplate.convertAndSend(
                "/topic/downloads/" + task.getTaskId(),
                new DownloadStatus(task.getTaskId(), "FAILED", error)
        );
    }
}

