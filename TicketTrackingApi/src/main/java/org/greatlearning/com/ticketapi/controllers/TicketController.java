package org.greatlearning.com.ticketapi.controllers;

import java.util.List;


import org.greatlearning.com.ticketapi.entity.Ticket;
import org.greatlearning.com.ticketapi.services.TicketServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketController {
	
	private TicketServices ticketServices;

	public TicketController(TicketServices ticketServices) {
		super();
		this.ticketServices = ticketServices;
	}
	
	@GetMapping("/tickets")
	public String listTickets(Model model) {
	List<Ticket>tickets=ticketServices.getAllTickets();
	model.addAttribute("tickets", tickets);
		return "tickets";
		
	}
	
	@GetMapping("/tickets/new")
	public String createTicketForm(Model model) {
		Ticket ticket=new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";

}

	@PostMapping("/tickets")
		public String saveTicket(@ModelAttribute("ticket")Ticket ticket) {
			ticketServices.insertTicket(ticket);
			return "redirect:/tickets";
		}

	@GetMapping("/tickets/{ticketNumber}")
	public String deleteTicketById(@PathVariable("ticketNumber")int ticketNumber) {
		ticketServices.deleteTicketById(ticketNumber);
		return "redirect:/tickets";				
	}
	
	@GetMapping("/tickets/edit/{ticketNumber}")
	public String editEmployeeForm(@PathVariable("ticketNumber")int ticketNumber,Model model) {
	Ticket ticket=ticketServices.getTicketByTicketNumber(ticketNumber);
	model.addAttribute("ticket", ticket);
		return "edit_ticket";
		
	}
	
	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable("id") int ticketNumber,
			@ModelAttribute("ticket") Ticket ticket) {
		Ticket existingTicket=ticketServices.getTicketByTicketNumber(ticketNumber);
		existingTicket.setTicketTitle(ticket.getTicketTitle());
		existingTicket.setTicketDescription(ticket.getTicketDescription());
		existingTicket.setDate(ticket.getDate());
		ticketServices.insertTicket(existingTicket);
				return "redirect:/tickets";
		
	}
	
	@GetMapping("/tickets/view")
	public boolean searchTicketByTicketTitle(String ticketTitle) {
		 return ticketServices.searchTicketByTicketTitle(ticketTitle);
		
	}
		
}
