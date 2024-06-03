package website_weather.Models;

import java.io.Serializable;

public class Time_Weather implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8429658250657254581L;
	private String day_name;
	private String day_time;
	private String weatherImage;
	public String getDay_name() {
		return day_name;
	}
	public void setDay_name(String day_name) {
		this.day_name = day_name;
	}
	public String getDay_time() {
		return day_time;
	}
	public void setDay_time(String day_time) {
		this.day_time = day_time;
	}
	public String getWeatherImage() {
		return weatherImage;
	}
	public void setWeatherImage(String weatherImage) {
		this.weatherImage = weatherImage;
	}
	
}
	
