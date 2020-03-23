package com.mykyta.bookgenerator.controllers;

import com.mykyta.bookgenerator.model.Book;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Exchange;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generator")
public class GeneratorController {

    private AmqpTemplate amqpTemplate;
    private Exchange exchange;

    public GeneratorController(AmqpTemplate amqpTemplate, Exchange exchange) {
        this.amqpTemplate = amqpTemplate;
        this.exchange = exchange;
    }

    @PostMapping("/book")
    public void generateBook(){
        amqpTemplate.convertAndSend(exchange.getName(), "", new Book("Heart of a Dog", "Mikhail Bulgakov"));
    }



}
