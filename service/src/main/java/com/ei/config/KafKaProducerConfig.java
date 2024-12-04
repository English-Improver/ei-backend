//package com.ei.config;
//
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.ser.std.StringSerializer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import pojo.dto.kafka.DownloadTask;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author: songrunqi
// * @since 18:10
// **/
//public class KafKaProducerConfig {
//    @Bean
//    public ProducerFactory<String, DownloadTask> producerFactory() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "116.176.87.46:9092");
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(config);
//    }
//
//    @Bean
//    public KafkaTemplate<String, DownloadTask> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//}
