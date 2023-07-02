package com.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RabbitController {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@GetMapping("/bar")
	public ResponseEntity<?> getMessageAndPublish(@RequestParam("msg") String message){
		//System.out.println(message);
		rabbitTemplate.send(ProducerConfig.exchange,ProducerConfig.routingKey,new Message(message.getBytes()));
		return new ResponseEntity<>("Vlaue successfully send to the consumer",HttpStatusCode.valueOf(200));
	}
	
}
