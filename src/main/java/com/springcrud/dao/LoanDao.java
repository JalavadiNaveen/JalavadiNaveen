package com.springcrud.dao;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springcrud.beans.Loan;
import com.springcrud.beans.LoanStatus;
public class LoanDao {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	public int newLoan(LoanStatus loan){
		String sql="insert into loan_query(loan_id, amount, date, user_id) values(?,?,?,?)";
		int amount=(int) ((loan.getAmount()/100)*loan.getDuration());
		amount=(int) (amount+loan.getAmount());
		return template.update(sql,loan.getLoan_id(),amount,(Date)loan.getDate(),loan.getUser_id());
	}

	public List<Loan> getLoanDetails(){
		String sql="select * from Loan_query";
		List<Loan> ticketList=template.query(sql,new LoanMapper());
		return ticketList;
	}
	public Loan getLoanById(long loan_id){
		String sql="Select * from loan_query where loan_id=?";
		Loan loan=template.queryForObject(sql,new Object[]{loan_id},new LoanMapper());
		return loan;
	}
	public int update(Loan loan){
		String sql="update loan_query set amount=?, date=?, user_id=? where loan_id=?";
		java.sql.Date sdob=new java.sql.Date(loan.getDate().getTime());
		int ans=template.update(sql,loan.getAmount(),sdob,loan.getUser_id(),loan.getLoan_id());
		return ans;
	}
	public int delete(long loan_id)
	{
		String sql="delete from loan_query where loan_id=?";
		return template.update(sql,loan_id);
	}
	

}
