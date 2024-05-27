package com.springcrud.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcrud.dao.LoanDao;
import com.springcrud.dao.LoanStatusDao;
import com.springcrud.beans.LoanStatus;
@Controller
public class LoanstatusController {
	@Autowired
	LoanStatusDao dao2;
	@Autowired
	LoanDao dao1;
	int id=0;
	int userid=0;
	@RequestMapping(value="/NewLoan",  method=RequestMethod.GET)
	public String showForm(Model m){
		m.addAttribute("loanstatus",new LoanStatus());
		return "NewLoan";
	}
	@RequestMapping(value="/saveLoanStatus", method=RequestMethod.POST)
	public String save(@ModelAttribute("loanstatus")LoanStatus loanstatus){
		dao2.newLoan(loanstatus);
		return "redirect:/ViewLoanStatus";
	}
	@RequestMapping("/ViewLoanStatus")
	public String viewloans(Model m){
		List<LoanStatus> loanlist= dao2.getAllLoans();
		m.addAttribute("list",loanlist);
		return "UserViewLoanStatus";
	}
	@RequestMapping("/getLoansByUserId")
	public String getloansbyuserid(Model m){
		List<LoanStatus> loanlist= dao2.getLoansByUserId(userid);
		m.addAttribute("list",loanlist);
		return "UserViewLoanStatus";
	}
	
	@RequestMapping("/managerViewLoanStatus")
	public String viewallloans(Model m){
		List<LoanStatus> loanlist= dao2.getAllLoans();
		m.addAttribute("list",loanlist);
		return "ViewLoanStatus";
	}
	@RequestMapping(value="/editLoanStatus/{loanid}")
	public String editLoan(@PathVariable int loanid, Model m){
		LoanStatus loan=dao2.getLoanByLoanId(loanid);
		id=loan.getLoan_id();
		m.addAttribute("list",loan);
		return "RejectLoan";
	}
	@RequestMapping(value="/AcceptLoan/{loanid}")
	public String acceptLoan(@PathVariable int loanid, Model m){
		LoanStatus loan=dao2.getLoanByLoanId(loanid);
		loan.setStatus("Accepted");
		id=loan.getLoan_id();
		m.addAttribute("list",loan);
		dao2.updateLoanStatus(loan);
		dao1.newLoan(loan);
		return "redirect:/managerViewLoanStatus";
	}
	@RequestMapping(value="/editLoanStatusUpdate",method=RequestMethod.POST)
	public String editLoanUpdate(@ModelAttribute("loan") LoanStatus loan){
		loan.setLoan_id(id);
		loan.setStatus("Rejected");
		dao2.updateLoanStatus(loan);
		return "redirect:/managerViewLoanStatus";
	}
	@RequestMapping(value="/deleteloan/{loanid}")
	public String deleteLoan(@PathVariable int loanid){
		dao2.deleteLoan(loanid);
		return "redirect:/ViewLoanStatus";
	}
}
