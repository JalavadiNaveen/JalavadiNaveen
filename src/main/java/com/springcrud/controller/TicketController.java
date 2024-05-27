package com.springcrud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcrud.beans.Ticket;
import com.springcrud.dao.TicketDao;

@Controller
public class TicketController {
	@Autowired
	TicketDao dao;
	int id=0;
	int userid=0;
	@RequestMapping(value="/asknewticket",  method=RequestMethod.GET)
	public String showForm(Model m){
		m.addAttribute("ticket", new Ticket());
		return "NewTicket";
		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public int save(@ModelAttribute("ticket")Ticket ticket){
		return dao.newticket(ticket);
	}

	@RequestMapping("/ViewTickets")
	public String viewticket(Model m){
		List<Ticket> ticketList= dao.getTicketDetails();
		m.addAttribute("list",ticketList);
		return "ViewTickets";
	}
	@RequestMapping("/UserViewTickets")
	public String viewtickets(Model m){
		List<Ticket> ticketList= dao.getTicketsByUserId(userid);
		m.addAttribute("list",ticketList);
		return "UserViewTickets";
	}	
	@RequestMapping(value="/editemp/{ticketid}")
	public String edit(@PathVariable int ticketid, Model m){
		Ticket ticket=dao.getTicketById(ticketid);
		id=ticket.getTicket_id();
		m.addAttribute("list",ticket);
		return "EditTicket";
	}
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public String editSave(@ModelAttribute("ticket") Ticket ticket){
		ticket.setTicket_id(id);
		dao.update(ticket);
		return "redirect:/ViewTickets";
	}
	@RequestMapping(value="/deleteemp/{ticketid}")
	public String delete(@PathVariable int ticketid){
		dao.delete(ticketid);
		return "redirect:/ViewTickets";
	}
}