package website_weather.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import website_weather.Models.Time_Weather;

public class Time_conversion implements ITime_conversion{
	@Override
	public Time_Weather conversions(String Localtime, String Text) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		// Phân tích localtime thành LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.parse(Localtime, formatter);
		String date_time = localDateTime.toString();
		// Lấy ngày từ LocalDateTime
		LocalDate localDate = localDateTime.toLocalDate();

		// In ra thứ trong tuần (sử dụng từ 1 đến 7, 1 đại diện cho thứ hai, 7 đại diện
		// cho chủ nhật)
		int dayOfWeek = localDate.getDayOfWeek().getValue();

		// Chuyển đổi từ dạng số sang dạng chữ
		String dayName = "";
		if (dayOfWeek == 1) {
			dayName = "Monday";
		} else if (dayOfWeek == 2) {
			dayName = "Tuesday";
		} else if (dayOfWeek == 3) {
			dayName = "Wednesday";
		} else if (dayOfWeek == 4) {
			dayName = "Thursday";
		} else if (dayOfWeek == 5) {
			dayName = "Friday";
		} else if (dayOfWeek == 6) {
			dayName = "Saturday";
		} else if (dayOfWeek == 7) {
			dayName = "Sunday";
		} else {
			dayName = "Unknown";
		}

		Map<String, String> weatherImageMap = new HashMap<>();
		weatherImageMap.put("Clear", "wi-day-sunny.svg");
		weatherImageMap.put("Sunny", "wi-day-sunny.svg");
		weatherImageMap.put("Partly sunny", "wi-day-sunny.svg");
		weatherImageMap.put("Mostly sunny", "wi-day-sunny.svg");
		weatherImageMap.put("Scattered thunderstorms", "wi-day-sleet-storm.svg");
		weatherImageMap.put("Showers", "wi-storm-showers");
		weatherImageMap.put("Scattered showers", "wi-showers.svg");
		weatherImageMap.put("Rain and snow", "wi-day-rain.svg");
		weatherImageMap.put("Overcast", "wi-day-rain.svg");
		weatherImageMap.put("Light snow", "wi-day-rain.svg");
		weatherImageMap.put("Freezing drizzle", "wi-day-sleet-storm.svg");
		weatherImageMap.put("Chance of rain", "wi-day-rain.svg");
		weatherImageMap.put("Partly cloudy", "wi-day-cloudy.svg");
		weatherImageMap.put("Mostly cloudy", "wi-day-cloudy.svg");
		weatherImageMap.put("Chance of storm", "wi-day-sleet-storm.svg");
		weatherImageMap.put("Rain", "wi-day-rain.svg");
		weatherImageMap.put("Chance of snow", "wi-day-cloudy.svg");
		weatherImageMap.put("Cloudy", "wi-cloudy.svg");
		weatherImageMap.put("Mist", "wi-day-sleet-storm.svg");
		weatherImageMap.put("Storm", "wi-day-sleet-storm.svg");
		weatherImageMap.put("Thunderstorm", "wi-day-sleet-storm.svg");
		weatherImageMap.put("Chance of TStorm", "wi-day-sleet-storm.svg");
		weatherImageMap.put("Sleet", "wi-day-sleet-storm.svg");
		weatherImageMap.put("Snow", "wi-day-snow.svg");
		weatherImageMap.put("Icy", "wi-day-snow.svg");
		weatherImageMap.put("Dust", "wi-day-snow.svg");
		weatherImageMap.put("Fog", "wi-day-fog.svg");
		weatherImageMap.put("Smoke", "wi-day-snow.svg");
		weatherImageMap.put("Haze", "wi-day-fog.svg");
		weatherImageMap.put("Flurries", "wi-day-snow.svg");
		weatherImageMap.put("Light rain", "wi-day-rain.svg");
		weatherImageMap.put("Snow Showers", "wi-day-snow.svg");
		weatherImageMap.put("Hail", "wi-day-rain.svg");

		String weatherImage = weatherImageMap.get(Text);
		Time_Weather time_W = new Time_Weather();
		time_W.setDay_name(dayName);
		time_W.setDay_time(date_time);
		time_W.setWeatherImage(weatherImage);
		return time_W;
	}
}
