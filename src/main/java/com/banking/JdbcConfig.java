package com.banking;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.banking.dao.AccountDAO;
import com.banking.dao.UserDAO;

@Configuration
@ComponentScan(basePackages = {"com.banking.dao"})
public class JdbcConfig {
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/onlinebanking");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean(name = {"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	@Bean(name = {"userDao"})
	public UserDAO getUserDao() {
		UserDAO userDao = new UserDAO();
		userDao.setJdbcTemplate(getTemplate());
		return userDao;
	}
	@Bean(name = {"accountDao"})
	public AccountDAO getAccountDao() {
		AccountDAO accountDao = new AccountDAO();
		accountDao.setJdbcTemplate(getTemplate());
		return accountDao;
	}

}