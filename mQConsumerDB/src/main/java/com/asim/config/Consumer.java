package com.asim.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
@EnableRabbit
@RabbitListener(queues = "myQueue")
public class Consumer {
	
	@Autowired
	private CustomerRepository repository;
	
	@RabbitHandler
	public void onReceive(@Payload String message) {
		System.out.println("***********************************************");
//		System.out.println("Message is: " + message);
		repository.save(new Customer(message));
		Customer tmpCust = repository.findByMessage(message);
		if(tmpCust != null) {
			System.out.println(tmpCust.toString());
		}
		else {
			System.out.println("coulnd't fine message in DB: " + message);
		}
	}
	
}
