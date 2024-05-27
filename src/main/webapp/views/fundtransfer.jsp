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
	<%@include file="navbar.jsp"%>
	<div class="container">
	<style>
.background-radial-gradient {
	background-color: hsl(218, 41%, 15%);
	background-image: radial-gradient(650px circle at 0% 0%, hsl(218, 41%, 35%)
		15%, hsl(218, 41%, 30%) 35%, hsl(218, 41%, 20%) 75%,
		hsl(218, 41%, 19%) 80%, transparent 100%),
		radial-gradient(1250px circle at 100% 100%, hsl(218, 41%, 45%) 15%,
		hsl(218, 41%, 30%) 35%, hsl(218, 41%, 20%) 75%, hsl(218, 41%, 19%) 80%,
		transparent 100%);
}

#radius-shape-1 {
	height: 220px;
	width: 220px;
	top: -60px;
	left: -130px;
	background: radial-gradient(#44006b, #ad1fff);
	overflow: hidden;
}

#radius-shape-2 {
	border-radius: 38% 62% 63% 37%/70% 33% 67% 30%;
	bottom: -60px;
	right: -110px;
	width: 300px;
	height: 300px;
	background: radial-gradient(#44006b, #ad1fff);
	overflow: hidden;
}

.bg-glass {
	background-color: hsla(0, 0%, 100%, 0.9) !important;
	backdrop-filter: saturate(200%) blur(25px);
}

body{
	background-image: url("https://www.nbc.ca/content/dam/fragment/images/ten-reasons-internet-banking-opt.jpg");
	
}

</style>
<section class="background-radial-gradient overflow-hidden">
<div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
					<div class="row gx-lg-5 align-items-center mb-5">
						<div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
							<h1 class="my-5 display-5 fw-bold ls-tight"
								style="color: hsl(218, 81%, 95%)">
								Welcome to Onilne Banking Service <br/> <br> <span
									style="color: hsl(218, 81%, 75%)">Transfer Funds</span>
							</h1>
							</div>
							<div class="col-lg-6 mb-5 mb-lg-0 position-relative">
							<div id="radius-shape-1"
								class="position-absolute rounded-circle shadow-5-strong"></div>
							<div id="radius-shape-2"
								class="position-absolute shadow-5-strong"></div>
							<div class="card bg-glass">
								<div class="card-body px-4 py-5 px-md-5">
									<form action="<%=request.getContextPath()%>/FundTransfer" method="POST">
									<div class="row">
											<div class="col-md-6 mb-4">
												<div class="form-floating">
													<input type="number" class="form-control" name="accno"
														placeholder="*****" required>
													<label for="accno">Account Number</label>
												</div>
											</div>
											<div class="col-md-6 mb-4">
												<div class="form-floating">
													<input type="text" class="form-control" name="ifsc"
														placeholder="SBIN******" required> <label
														for="ifsc">IFSC Code</label>
												</div>
											</div>
											<div class="col-md-6 mb-4">
												<div class="form-floating">
													<input type="number" class="form-control" name="amount"
														placeholder="RS./-" required> <label
														for="amount">Amount To Be Transfered </label>
												</div>
											</div>
											<div class="col-md-6 mb-4">
												<div class="form-floating">
													<input type="text" class="form-control" name="accname"
														placeholder="Eg: Sharukh Khan" required> <label
														for="accname">Beneficiary Name </label>
												</div>
											</div>
												<div class="form-check form-check-inline ms-3">
												<input class="form-check-input" type="radio" name="mode"
													id="rtgs" value="rtgs" checked> <label
													class="form-check-label" for="rtgs"> RTGS </label>									
													
												<div class="form-check form-check-inline ms-3">
													<input class="form-check-input" type="radio"
														name="mode" value="neft" id="neft"> <label
														class="form-check-label" for="neft"> NEFT </label>
														
												<div class="form-check form-check-inline ms-3">
													<input class="form-check-input" type="radio" name="mode"
													id="imps" value="imps" checked> <label
													class="form-check-label" for="imps"> IMPS </label>
												</div>
											</div>
											</div>
											
											<div class="form-group">
												<button type="submit" class="btn btn-primary col-11 ms-3">
													<b>TRANSFER NOW</b>
												</button>
											</div>
										</form>
										</div>

								</div>
							</div>
						</div>
					</div>

				</div>	
		</section>
	</div>
</body>
</html>							