package com.springcrud.beans;

import java.util.Date;

public class LoanStatus {
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LoanStatus() {
	}
	public LoanStatus(int loan_id, long amount, Date date, int duration, int user_id,String status,String reason) {
		this.loan_id = loan_id;
		this.amount = amount;
		this.date = date;
		this.duration = duration;
		this.user_id = user_id;
		this.status=status;
		this.reason=reason;
	}
	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	private int loan_id;
	private long amount;
	private Date date;
	private int duration;
	private int user_id;
	private String status;
	private String reason;
}
