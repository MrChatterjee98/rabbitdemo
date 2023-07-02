package com.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class QueueListner {
	
@RabbitListener(queues = {"queue1"})
	public void messageHandler(String s) {
		System.out.println(s);
	}
}
