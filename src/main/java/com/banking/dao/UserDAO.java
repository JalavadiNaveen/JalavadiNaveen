package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.banking.bean.UserBean;
import com.banking.util.DBUtil;

@Component("userDao")
public class UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private String sql;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String result;
	private int row;

	public String addUser(UserBean user) {
		sql = "INSERT INTO user (name,email,username,password,mobile,aadhar,address,pin,state,role) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			row = this.jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getUsername(), user.getPassword(),
					user.getMobile(), user.getAadhar(), user.getAddress(), user.getPin(), user.getState(), user.getRole());
			result = (row > 0) ? "SUCCESS" : "FAILED";
		} catch (Exception e) {
			result = "FAILED";
		}
		return result;

	}

	public boolean authenticate(String username, String password) {
		sql = "SELECT * FROM user WHERE username=? AND password=?";
		try {
			RowMapper<UserBean> rowMapper = new UserRowMapper();
			UserBean user = this.jdbcTemplate.queryForObject(sql, rowMapper, username, password);
			if(user == null)
				return false;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getRole(String username) {
		sql = "SELECT * FROM user WHERE username=?";
		String role = "";
		try {
			RowMapper<UserBean> rowMapper = new UserRowMapper();
			UserBean user = this.jdbcTemplate.queryForObject(sql, rowMapper, username);
			
			if(user != null)
				role = user.getRole();
		} catch (Exception e) {
			role = null;
		}
		return role;
	}
	
	public UserBean getUserByUsername(String username) {
		sql = "SELECT * FROM user WHERE username=?";
		UserBean user = new UserBean();
		try {
			RowMapper<UserBean> rowMapper = new UserRowMapper();
			user = this.jdbcTemplate.queryForObject(sql, rowMapper, username);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	

	public String updateUser(UserBean user, int id) {
		sql = "UPDATE user SET name=?,email=?,username=?,password=?,mobile=?,aadhar=?,address=?,pin=?,state=?,role=? WHERE id=?";
		try {
			row = this.jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getUsername(), user.getPassword(),
					user.getMobile(), user.getAadhar(), user.getAddress(), user.getPin(), user.getState(), user.getRole(), id);
			result = (row > 0) ? "SUCCESS" : "FAILED";

		} catch (Exception e) {
			e.printStackTrace();
			result = "FAILED";
		}
		return result;

	}

	public String deleteUserByUsername(int id) {
		sql = "DELETE FROM user WHERE id=?";
		try {
			row = this.jdbcTemplate.update(sql, id);
			result = (row > 0) ? "SUCCESS" : "FAILED";
		} catch (Exception e) {
			result = "FAILED";
		}
		return result;
	}
	
	public List<UserBean> getAdmin() {
		List<UserBean> user3 = new ArrayList();
		sql = "SELECT * FROM user where role = 'ADMIN'";
		try {
				user3 = this.jdbcTemplate.query(sql, new UserRowMapper());
			if (user3.isEmpty()) {
				return null;
			} else {
				return user3;
			}
			
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	
	public List<UserBean> getManager() {
		List<UserBean> user2 = new ArrayList();
		sql = "SELECT * FROM user where role = 'MANAGER'";
		try {
				user2 = this.jdbcTemplate.query(sql, new UserRowMapper());
			if (user2.isEmpty()) {
				return null;
			} else {
				return user2;
			}
			
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	
	public List<UserBean> getAllUsers() {
		List<UserBean> user1 = new ArrayList();
		sql = "SELECT * FROM user where role = 'USER'";
		try {
			user1 = this.jdbcTemplate.query(sql, new UserRowMapper());
			if (user1.isEmpty()) {
				return null;
			} else {
				return user1;
			}
			
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

}
