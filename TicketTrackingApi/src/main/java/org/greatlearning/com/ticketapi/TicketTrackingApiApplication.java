package org.greatlearning.com.ticketapi;

import org.greatlearning.com.ticketapi.entity.Ticket;
import org.greatlearning.com.ticketapi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class TicketTrackingApiApplication implements CommandLineRunner {
	@Autowired
	TicketRepository ticketRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketTrackingApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		 
		  
		 
	}

}
