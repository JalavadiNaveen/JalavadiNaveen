package com.banking.service;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/GetAllAccount")
public class GetAllAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AccountDAO dao;

    public GetAllAccount() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	ApplicationContext context = new AnnotationConfigApplicationContext(com.banking.JdbcConfig.class);
		dao = context.getBean("accountDao", AccountDAO.class);
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AccountBean> acc =dao.getAllAccount();
		request.setAttribute("account", acc);
		request.getRequestDispatcher("views/manage_account.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
