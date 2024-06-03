package website_weather.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.hbase.thirdparty.com.google.gson.Gson;

import website_weather.Models.weather_air_quality;
import website_weather.Models.weather_condition;
import website_weather.Models.weather_current;
import website_weather.Models.weather_location;
import website_weather.Models.weather_weathers;

public class Transformation_Data implements ITransformation_Data {
	@Override
	public weather_weathers json_to_object(String loaction) {
		try {
			// Tạo URL của API
			/*
			 * String apiUrl = "http://api.weatherapi.com/v1/current.json?" +
			 * "key=19f458c69f9f4a87ae1191400240305&q=Ha_Noi&aqi=yes";
			 */
			String apiUrls = "http://api.weatherapi.com/v1/current.json?" + "key=19f458c69f9f4a87ae1191400240305&q=";
			apiUrls = apiUrls + loaction + "&aqi=yes";
			URL url = new URL(apiUrls);

			// Kết nối đến API
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// Đọc dữ liệu từ API
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			// chuyển đổi json sang object
			String temp = response.toString();
			Gson gson = new Gson();

			weather_weathers weather = gson.fromJson(temp, weather_weathers.class);

			reader.close();

			System.out.println(weather.getCurrent().getAir_quality());
			// Đóng kết nối
			connection.disconnect();

			return weather;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public weather_weathers map_to_object(Map<String, String> map_weather) {

		weather_weathers weather = new weather_weathers();
		weather_location location = new weather_location();
		weather_current current = new weather_current();
		weather_air_quality air_quality = new weather_air_quality();
		weather_condition condition = new weather_condition();

		for (Map.Entry<String, String> entry : map_weather.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();

			switch (key) {
			case "name":
				location.setName(value);
				;
				break;
			case "region":
				location.setRegion(value);
				break;
			case "country":
				location.setCountry(value);
				break;
			case "lat":
				location.setLat(Float.parseFloat(value));
				;
				break;
			case "lon":
				location.setLon(Float.parseFloat(value));
				break;
			case "tz_id":
				location.setTz_id(value);
				break;
			case "localtime_epoch":
				location.setLocaltime_epoch(value);
				break;
			case "localtime":
				location.setLocaltime(value);
				break;

			case "text":
				condition.setText(value);
				break;
			case "icon":
				condition.setText(value);
				break;
			case "code":
				condition.setCode(value);
				break;

			case "co":
				air_quality.setCo(Float.parseFloat(value));
				break;
			case "no2":
				air_quality.setNo2(Float.parseFloat(value));
				break;
			case "o3":
				air_quality.setO3(Float.parseFloat(value));
				break;
			case "so2":
				air_quality.setSo2(Float.parseFloat(value));
				break;
			case "pm2_5":
				air_quality.setPm2_5(Float.parseFloat(value));
				break;
			case "pm10":
				air_quality.setPm10(Float.parseFloat(value));
				break;
			case "us_epa_index":
				air_quality.setUs_epa_index(Float.parseFloat(value));
				break;
			case "gb_defra_index":
				air_quality.setGb_defra_index(Float.parseFloat(value));
				break;

			case "wind_mph":
				current.setWind_mph(Float.parseFloat(value));
				break;
			case "wind_kph":
				current.setWind_kph(Float.parseFloat(value));
				break;
			case "wind_degree":
				current.setWind_degree(Float.parseFloat(value));
				break;
			case "wind_dir":
				current.setWind_dir(value);
				break;
			case "pressure_mb":
				current.setPressure_mb(Float.parseFloat(value));
				break;
			case "pressure_in":
				current.setPressure_in(Float.parseFloat(value));
				break;
			case "precip_mm":
				current.setPrecip_mm(Float.parseFloat(value));
				break;
			case "precip_in":
				current.setPrecip_in(Float.parseFloat(value));
				break;
			case "humidity":
				current.setHumidity(Float.parseFloat(value));
				break;
			case "cloud":
				current.setCloud(Float.parseFloat(value));
				break;
			case "feelslike_c":
				current.setFeelslike_c(Float.parseFloat(value));
				break;
			case "feelslike_f":
				current.setFeelslike_f(Float.parseFloat(value));
				break;
			case "vis_km":
				current.setVis_km(Float.parseFloat(value));
				break;
			case "vis_miles":
				current.setVis_miles(Float.parseFloat(value));
				break;
			case "uv":
				current.setUv(Float.parseFloat(value));
				break;
			case "gust_mph":
				current.setGust_mph(Float.parseFloat(value));
				break;
			case "gust_kph":
				current.setGust_kph(Float.parseFloat(value));
				break;
			case "temp_c":
				current.setTemp_c(Float.parseFloat(value));
				break;
			case "temp_f":
				current.setTemp_f(Float.parseFloat(value));
				break;

			}
		}
		current.setCondition(condition);
		current.setAir_quality(air_quality);
		weather.setLocation(location);
		weather.setCurrent(current);

		return weather;

	}

}
