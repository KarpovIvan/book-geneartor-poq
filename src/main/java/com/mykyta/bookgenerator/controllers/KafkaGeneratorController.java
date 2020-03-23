package com.mykyta.bookgenerator.controllers;

import com.mykyta.bookgenerator.model.Book;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaGeneratorController {

    private KafkaTemplate kafkaTemplate;
    private NewTopic topic;

    public KafkaGeneratorController(KafkaTemplate kafkaTemplate, NewTopic topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @GetMapping
    public void generateMessage(@RequestParam("text") String text){
        kafkaTemplate.send(topic.name(), new Book("Tales of the Jazz Age", "F. Scott Fitzgerald"));
    }
}
