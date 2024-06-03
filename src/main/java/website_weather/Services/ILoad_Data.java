package website_weather.Services;

import java.io.IOException;

import website_weather.Models.weather_weathers;

public interface ILoad_Data {

	void load(weather_weathers weather) throws IOException;

}
