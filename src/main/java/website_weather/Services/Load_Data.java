package website_weather.Services;


import java.io.IOException;

import website_weather.DAO.Client_API;
import website_weather.DAO.IClient_API;
import website_weather.Models.weather_weathers;

public class Load_Data implements ILoad_Data{

	IClient_API client_API = new Client_API();

	
	public void load(weather_weathers weather) throws IOException {

		String table_name = "Weather";

		String rowkey = weather.getLocation().getName()+ " " + weather.getLocation().getCountry()+ " "
				+ weather.getLocation().getLocaltime();
		String region = "Asia";

		client_API.Put_Data(table_name, rowkey, "Location", "name", weather.getLocation().getName());
		client_API.Put_Data(table_name, rowkey, "Location", "region", region);
		client_API.Put_Data(table_name, rowkey, "Location", "country", weather.getLocation().getCountry());
		String lat = String.valueOf(weather.getLocation().getLat());
		client_API.Put_Data(table_name, rowkey, "Location", "lat", lat);
		String lon = String.valueOf(weather.getLocation().getLon());
		client_API.Put_Data(table_name, rowkey, "Location", "lon", lon);
		client_API.Put_Data(table_name, rowkey, "Location", "tz_id", weather.getLocation().getTz_id());
		client_API.Put_Data(table_name, rowkey, "Location", "localtime_epoch",
				weather.getLocation().getLocaltime_epoch());
		client_API.Put_Data(table_name, rowkey, "Location", "localtime", weather.getLocation().getLocaltime());
//-----------------------------------------------------------------------------//
		client_API.Put_Data(table_name, rowkey, "Current", "last_updated_epoch",weather.getCurrent().getLast_updated_epoch());
		client_API.Put_Data(table_name, rowkey, "Current", "last_updated", weather.getCurrent().getLast_update());
		client_API.Put_Data(table_name, rowkey, "Current", "temp_c", String.valueOf(weather.getCurrent().getTemp_c()));
		client_API.Put_Data(table_name, rowkey, "Current", "temp_f", String.valueOf(weather.getCurrent().getTemp_f()));
		client_API.Put_Data(table_name, rowkey, "Current", "is_day", String.valueOf(weather.getCurrent().isIs_day()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "wind_mph", 
				String.valueOf(weather.getCurrent().getWind_mph()));
		client_API.Put_Data(table_name, rowkey, "Current", "wind_kph", 
				String.valueOf(weather.getCurrent().getWind_kph()));
		client_API.Put_Data(table_name, rowkey, "Current", "wind_degree", 
				String.valueOf(weather.getCurrent().getWind_degree()));
		client_API.Put_Data(table_name, rowkey, "Current", "wind_dir", weather.getCurrent().getWind_dir());
		
		client_API.Put_Data(table_name, rowkey, "Current", "pressure_mb", 
				String.valueOf(weather.getCurrent().getPressure_mb()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "pressure_in", 
				String.valueOf(weather.getCurrent().getPrecip_in()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "precip_mm", 
				String.valueOf(weather.getCurrent().getPrecip_mm()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "precip_in", 
				String.valueOf(weather.getCurrent().getPrecip_in()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "humidity", 
				String.valueOf(weather.getCurrent().getHumidity()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "cloud", 
				String.valueOf(weather.getCurrent().getCloud()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "feelslike_c", 
				String.valueOf(weather.getCurrent().getFeelslike_c()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "feelslike_f", 
				String.valueOf(weather.getCurrent().getFeelslike_f()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "vis_km", 
				String.valueOf(weather.getCurrent().getVis_km()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "vis_miles", 
				String.valueOf(weather.getCurrent().getVis_miles()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "uv", 
				String.valueOf(weather.getCurrent().getUv()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "gust_mph", 
				String.valueOf(weather.getCurrent().getGust_mph()));
		
		client_API.Put_Data(table_name, rowkey, "Current", "gust_kph", 
				String.valueOf(weather.getCurrent().getGust_kph()));
		
//----------------------------------------------------------------------//
		client_API.Put_Data(table_name, rowkey, "curr_Condition", "text",
				weather.getCurrent().getCondition().getText());
		client_API.Put_Data(table_name, rowkey, "curr_Condition", "icon",
				weather.getCurrent().getCondition().getIcon());
		client_API.Put_Data(table_name, rowkey, "curr_Condition", "code",
				weather.getCurrent().getCondition().getCode());
//---------------------------------------------------------------------//
		client_API.Put_Data(table_name, rowkey, "curr_air_quality", "co",
				String.valueOf(weather.getCurrent().getAir_quality().getCo()));
		
		client_API.Put_Data(table_name, rowkey, "curr_air_quality", "no2",
				String.valueOf(weather.getCurrent().getAir_quality().getNo2()));
		
		client_API.Put_Data(table_name, rowkey, "curr_air_quality", "o3",
				String.valueOf(weather.getCurrent().getAir_quality().getO3()));
		
		client_API.Put_Data(table_name, rowkey, "curr_air_quality", "so2",
				String.valueOf(weather.getCurrent().getAir_quality().getSo2()));
		
		client_API.Put_Data(table_name, rowkey, "curr_air_quality", "pm2_5",
				String.valueOf(weather.getCurrent().getAir_quality().getPm2_5()));
		
		client_API.Put_Data(table_name, rowkey, "curr_air_quality", "pm10",
				String.valueOf(weather.getCurrent().getAir_quality().getPm10()));
		
		client_API.Put_Data(table_name, rowkey, "curr_air_quality", "us_epa_index",
				String.valueOf(weather.getCurrent().getAir_quality().getUs_epa_index()));
		
		client_API.Put_Data(table_name, rowkey, "curr_air_quality", "gb_defra_index",
				String.valueOf(weather.getCurrent().getAir_quality().getGb_defra_index()));
	}
}
