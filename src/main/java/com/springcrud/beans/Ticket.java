package com.springcrud.beans;

import java.util.Date;

public class Ticket {
	
	public Ticket() {
	}
	private int ticket_id;
	private Date date_time;
	private String query;
	private String status;
	private int user_id;
	
	public Ticket(int ticket_id,Date date_time, String query, String status, int user_id) {
		this.ticket_id = ticket_id;
		this.date_time=date_time;
		this.query = query;
		this.status = status;
		this.user_id = user_id;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id =Integer.parseInt(ticket_id);
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
