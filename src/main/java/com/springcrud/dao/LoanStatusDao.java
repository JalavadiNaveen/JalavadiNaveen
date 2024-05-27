package com.springcrud.dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springcrud.beans.Loan;
import com.springcrud.beans.LoanStatus;

public class LoanStatusDao {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	public int newLoan(LoanStatus loan){
		String sql="insert into loan(amount, date_time, duration, user_id, status,reason) values(?,?,?,?,?,?)";
		java.sql.Date sdob=new java.sql.Date(System.currentTimeMillis ()); 
		return template.update(sql,loan.getAmount(),sdob,loan.getDuration(),loan.getUser_id(),"Pending","Not Chcecked");
	}

	public List<LoanStatus> getAllLoans(){
		String sql="select * from loan";
		List<LoanStatus> loanlist=template.query(sql,new LoanStatusMapper());
		return loanlist;
	}
	public List<LoanStatus> getLoansByUserId(int userid){
		String sql="Select * from loan where user_id=?";
		List<LoanStatus> loan=template.query(sql,new LoanStatusMapper(),userid);
		return loan;
	}
	public LoanStatus getLoanByLoanId(int loan_id){
		String sql="Select * from loan where loan_id=?";
		LoanStatus loan=template.queryForObject(sql,new Object[]{loan_id},new LoanStatusMapper());
		return loan;
	}
	public int updateLoanStatus(LoanStatus loan){
		String sql="update loan set reason=?,status=? where loan_id=?";
		int ans=template.update(sql,loan.getReason(),loan.getStatus(),loan.getLoan_id());
		return ans;
	}
	public int deleteLoan(int loan_id)
	{
		String sql="delete from loan where loan_id=?";
		return template.update(sql,loan_id);
	}
	

}
