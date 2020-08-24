package ir.saeidbabaei.kafkaproducer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import ir.saeidbabaei.kafkaproducer.service.ProducerService;

@Configuration
@EnableScheduling
public class EventProducerConfiguration {

	 @Bean
	 public ProducerService producerService() {
		 
	   return new ProducerService();
	   
	 }

}