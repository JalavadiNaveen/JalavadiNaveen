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
import com.banking.dao.UserDAO;

@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AccountDAO dao;

    public DeleteAccount() {
        super();
    }
    
    @Override
	public void init() throws ServletException {
    	ApplicationContext context = new AnnotationConfigApplicationContext(com.banking.JdbcConfig.class);
		dao = context.getBean("accountDao", AccountDAO.class);
	}
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accno=Integer.parseInt(request.getParameter("accno"));
		String result="";
		if(dao.deleteAccountByAccno(accno)!=null) {
			result="SUCCESS";
		}
		else {
			result="FAILED";
		}
		HttpSession session=request.getSession();
		session.setAttribute("message", result);
		response.sendRedirect("views/dashboard.jsp"); 
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
