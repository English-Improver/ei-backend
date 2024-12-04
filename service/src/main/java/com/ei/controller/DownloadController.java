//package com.ei.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import pojo.dto.kafka.DownloadTask;
//
//import java.util.UUID;
//
///**
// * @author: songrunqi
// * @since 18:06
// **/
//public class DownloadController {
//    @Autowired
//    private KafkaTemplate<String, DownloadTask> kafkaTemplate;
//
//    @PostMapping("/submit")
//    public ResponseEntity<String> submitDownload(@RequestBody DownloadTask task) {
//        task.setTaskId(UUID.randomUUID().toString());
//        task.setStatus("PENDING");
//        // 发送到kafka队列
//        kafkaTemplate.send("download-tasks", task.getTaskId(), task);
//        return ResponseEntity.ok(task.getTaskId());
//    }
//}
