package com.banking.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.banking.bean.AccountBean;
import com.banking.bean.UserBean;
import com.banking.dao.AccountDAO;
import com.banking.dao.UserDAO;

@WebServlet("/EditAccount")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AccountDAO dao;
	
    public EditAccount() {
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
		int accno=Integer.parseInt((String)request.getParameter("accno"));
		AccountBean account=new AccountBean();
		account.setAccno(accno);
		account.setIfsc((String) request.getParameter("ifsc"));
		account.setAmount(Integer.parseInt((String)request.getParameter("amount")));
		account.setAccname((String) request.getParameter("accname"));
		account.setMode((String) request.getParameter("mode"));
		String result=dao.updateAccount(account,accno);
		request.getSession().setAttribute("message", result);
		response.sendRedirect("views/dashboard.jsp");
	}

}
