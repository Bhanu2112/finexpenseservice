package com.org.bhanu.expenseservice;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Schedular {
	
	
	RestTemplate restTemplate;
	
	
	
	
	public Schedular() {
		
		this.restTemplate = new RestTemplate();
	}




	@Scheduled(cron = "0 */10 * * * ?")
	//@Scheduled(cron = "0 */5 * * * ?")

	public void scheduleFetch() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
	            "dd-MM-yyyy HH:mm:ss.SSS");

	        String strDate = dateFormat.format(new Date());
	        
	       String userServiceHealth =  restTemplate.getForObject("https://finuserservie.onrender.com/user/welcome", String.class);
	       String expenseServiceHealth = restTemplate.getForObject("https://finexpenseservice.onrender.com/welcome", String.class);
	        System.out.println(
	            "Cron job Scheduler: Job running at - "
	            + strDate);
	        
	        System.out.println(
	        		"User service health : "+userServiceHealth
	        		);
	        System.out.println("Expense service health : "+expenseServiceHealth);
	}

}
