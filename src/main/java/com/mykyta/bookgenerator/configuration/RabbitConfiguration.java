package com.mykyta.bookgenerator.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue bookQueue() {
        return QueueBuilder.durable("bookQueue").build();
    }

    @Bean
    public Exchange bookExchange(){
        return ExchangeBuilder.fanoutExchange("bookExchange").build();
    }

    @Bean
    public Binding bookBinding() {
        return BindingBuilder.bind(bookQueue()).to(bookExchange()).with("").noargs();
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}
