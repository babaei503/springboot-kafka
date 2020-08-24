package ir.saeidbabaei.kafkaconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ir.saeidbabaei.kafkaconsumer.consumer.EventConsumer;

@Configuration
public class EventConsumerConfiguration {

  @Bean
  public EventConsumer eventReceiver() {
    return new EventConsumer();
  }

}