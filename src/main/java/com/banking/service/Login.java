package com.banking.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.banking.dao.UserDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO dao;

	public Login() {
		super();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();


		if (dao.authenticate(uname, pass)) {

			session.setAttribute("username", uname);
			session.setAttribute("role", dao.getRole(uname));
			response.sendRedirect("views/dashboard.jsp");
		} else {
			session.setAttribute("status", false);
			response.sendRedirect("views/login.jsp");
		}
	}

	@Override
	public void init() throws ServletException {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.banking.JdbcConfig.class);
		dao = context.getBean("userDao", UserDAO.class);
		super.init();
	}
}
