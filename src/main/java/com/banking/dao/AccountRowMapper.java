package com.banking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.banking.bean.AccountBean;

public class AccountRowMapper implements RowMapper<AccountBean>{

	public AccountBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccountBean account = new AccountBean();
		account.setAccno(rs.getInt(1));
		account.setIfsc(rs.getString(2));
		account.setAmount(rs.getInt(3));
		account.setAccname(rs.getString(4));
		account.setMode(rs.getString(5));
		return account;
	}

}