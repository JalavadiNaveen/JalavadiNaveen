<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<div class="container">
		<div class="d-flex justify-content-center">
			<div class="card bg-light border-primary shadow rounded"
				id="itemForm" style="width: 25rem">
				<h3 class="card-header text-primary"
					style="text-align: center; font-weight: bold;">Add</h3>
				<div class="card-body">
					<form action="<%=request.getContextPath()%>/AddUsers"
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
										<div class="form-check form-check-inline ms-3">
											<input class="form-check-input" type="radio" name="usertype"
												id="user" value="user" checked> <label
												class="form-check-label" for="user"> User </label>
										</div>
										<p>
					<button type="submit" class="btn btn-primary col-11 ms-3">Add</button>
					</form>
				</div>
			</div>
			</div>
			</div>
			
	<%
		}
	%>
</body>
</html>