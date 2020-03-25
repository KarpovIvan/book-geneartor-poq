package com.book.poq.bookgenerator.controllers;

import com.book.poq.bookgenerator.model.Book;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class GeneratorController {

    private KafkaTemplate<String, Book> kafkaTemplate;
    private NewTopic topic;


    public GeneratorController(KafkaTemplate<String, Book> kafkaTemplate,
                               NewTopic topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @GetMapping
    public void generateMessage(){
        kafkaTemplate.send(topic.name(), new Book("Tales of the Jazz Age", "F. Scott Fitzgerald"));
    }
}
