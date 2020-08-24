package ir.saeidbabaei.kafkaproducer.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public class ProducerService {
	
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	private static List<String> EVENT_KEYS = Arrays.asList(
	        "student.created",
	        "course.created");
	
	private Random random = new Random();
	
	private int eventNumber = 0;
	
	public ProducerService() {

	}
	
	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void createScheduledProducer() {
	
		String eventKey =  EVENT_KEYS.get(random.nextInt(EVENT_KEYS.size()));
		
		String message = String.format("Event no. %d of type '%s'", ++eventNumber, eventKey);

		raiseEvent(eventKey,message);
	}
	
	public void createManualProducer() {
	
		String eventKey = "teacher.created";
		
		String message = String.format("Event no. %d of type '%s'", ++eventNumber, eventKey);
	  
		raiseEvent(eventKey,message);
	}
	
    private void raiseEvent(String eventKey, String message)
    {   	
        try
        {     	
            this.kafkaTemplate.sendDefault(eventKey, message);            
        }
        catch (Exception e){      	
            e.printStackTrace();          
        }
    }

}