package com.springcrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.springcrud.beans.LoanStatus;

public class LoanStatusMapper implements RowMapper<LoanStatus> {

	public LoanStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoanStatus loan=new LoanStatus();
		loan.setLoan_id(rs.getInt("loan_id"));
		loan.setAmount(rs.getLong("amount"));
		loan.setDate(rs.getDate("date_time"));
		loan.setUser_id(rs.getInt("user_id"));
		loan.setDuration(rs.getInt("duration"));
		loan.setStatus(rs.getString("status"));
		loan.setReason(rs.getString("reason"));
		return loan;
	}

}