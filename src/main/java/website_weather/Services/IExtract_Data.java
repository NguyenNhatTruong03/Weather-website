package website_weather.Services;

import java.io.IOException;
import java.util.List;

import website_weather.Models.weather_weathers;

public interface IExtract_Data {

	weather_weathers Read_Data(String temp) throws IOException;

	List<String> filterlist_Data(String value1, String value2, String value3) throws IOException;

	List<String> filter_Data(String location) throws IOException;

}
