package com.banking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.banking.bean.UserBean;

public class UserRowMapper implements RowMapper<UserBean>{

	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean user = new UserBean();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setMobile(rs.getString("mobile"));
		user.setAadhar(rs.getString("aadhar"));
		user.setAddress(rs.getString("address"));
		user.setPin(rs.getString("pin"));
		user.setState(rs.getString("state"));
		user.setRole(rs.getString("role"));
		return user;
	}

}