<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ page import="com.google.gson.JsonObject"%>
<%@ page import="com.google.gson.JsonArray"%>
<%@ page import="com.google.gson.JsonElement"%>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Website Weather nhom 7</title>
<!-- MDB icon -->
<link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" />
<!-- MDB -->
<link rel="stylesheet" href="css/bootstrap-weather.min.css" />
<link rel="stylesheet" href="css/styles.css" />
</head>

<body>
	<!-- Start your project here-->
	<header class="bg-dark">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container">
				<!-- Logo -->
				<a class="navbar-brand" href="#"> <strong><img
						src="img/logo.png" alt="Logo" width="100" height="50">AccuWeather</strong>

				</a>
				<form action="WeatherServlet" class="col-lg-4 d-flex" method="GET">
					<input class="form-control me-2" name="city" type="text"
						placeholder="Search a city" spellcheck="false">
					<button class="btn btn-outline-success" type="submit">
						<i class="fas fa-search"></i>
					</button>
				</form>
				<!-- Nội dung từ Servlet -->
				<a class="navbar-brand" href="#" id="place"> <span
					style="font-size: smaller;"> ${city} <%=request.getAttribute("country")%>
				</span> ,<%=request.getAttribute("tempC")%><small>°C</small>
				</a>

				<!-- Thanh tìm kiếm -->

			</div>
		</nav>
	</header>

	<section class="vh-100" style="background-color: #cdc4f9;">

		<div class="container py-5 h-100">

			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-12 col-xl-10">

					<div class="card shadow-0 border border-dark border-5 text-dark"
						style="border-radius: 10px;">
						<div class="card-body p-4">

							<div class="row text-center">
								<div
									class="col-md-9 text-center border-end border-5 border-dark py-4"
									style="margin-top: -1.5rem; margin-bottom: -1.5rem;">
									<div class="d-flex justify-content-around mt-3">
										<!--<h1 class="large">${city}</h1>  -->
										<h1 class="small larger-text">${city}</h1>
										
										<h1 class="small" style="font-size: smaller;">${localtime}</h1>
									</div>
									<div
										class="d-flex justify-content-around align-items-center py-5 my-4">
										<p class="fw-bold mb-0" style="font-size: 7rem;">${tempC}°C</p>
										<div class="text-start">
											<h1>
												<strong>${dayName}</strong>
											</h1>
											<h2 class="small mb-0">${currentWeatherText}</h2>
										</div>
									</div>
									<div
										class="d-flex justify-content-around align-items-center mb-3">
										<div class="flex-column">
											<i class="fas fa-minus"></i>
										</div>
										<div>
											<h1 style="font-size: smaller;">Humidity</h1>
											<h2>
												<strong style="font-size: smaller;">${humidity}%</strong>
											</h2>
										</div>
										<div>
											<h1 style="font-size: smaller;">Wind Speed</h1>
											<h2>
												<strong style="font-size: smaller;">${windKph}km/h</strong>
											</h2>
										</div>
										<div class="flex-column">
											<i class="fas fa-minus"></i>
										</div>
									</div>
								</div>


								<div class="col-md-3 mx-auto"
									style="height: 500px; overflow-y: auto;">
									<h1>Temperate in day</h1>

								</div>

							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!-- End your project here-->

	<!-- MDB -->
	<script type="text/javascript" src="js/mdb.min.js"></script>
	<!-- Custom scripts -->
	<script type="text/javascript"></script>
</body>


</html>