package com.banking.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.banking.bean.UserBean;
import com.banking.dao.UserDAO;

@WebServlet("/EditUsers")
public class EditUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao;
	
	@Override
	public void init() throws ServletException {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.banking.JdbcConfig.class);
		dao = context.getBean("userDao", UserDAO.class);
	}
       
    public EditUsers() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt((String)request.getParameter("id"));
		String role=(String)request.getParameter("role");
		String username=(String)request.getParameter("username");
		if(role==null) {
			role=dao.getRole(username);
		}
		UserBean user=new UserBean();
		user.setId(id);
		user.setName((String) request.getParameter("name"));
		user.setEmail((String) request.getParameter("email"));
		user.setUsername((String) request.getParameter("username"));
		user.setPassword((String) request.getParameter("password"));
		user.setMobile((String) request.getParameter("mobile"));
		user.setAadhar((String) request.getParameter("aadhar"));
		user.setAddress((String) request.getParameter("address"));
		user.setPin((String) request.getParameter("pin"));
		user.setState((String) request.getParameter("state"));
		user.setRole(role);
		String result=dao.updateUser(user,id);
		request.getSession().setAttribute("message", result);
		response.sendRedirect("views/dashboard.jsp");
	}

}
