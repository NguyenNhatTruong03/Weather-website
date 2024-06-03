package website_weather.Services;

import java.io.IOException;
import java.util.List;

import website_weather.Models.weather_weathers;

public interface IConvert_into_object {

	weather_weathers Filter_value_converted_to_object(String value) throws IOException;

	List<weather_weathers> Filterlist_value_converted_to_object(List<String> value) throws IOException;

}
