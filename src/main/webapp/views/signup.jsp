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

<script>
	function validatePassword() {
		event.preventDefault();
		var pass1 = document.register.password.value
		var pass2 = document.register.password2.value
		if (!(pass1 === pass2)) {
			document.getElementById("error").innerHTML = "Both passwords must match!"
		} else {
			document.register.submit();
		}
	}
</script>
</head>
<body>
<style>
body{
	background-image: url("https://www.nbc.ca/content/dam/fragment/images/ten-reasons-internet-banking-opt.jpg");
	
}
</style>
	<%@include file="navbar.jsp"%>
	<%
		if (request.getSession().getAttribute("msg") != null) {
	%>
	<div
		class="alert alert-success text-center position-relative top-50 start-50 translate-middle mt-5"
		style="width: 32%;" role="alert">Registered Successfully!</div>
	<%
		}
	%>
	
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold">CREATE
										AN ACCOUNT</p>
									<br>
									<form class="mx-1 mx-md-4"
										action="<%=request.getContextPath()%>/RegisterServlet"
										method="POST" name="register" onsubmit="validatePassword()">

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
											<input type="password" class="form-control" name="password2"
												placeholder="Confirm Password" required> <label
												for="password2">Confirm Password</label>
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

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary col-11 ms-3">Register</button>
										</div>

									</form>

									<p class="text-center">
										Already have an account ? ADMIN / MANAGER &nbsp;<a
											href="login.jsp">Click here!</a>
									</p>

								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img src="https://logodix.com/logo/1309829.png"
										class="w-100" alt="Sample image">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>