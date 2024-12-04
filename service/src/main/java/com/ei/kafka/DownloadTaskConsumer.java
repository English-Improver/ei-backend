//package com.ei.kafka;
//
//import com.ei.service.WebSocketService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//import pojo.dto.kafka.DownloadTask;
//
///**
// * @author: songrunqi
// * @since 18:14
// **/
//
//// 5. 下载任务消费者
//@Service
//public class DownloadTaskConsumer {
//    @Autowired
//    private WebSocketService webSocketService;
//
//    @KafkaListener(topics = "download-tasks", groupId = "download-group")
//    public void consume(DownloadTask task) {
//        try {
//            // 更新任务状态
//            task.setStatus("PROCESSING");
//
//            // 执行下载逻辑
//            downloadFile(task.getDownloadUrl());
//
//            // 下载完成，更新状态
//            task.setStatus("COMPLETED");
//
//            // 通过WebSocket通知前端
//            webSocketService.notifyDownloadComplete(task);
//        } catch (Exception e) {
//            task.setStatus("FAILED");
//            webSocketService.notifyDownloadError(task, e.getMessage());
//        }
//    }
//
//    private void downloadFile(String url) {
//        // 实现文件下载逻辑
//        // 这里省略具体实现...
//    }
//}
