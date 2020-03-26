package com.book.poq.bookgenerator.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableConfigurationProperties(PoqBookTopicProperties.class)
public class PoqGeneratorKafkaConfiguration {

    @Bean
    public NewTopic bookTopic(PoqBookTopicProperties properties){
        return TopicBuilder
                .name(properties.getName())
                .partitions(properties.getPartitions())
                .replicas(properties.getReplicas())
                .build();
    }
}
