var xhr = new XMLHttpRequest();
xhr.open("GET", "filter", true);
xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		var weatherList = JSON.parse(xhr.responseText);
		//var size_list = weatherList.length;

		var weatherContainer = document.getElementById("weatherContainer");

		// Xóa nội dung cũ của weatherContainer
		weatherContainer.innerHTML = "";

		// Giới hạn số lượng phần tử hiển thị
		//var limit = listSize > 8 ? 8 : listSize; // Số lượng tùy biến, ví dụ 5 hoặc bất kỳ số lượng nào bạn muốn

		// Lặp qua danh sách thời tiết và tạo các phần tử div
		console.log(weatherList);
		var length = weatherList.length;
		console.log("do dai = " + length);
		var length_min;
		var length_max;
		if(length >8){
			length_min = length - 8;
		}
		else{
			length_min = 0;
		}
		if(length ===1){
			length_max = length+1;
		}
		else{
			length_max = length;
		}
		for (var i = length_min ; i < length_max; i++) {
			var weatherItem = weatherList[i];
			console.log('chao');
			console.log(i);
			//console.log(weatherItem.location.localtime);

			var weatherDiv = document.createElement("div");
			weatherDiv.className = "p-4 d-flex flex-column justify-content-center align-items-center";

			var daySpan = document.createElement("span");
			var datetime = weatherItem.location.localtime;
			var time = datetime.split(" ")[1]; // Tách thành mảng và lấy phần tử thứ 2
			daySpan.textContent = time;

			var iconImg = document.createElement("img");
			var icon = weatherItem.current.condition.text;
			var weatherImageMap = {};
			weatherImageMap["Clear"] = "wi-day-sunny.svg";
			weatherImageMap["Sunny"] = "wi-day-sunny.svg";
			weatherImageMap["Partly sunny"] = "wi-day-sunny.svg";
			weatherImageMap["Mostly sunny"] = "wi-day-sunny.svg";
			weatherImageMap["Scattered thunderstorms"] = "wi-day-sleet-storm.svg";
			weatherImageMap["Showers"] = "wi-storm-showers";
			weatherImageMap["Scattered showers"] = "wi-showers.svg";
			weatherImageMap["Rain and snow"] = "wi-day-rain.svg";
			weatherImageMap["Overcast"] = "wi-day-rain.svg";
			weatherImageMap["Light snow"] = "wi-day-rain.svg";
			weatherImageMap["Freezing drizzle"] = "wi-day-sleet-storm.svg";
			weatherImageMap["Chance of rain"] = "wi-day-rain.svg";
			weatherImageMap["Partly cloudy"] = "wi-day-cloudy.svg";
			weatherImageMap["Mostly cloudy"] = "wi-day-cloudy.svg";
			weatherImageMap["Chance of storm"] = "wi-day-sleet-storm.svg";
			weatherImageMap["Rain"] = "wi-day-rain.svg";
			weatherImageMap["Chance of snow"] = "wi-day-cloudy.svg";
			weatherImageMap["Cloudy"] = "wi-cloudy.svg";
			weatherImageMap["Mist"] = "wi-day-sleet-storm.svg";
			weatherImageMap["Storm"] = "wi-day-sleet-storm.svg";
			weatherImageMap["Thunderstorm"] = "wi-day-sleet-storm.svg";
			weatherImageMap["Chance of TStorm"] = "wi-day-sleet-storm.svg";
			weatherImageMap["Sleet"] = "wi-day-sleet-storm.svg";
			weatherImageMap["Snow"] = "wi-day-snow.svg";
			weatherImageMap["Icy"] = "wi-day-snow.svg";
			weatherImageMap["Dust"] = "wi-day-snow.svg";
			weatherImageMap["Fog"] = "wi-day-fog.svg";
			weatherImageMap["Smoke"] = "wi-day-snow.svg";
			weatherImageMap["Haze"] = "wi-day-fog.svg";
			weatherImageMap["Flurries"] = "wi-day-snow.svg";
			weatherImageMap["Light rain"] = "wi-day-rain.svg";
			weatherImageMap["Snow Showers"] = "wi-day-snow.svg";
			weatherImageMap["Hail"] = "wi-day-rain.svg";

			icon = weatherImageMap[icon];
			icon = "img/svg/" + icon;

			iconImg.src = icon;

			var temperatureSpan = document.createElement("span");
			var temperature = weatherItem.current.temp_c + " C";
			temperatureSpan.innerHTML = temperature;

			weatherDiv.appendChild(daySpan);
			weatherDiv.appendChild(iconImg);
			weatherDiv.appendChild(temperatureSpan);

			weatherContainer.appendChild(weatherDiv);
		}
	}
};
xhr.send();