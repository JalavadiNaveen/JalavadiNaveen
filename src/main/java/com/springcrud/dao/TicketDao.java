package com.springcrud.dao;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springcrud.beans.Ticket;
public class TicketDao {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	public int newticket(Ticket ticket){
		java.sql.Date currentdate=new java.sql.Date(System.currentTimeMillis ());
		String sql="insert into ticket(date_time,query,status,user_id) values(?,?,?,?)";
		return template.update(sql,currentdate,ticket.getQuery(),ticket.getStatus(),ticket.getUser_id());
	}
	public List<Ticket> getTicketDetails(){
		String sql="select * from Ticket";
		List<Ticket> ticketList=template.query(sql,new TicketMapper());
		return ticketList;
	}
	public List<Ticket> getTicketsByUserId(int userid){
		String sql="select * from ticket where user_id=?";
		List<Ticket> ticketList=template.query(sql,new TicketMapper(),userid);
		return ticketList;
	}
	
	public Ticket getTicketById(int ticketid){
		String sql="select * from ticket where ticket_id=?";
		Ticket ticket=template.queryForObject(sql,new Object[]{ticketid},new TicketMapper());
		return ticket;
	}
	public int update(Ticket ticket){
		String sql="update ticket set  status=? where ticket_id=?";
		int ans=template.update(sql,ticket.getStatus(),ticket.getTicket_id());
		return ans;
	}
	public int delete(int id){
		String sql="delete from ticket where ticket_id=?";
		return template.update(sql,id);
	}
	
	
}