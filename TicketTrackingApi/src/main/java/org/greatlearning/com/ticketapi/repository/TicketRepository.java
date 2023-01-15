package org.greatlearning.com.ticketapi.repository;

import org.greatlearning.com.ticketapi.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
