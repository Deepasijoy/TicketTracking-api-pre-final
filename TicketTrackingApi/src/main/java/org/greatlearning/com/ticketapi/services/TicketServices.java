package org.greatlearning.com.ticketapi.services;



import java.util.List;

import org.greatlearning.com.ticketapi.entity.Ticket;
import org.springframework.data.domain.Page;





public interface TicketServices {
	
	
Ticket insertTicket(Ticket ticket);
List<Ticket>getAllTickets();
Ticket getTicketByTicketNumber(int ticketNumber);
Ticket updateTicket(Ticket t);
void deleteTicketById(int ticketNumber);
/*
 * Page<Ticket>
 * getTicketCustomPagedAndSortedWithDefaultOrderByTitleAndWithTicketsSearchedfor(
 * String ticketTitle, String ticketDescription);
 */
boolean searchTicketByTicketTitle(String ticketTitle);

}