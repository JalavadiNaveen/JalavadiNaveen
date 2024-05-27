package com.springcrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springcrud.beans.Loan;

public class LoanMapper implements RowMapper<Loan> {

	public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
		Loan loan=new Loan();
		loan.setLoan_id(rs.getInt("loan_id"));
		loan.setAmount(rs.getLong("amount"));
		loan.setDate(rs.getDate("date"));
		loan.setUser_id(rs.getInt("user_id"));
		return loan;
	}

}