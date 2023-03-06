package com.sai.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.core.MessagePostProcessor;
import org.springframework.messaging.support.MessageBuilder;

import java.time.Instant;

@SpringBootApplication
public class ProducerApplication {

	@Bean
	ApplicationListener <ApplicationReadyEvent> ready(RocketMQTemplate template){
		return readyEvent -> {
               var now = Instant.now();
			   var destination = "greetings-topic";
			   for(var name: "Sai,Ashish".split(",")){
				   var payload = new Greeting("Hello" + name + "@" + Instant.now() );
                   var messagePostProcessor = new MessagePostProcessor() {
					   @Override
					   public Message<?> postProcessMessage(Message<?> message) {
						  var letter = Character.toString(name.toLowerCase().charAt(0));
						  return MessageBuilder
								  .fromMessage(message)
								  .setHeader("letter", letter)
								  .build();
					   }
				   };
                   template.convertAndSend(destination, payload, messagePostProcessor);
			   }
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

}
