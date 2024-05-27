<%@page import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.banking.bean.AccountBean"%>
<%@page import="com.banking.dao.AccountDAO"%>
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
		AccountDAO dao = context.getBean("accountDao", AccountDAO.class);
		AccountBean account=dao.getAccountByAccno(Integer.parseInt((String)request.getParameter("accno")));
	%>
	<%@include file="navbar.jsp"%>
	<div class="d-flex justify-content-center container">
		<div class="card bg-light border-primary shadow rounded" id="itemForm"
			style="width: 25rem;">
			<h3 class="card-header text-primary"
				style="text-align: center; font-weight: bold;">Edit Account Details</h3>
			<div class="card-body">
				<form
					action="<%=request.getContextPath()%>/EditAccount?accno=<%=account.getAccno() %>"
					method="POST">
					<div class="form-floating">
											<input type="number" class="form-control" name="accno"
												placeholder="Account Number" required> <label for="accno">Account Number</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="text" class="form-control" name="ifsc"
												placeholder="IFSC" required> <label for="ifsc">IFSC</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="number" class="form-control" name="amount"
												placeholder="Amount" required>
											<label for="amount">Amount</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="text" class="form-control" name="accname"
												placeholder="Account Name" required> <label
												for="accname">Account Name</label>
										</div>
										<p>
										<div class="form-floating">
											<input type="text" class="form-control" name="mode"
												placeholder="Mode" required> <label for="mode">Mode</label>
										</div>
										<p>
					
					<div class="m-3 text-center">
						<button type="submit" style="width: 10rem;"
							class="btn btn-outline-success">Update Account Details</button>
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