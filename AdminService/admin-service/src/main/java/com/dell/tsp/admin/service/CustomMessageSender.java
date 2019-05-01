package com.dell.tsp.admin.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Component
public class CustomMessageSender {
	
	private static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);
	 
	@Autowired
    private final RabbitTemplate rabbitTemplate;
 
    public CustomMessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
 
    @Scheduled(fixedDelay = 3000L)
    public void sendMessage(CustomMessage message) {
        
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(MessagingApplication.EXCHANGE_NAME, MessagingApplication.ROUTING_KEY, message);
    }

}
