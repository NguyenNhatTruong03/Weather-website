package website_weather.Models;

import java.io.Serializable;

public class weather_weathers implements Serializable{

	private static final long serialVersionUID = 5095959649979314072L;
	private weather_location location;
	private weather_current current;
	
	public weather_location getLocation() {
		return location;
	}
	public void setLocation(weather_location location) {
		this.location = location;
	}
	public weather_current getCurrent() {
		return current;
	}
	public void setCurrent(weather_current current) {
		this.current = current;
	}
	@Override
	public String toString() {
		return "weather_weathers [location=" + location + ", current=" + current + "]";
	}
	
}
