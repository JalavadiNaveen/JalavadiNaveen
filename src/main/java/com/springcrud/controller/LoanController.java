package com.springcrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springcrud.beans.Ticket;
import com.springcrud.dao.LoanDao;
import com.springcrud.dao.LoanStatusDao;
import com.springcrud.dao.TicketDao;
import com.springcrud.beans.Loan;
import com.springcrud.beans.LoanStatus;
@Controller
public class LoanController {
	@Autowired
	LoanDao dao1;
	@Autowired
	LoanStatusDao dao2;
	long id=0;
	@RequestMapping(value="/loginfg",  method=RequestMethod.GET)
	public String showForm(Model m){
		m.addAttribute("loan", new Loan());
		m.addAttribute("loanstatus",new LoanStatus());
		return "login";
	}
	@RequestMapping(value="/saveLoan", method=RequestMethod.POST)
	public String save(@ModelAttribute("loanstatus")LoanStatus loanstatus){
		dao1.newLoan(loanstatus);
		loanstatus.setStatus("Accepted");
		//dao2.updateLoanStatus(loanstatus);
		return "ViewLoanStatus";
	}
	@RequestMapping("/viewAcceptedLoans")
	public String viewloans(Model m){
		List<Loan> loanlist= dao1.getLoanDetails();
		m.addAttribute("list",loanlist);
		return "AdminLoan";
	}
	
	/*@RequestMapping(value="/ediloan/{loanid}")
	public String editLoan(@PathVariable int loanid, Model m){
		Loan loan=dao1.getLoanById(loanid);
		id=loan.getLoan_id();
		m.addAttribute("list",loan);
		return "EditTicket";
	}
	@RequestMapping(value="/editLoanUpdate",method=RequestMethod.POST)
	public String editLoanUpdate(@ModelAttribute("loan") Loan loan){
		loan.setLoan_id(id);
		dao1.update(loan);
		return "redirect:/ViewTickets";
	}*/
	@RequestMapping(value="/deletethisLoan/{loanid}")
	public String deleteLoan(@PathVariable int loanid){
		dao1.delete(loanid);
		dao2.deleteLoan(loanid);
		return "redirect:/viewAcceptedLoans";
	}
}
