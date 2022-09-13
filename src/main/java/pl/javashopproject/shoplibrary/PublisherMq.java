package pl.javashopproject.shoplibrary;

import ch.qos.logback.classic.pattern.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PublisherMq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public String get(@RequestParam String message){
        rabbitTemplate.convertAndSend("message", message);
        return "send";

    }


}
