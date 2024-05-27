package com.springcrud.beans;

import java.util.Date;

public class Loan {

	private long loan_id;
	private long amount;
	private Date date;
	private int user_id;
	
	public long getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(long loan_id) {
		this.loan_id = loan_id;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Loan(long loan_id, long amount, Date date, int user_id) {
		super();
		this.loan_id = loan_id;
		this.amount = amount;
		this.date = date;
		this.user_id = user_id;
	}
	
	public Loan() {
		// TODO Auto-generated constructor stub
	}
	
}
