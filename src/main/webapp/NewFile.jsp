<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/NewFile.css" />
<link rel="stylesheet" href="css/styles.css" />
<link rel="stylesheet" href="css/bootstrap-weather.min.css" />
<link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" />
<script
	src="
https://cdn.jsdelivr.net/npm/chart.js@4.4.2/dist/chart.umd.min.js
"></script>
</head>
<body>
	<!-- Weather -->
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
					style="font-size: smaller;">
						${weather.getLocation().getName()}
						${weather.getLocation().getCountry()} </span>
					${weather.getCurrent().getTemp_c()}<small>°C</small>
				</a>

				<!-- Thanh tìm kiếm -->

			</div>
		</nav>
	</header>
	<div class="container mt-5">
		<div class="d-flex flex-row justify-content-center align-items-center">
			<div class="weather__card">
				<div
					class="d-flex flex-row justify-content-center align-items-center">
					<div class="p-3">
						<h2>${weather.getCurrent().getTemp_c()}&deg;</h2>
					</div>
					<div class="p-3">
						<img src="img/svg/${time_W.getWeatherImage()}">
					</div>
					<div class="p-3">
						<h6 class="mb-3">${time_W.getDay_name()}
							${time_W.getDay_time()}</h6>
						<h3 class="mb-3">${weather.getLocation().getName()}</h3>
						<span class="weather__description">${weather.getCurrent().getCondition().getText()}</span>
					</div>
				</div>
				<div
					class="weather__status d-flex flex-row justify-content-center align-items-center mt-3">
					<div class="p-4 d-flex justify-content-center align-items-center">
						<img src="img/svg/wi-humidity.svg"> <span>${weather.getCurrent().getHumidity()}%</span>
					</div>
					<div class="p-4 d-flex justify-content-center align-items-center">
						<img src="img/svg/wi-cloudy.svg"> <span>${weather.getCurrent().getCloud()}%</span>
					</div>
					<div class="p-4 d-flex justify-content-center align-items-center">
						<img src="img/svg/wi-windy.svg"> <span>${weather.getCurrent().getWind_kph() }
							km/h</span>
					</div>
					<div class="p-4 d-flex justify-content-center align-items-center">
						<img src="img/svg/wi-rain.svg"> <span>${weather.getCurrent().getPrecip_mm()}
							mm</span>
					</div>
					<div class="p-4 d-flex justify-content-center align-items-center">
						<img src="img/svg/uv.svg"> <span>${weather.getCurrent().getUv()}
							nm</span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Weather Forecast -->
	<div
		class="weather__forecast d-flex flex-row justify-content-center align-items-center mt-3">
		<div id="weatherContainer"
			class="d-flex flex-row justify-content-center align-items-center"></div>
	</div>

	<script src="js/load_time_weather.js"></script>
	<!-- Weather -->
	<div class="container mt-5">
		<h5 class="chart-title text-center">Temperature and Humidity
			Chart</h5>
		<div class="d-flex flex-row justify-content-center align-items-center">
			<div class="weather__card">
				<canvas id="temperatureChart"></canvas>
			</div>
		</div>
	</div>
	<script src="js/heat_chart.js" defer></script>
	<!-- Weather Forecast -->
	<div
		class="weather__forecast d-flex flex-row justify-content-center align-items-center mt-3">
		<div
			class="p-4 d-flex flex-column justify-content-center align-items-center">
			<span>Pm2.5</span> <img src="img/svg/air-pollution.png"> <span>${weather.getCurrent().getAir_quality().getPm2_5()}
				µg/m3</span>
		</div>

		<div
			class="p-4 d-flex flex-column justify-content-center align-items-center">
			<span>Pm10</span> <img src="img/svg/air-pollutionpm10.png"> <span>${weather.getCurrent().getAir_quality().getPm10()}
				µg/m3</span>
		</div>

		<div
			class="p-4 d-flex flex-column justify-content-center align-items-center">
			<span>O3</span> <img src="img/svg/ozone.png"> <span>${weather.getCurrent().getAir_quality().getO3()}
				µg/m3</span>
		</div>

		<div
			class="p-4 d-flex flex-column justify-content-center align-items-center">
			<span>NO2</span> <img src="img/svg/fume.png"> <span>${weather.getCurrent().getAir_quality().getNo2()}
				µg/m3</span>
		</div>

		<div
			class="p-4 d-flex flex-column justify-content-center align-items-center">
			<span>SO2</span> <img src="img/svg/station.png"> <span>${weather.getCurrent().getAir_quality().getSo2()}
				µg/m3</span>
		</div>

		<div
			class="p-4 d-flex flex-column justify-content-center align-items-center">
			<span>CO</span> <img src="img/svg/co.png"> <span>${weather.getCurrent().getAir_quality().getCo()}
				µg/m3</span>
		</div>

	</div>

	<div class="container mt-5">
		<div class="d-flex flex-row justify-content-center align-items-center">

			<div class="weather__card">
				<h3 style="text-align: center; margin-bottom: 30px;">Average
					Temperature</h3>
				<h4 id="temperature" style="text-align: center;"></h4>
			</div>

		</div>
	</div>
	<script src="js/Average_temperature.js" defer></script>
	<h2></h2>

</body>
</html>