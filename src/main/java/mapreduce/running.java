package mapreduce;

import java.io.Serializable;
import java.util.List;
import website_weather.Models.weather_weathers;
import website_weather.Services.Convert_into_object;
import website_weather.Services.Extract_Data;
import website_weather.Services.IConvert_into_object;
import website_weather.Services.IExtract_Data;
import website_weather.Services.ILoad_Data;
import website_weather.Services.ITransformation_Data;

import website_weather.Services.Transformation_Data;

public class running implements Serializable {

	private static final long serialVersionUID = -6357088958905512660L;

	ITransformation_Data data_trans = new Transformation_Data();
	ILoad_Data loaD = new website_weather.Services.Load_Data();

	static IExtract_Data extract_data = new Extract_Data();
	static IConvert_into_object convert = new Convert_into_object();

	public static void load_Input_andRun_MapReduce(String City, String address) throws Exception {
		List<String> values = extract_data.filter_Data(City);
		List<weather_weathers> weather_list = convert.Filterlist_value_converted_to_object(values);
		String address_input = write_input_data.write_data(weather_list, address);
		average_temperature.runTemperatureAverage(address_input, address + "\\output_mapreduce\\output_temp_c");
	}

	public static void mapreduce(String location, String address) throws Exception { // Call_API();
		load_Input_andRun_MapReduce(location, address);
	}

}
