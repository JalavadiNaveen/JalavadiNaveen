package com.banking.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.banking.dao.AccountDAO;


@WebServlet("/FundTransfer")
public class FundTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AccountDAO dao;
       
    public FundTransfer() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	ApplicationContext context = new AnnotationConfigApplicationContext(com.banking.JdbcConfig.class);
		dao = context.getBean("accountDao", AccountDAO.class);
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getParameter("accno");
		request.getParameter("ifsc");
		request.getParameter("amount");
		request.getParameter("accname");
		request.getParameter("mode");
		request.getSession();
		
		
	}

}
