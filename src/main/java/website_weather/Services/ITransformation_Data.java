package website_weather.Services;

import java.util.Map;

import website_weather.Models.weather_weathers;

public interface ITransformation_Data {

	weather_weathers map_to_object(Map<String, String> map_weather);

	weather_weathers json_to_object(String location);

}
