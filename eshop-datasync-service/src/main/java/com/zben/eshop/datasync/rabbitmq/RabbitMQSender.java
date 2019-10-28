package com.zben.eshop.datasync.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 17:03
 */
@Component
public class RabbitMQSender {

    @Autowired
    AmqpTemplate rabbitMQTemplate;

    public void send(String queue, String message) {
        rabbitMQTemplate.convertAndSend(queue, message);
    }
}
