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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	UserDAO dao;
	@Override
	public void init() throws ServletException {
		super.init();
		ApplicationContext context = new AnnotationConfigApplicationContext(com.banking.JdbcConfig.class);
		dao= context.getBean("userDao", UserDAO.class);
	}

	private static final long serialVersionUID = 1L;
       public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String name=request.getParameter("name");
				String email=request.getParameter("email");
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				String mobile=request.getParameter("mobile");
				String aadhar=request.getParameter("aadhar");
				String address=request.getParameter("address");
				String pin=request.getParameter("pin");
				String state=request.getParameter("state");
				String role=request.getParameter("usertype").toUpperCase();
				
				UserBean user=new UserBean(name,email,username,password,mobile,aadhar,address,pin,state,role);
				String result=dao.addUser(user);
				if(result.equals("SUCCESS")) {
					request.getSession().setAttribute("msg", "Registered Successfully");
					response.sendRedirect("views/login.jsp");
				}
				else {
					request.getSession().setAttribute("msg", "Registration Failed");
					response.sendRedirect("views/signup.jsp");
				}
				
				
	}

}
