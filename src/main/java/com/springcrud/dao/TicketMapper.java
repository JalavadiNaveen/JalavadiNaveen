package com.springcrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springcrud.beans.Ticket;
public class TicketMapper implements RowMapper<Ticket> {

	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ticket ticket=new Ticket();
		ticket.setTicket_id(rs.getInt("ticket_id"));
		ticket.setDate_time(rs.getDate("date_time"));
		ticket.setQuery(rs.getString("query"));
		ticket.setStatus(rs.getString("status"));
		ticket.setUser_id(rs.getInt("user_id"));
		return ticket;
	}

}
