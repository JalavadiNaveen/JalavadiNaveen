<%@page import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.banking.bean.UserBean"%>
<%@page import="com.banking.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Online Banking</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Tangerine">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js" integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/" crossorigin="anonymous"></script>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	String role = (String) session.getAttribute("role");
	if (session.getAttribute("username") == null || session.getAttribute("role") == null) {
		response.sendRedirect("login.jsp");
	} else {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.banking.JdbcConfig.class);
		UserDAO dao = context.getBean("userDao", UserDAO.class);
		/* out.println("getParam:"+request.getParameter("username")); */
		UserBean user=dao.getUserByUsername((String)request.getParameter("username"));
	%>
	<%@include file="navbar.jsp"%>
	<div class="d-flex justify-content-center container">
		<div class="card bg-light border-primary shadow rounded" id="itemForm"
			style="width: 25rem;">
			<h3 class="card-header text-primary"
				style="text-align: center; font-weight: bold;">Update Details</h3>
			<div class="card-body">
				<form
					action="<%=request.getContextPath()%>/EditUsers?id=<%=user.getId() %>"
					method="POST">
					<div class="form-floating">
											<input type="text" class="form-control" name="name"
												placeholder="Name" required> <label for="name">Name</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="email" class="form-control" name="email"
												placeholder="Email" required> <label for="email">Email
												address</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="text" class="form-control" name="username"
												placeholder="Username" minlength=5 maxlength=20 required>
											<label for="username">Username</label>
										</div>

										<p class="text-danger ms-3" id="error"></p>
										<div class="form-floating">
											<input type="password" class="form-control" name="password"
												placeholder="Password" minlength=8 required> <label
												for="password">Password</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="text" class="form-control" name="mobile"
												placeholder="Mobile number" minlength=10 maxlength=10
												required> <label for="mobile">Mobile Number</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="number" class="form-control" name="aadhar"
												placeholder="Aadhar ID (12 digits)" required> <label
												for="aadhar">Aadhar Number</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="text" class="form-control" name="address"
												placeholder="Address" required> <label for="address">Address</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="number" class="form-control" name="pin"
												placeholder="Create a 4 digit PIN" required> <label
												for="pin">Enter 4 digit PIN</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="text" class="form-control" name="state"
												placeholder="State" required> <label for="state">State</label>
										</div>
										<p>
					<%if(!role.equals("USER") && !role.equals("ADMIN")){ %>
					<div class="form-floating">
						<input type="text" class="form-control" name="role"
							placeholder="Role" value="<%=user.getRole() %>" required>
						<label for="role">Role</label>
					</div>
					<%} %>
					<div class="m-3 text-center">
						<button type="submit" style="width: 10rem;"
							class="btn btn-outline-success">Update</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>