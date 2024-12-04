//package com.ei.config;
//
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import pojo.dto.kafka.DownloadTask;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author: songrunqi
// * @since 18:04
// **/
//// 4. Kafka消费者配置和实现
//@Configuration
//public class KafkaConsumerConfig {
//    @Bean
//    public ConsumerFactory<String, DownloadTask> consumerFactory() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "116.196.87.46:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, "download-group");
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(config);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, DownloadTask> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, DownloadTask> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//}
