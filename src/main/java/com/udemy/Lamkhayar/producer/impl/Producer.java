package com.udemy.Lamkhayar.producer.impl;

import com.udemy.Lamkhayar.json.Student;
import com.udemy.Lamkhayar.producer.IProducer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Producer implements IProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${udemy.rabbitmq.exchange}")
    private String exchage;
    @Value("${udemy.rabbitmq.rootingkey}")
    private String rootingKey;
    @Override
    public void produceMessage(Student student) {
        amqpTemplate.convertAndSend(exchage, rootingKey, student);
        System.out.println("Sending message = " + student.toString());
    }
}
