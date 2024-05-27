<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 	
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
	if (session.getAttribute("username") == null || session.getAttribute("role") == null || role.equals("USER")) {
		response.sendRedirect("login.jsp");
	} else {
	%>
	<%@include file="navbar.jsp"%>
	<div class="d-flex justify-content-center container">
		<div class="card my-5 shadow bg-white rounded donor">
			<h3 class="card-header text-primary fw-bold">Modify User Account<a role="button" href="views/addaccount.jsp"
										class="btn btn-outline-primary btn-lg ms-3 float-end">Add Account Details</a></h3>
			<div class="card-body">
			
				<div class="table-responsive">
					<table class="table table-bordered table-striped">
						<thead class="table-primary">
							<tr>
								<th scope="col">Account Number</th>
								<th scope="col">IFSC</th>
								<th scope="col">Amount</th>
								<th scope="col">Account Name</th>
								<th scope="col">Mode</th>
								<th scope="col">Operation</th>
							</tr>
						</thead>
						<tbody>
						 <c:forEach items="${account}" var="account">
							<tr>
								<td>${account.accno}</td>
								<td>${account.ifsc}</td>
								<td>${account.amount}</td>
								<td>${account.accname}</td>
								<td>${account.mode}</td>
								<td>
								<a role="button" href="views/editaccount.jsp?accno=${account.accno}"
										class="btn btn-outline-primary btn-sm ms-3">Edit</a>
									<a role="button" href="<%=request.getContextPath()%>/DeleteAccount?accno=${account.accno}"
										class="btn btn-outline-danger btn-sm ms-2">Delete</a></td>
							</tr>
						</c:forEach>	
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%} %>
</body>
</html>