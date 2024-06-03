package website_weather.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import website_weather.Models.weather_weathers;

public class Convert_into_object implements IConvert_into_object {

	IExtract_Data extract_data = new Extract_Data();

	@Override
	public weather_weathers Filter_value_converted_to_object(String value) throws IOException {
		
		return extract_data.Read_Data(value);

	}

	@Override
	public  List<weather_weathers> Filterlist_value_converted_to_object(List<String> value) throws IOException {
		List<weather_weathers> weather_list = new ArrayList<>();
		for (String val : value) {
			weather_list.add(extract_data.Read_Data(val));
        }
		
		return weather_list ;

	}
}
