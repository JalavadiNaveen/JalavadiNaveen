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

import com.banking.bean.UserBean;
import com.banking.dao.UserDAO;

@WebServlet("/GetAdmin")
public class GetAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	
	@Override
	public void init() throws ServletException{
		ApplicationContext context = new AnnotationConfigApplicationContext(com.banking.JdbcConfig.class);
		dao = context.getBean("userDao", UserDAO.class);
	}

    public GetAdmin() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserBean> user3=dao.getAdmin();
		request.setAttribute("user", user3);
		request.getRequestDispatcher("views/manage_users.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
