package website_weather.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.util.Bytes;

import website_weather.DAO.Client_API;
import website_weather.DAO.IClient_API;
import website_weather.Models.weather_weathers;

public class Extract_Data implements IExtract_Data {

	IClient_API client_API = new Client_API();
	ITransformation_Data trans_data = new Transformation_Data();

	@Override
	public weather_weathers Read_Data(String temp) throws IOException {
		Cell[] cells = client_API.Read_Data("Weather", temp);
		Map<String, String> map_weather = new HashMap<String, String>();
		for (Cell cell : cells) {
			byte[] c = CellUtil.cloneQualifier(cell);
			byte[] value_c = CellUtil.cloneValue(cell);
			String value_co = Bytes.toString(c);
			String value_cc = Bytes.toString(value_c);
			map_weather.put(value_co, value_cc);
		}
		weather_weathers weather = trans_data.map_to_object(map_weather);
		// System.out.println(weather);
		return weather;
	}

	@Override
	public List<String> filter_Data(String location) throws IOException {
		ResultScanner scanner = client_API.Scan_Table_SingleColumnValueFilter("Weather", "Location", "name",
				location);
		List<String> values = new ArrayList<>();
		for (Result result = scanner.next(); result != null; result = scanner.next()) {
			// System.out.println("Found row : " + result);
			String temp = result.toString();
			int startIndex = temp.indexOf("{") + 1;
			int endIndex = temp.indexOf("/");

			String value = temp.substring(startIndex, endIndex);
			values.add(value);
		}
		scanner.close();
		return values;
	}

	@Override
	public List<String> filterlist_Data(
			String value1, String value2,String value3) throws IOException {
		ResultScanner scanner = client_API.Scan_Table_ColumnValueFilterList("Weather", "Location", "name",
				value1, "Current", "last_updated", value2, value3);

		List<String> values = new ArrayList<>();
		for (Result result = scanner.next(); result != null; result = scanner.next()) {
			// System.out.println("Found row : " + result);
			String temp = result.toString();
			int startIndex = temp.indexOf("{") + 1;
			int endIndex = temp.indexOf("/");

			String value = temp.substring(startIndex, endIndex);
			values.add(value);
		}
		scanner.close();
		return values;
	}
}
