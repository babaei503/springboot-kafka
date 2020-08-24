package ir.saeidbabaei.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public class EventConsumer {

	  private Logger logger = LoggerFactory.getLogger(EventConsumer.class);

	  @KafkaListener(topics = "producer-service-event")
	  public void receive(@Payload String message, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
		  
		logger.info("Received key '{}'", key);		  
	    logger.info("Received message '{}'", message);
	    
	  }

}