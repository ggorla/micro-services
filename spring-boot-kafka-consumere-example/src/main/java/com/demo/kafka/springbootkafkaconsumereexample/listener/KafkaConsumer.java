package com.demo.kafka.springbootkafkaconsumereexample.listener;

import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;


@Service
public class KafkaConsumer {

	@KafkaListener(topics="Kafka_Example", groupId="group_id")
	public void consume(String message) {
		System.out.println("consumed message:"+message);
	}
	 
	
	
}
