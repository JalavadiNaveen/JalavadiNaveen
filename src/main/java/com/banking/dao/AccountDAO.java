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

import com.banking.bean.AccountBean;
import com.banking.bean.UserBean;
import com.banking.util.DBUtil;

public class AccountDAO {
	
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
	static String LOGIN_SUCCESS = "SUCCESS";
	static String LOGIN_FAILED = "FAILED";

	public String addAccount(AccountBean account) {
		sql = "INSERT INTO account (accno,ifsc,amount,accname,mode) VALUES (?,?,?,?,?)";
		try {
			row = this.jdbcTemplate.update(sql, account.getAccno(), account.getIfsc(), account.getAmount(), account.getAccname(),
					account.getMode());
			result = (row > 0) ? LOGIN_SUCCESS : LOGIN_FAILED;
		} catch (Exception e) {
			result = LOGIN_FAILED;
		}
		return result;
	}

	public String updateAccount(AccountBean account, int accno) {
		sql = "UPDATE account SET ifsc=?,amount=?,accname=?,mode=? WHERE accno=?";
		try {
			row = this.jdbcTemplate.update(sql, account.getIfsc(), account.getAmount(), account.getAccname(),
					account.getMode(), accno);
			result = (row > 0) ? LOGIN_SUCCESS : LOGIN_FAILED;

		} catch (Exception e) {
			e.printStackTrace();
			result = LOGIN_FAILED;
		}
		return result;

	}

	public List<AccountBean> getAllAccount() {
		List<AccountBean> acc = new ArrayList();
		sql = "SELECT * FROM account";
		try {
			acc = this.jdbcTemplate.query(sql, new AccountRowMapper());
			if (acc.isEmpty()) {
				return Collections.emptyList();
			} else {
				return acc;
			}
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	public AccountBean getAccountByAccno(int accno) {
		sql = "SELECT * FROM account WHERE accno=?";
		AccountBean account = new AccountBean();
		try {
			RowMapper<AccountBean> rowMapper = new AccountRowMapper();
			account = this.jdbcTemplate.queryForObject(sql, rowMapper, accno);
			return account;
		} catch (Exception e) {
			return null;
		}
	}

	public String deleteAccountByAccno(int accno) {
		sql = "DELETE FROM account WHERE accno=?";
		try {
			row = this.jdbcTemplate.update(sql, accno);
			result = (row > 0) ? LOGIN_SUCCESS : LOGIN_FAILED;
		} catch (Exception e) {
			result = LOGIN_FAILED;
		}
		return result;
	}
}
