package com.book.poq.bookgenerator.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class PoqGeneratorKafkaConfiguration {

    @Bean
    public NewTopic bookTopic(){
        return TopicBuilder
                .name("BookTopic")
                .partitions(2)
                .replicas((short)1)
                .build();
    }
}
