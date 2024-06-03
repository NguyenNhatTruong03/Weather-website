package website_weather.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;

import mapreduce.running;
import website_weather.Models.Time_Weather;
import website_weather.Models.weather_weathers;
import website_weather.Services.Convert_into_object;
import website_weather.Services.Extract_Data;
import website_weather.Services.IConvert_into_object;
import website_weather.Services.IExtract_Data;
import website_weather.Services.ILoad_Data;
import website_weather.Services.ITime_conversion;
import website_weather.Services.ITransformation_Data;

import website_weather.Services.Load_Data;
import website_weather.Services.Time_conversion;
import website_weather.Services.Transformation_Data;

@WebServlet(urlPatterns = { "/WeatherServlet", "/filter", "/Mapreduce" })
public class WeatherServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ITransformation_Data trans_data = new Transformation_Data();
	ILoad_Data load_data = new Load_Data();
	IExtract_Data extra_data = new Extract_Data();
	IConvert_into_object conv = new Convert_into_object();
	ITime_conversion time_con = new Time_conversion();
	weather_weathers weather = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI().toString();
		if (url.contains("WeatherServlet")) {
			weather = viewdata(request, response);

		} else if (url.contains("filter")) {
			String finsh_time = weather.getCurrent().getLast_update();
			String start_time = finsh_time.substring(0, 10) + " 00:00";
			System.out.println("finsh_tiem: " + finsh_time);
			System.out.println("start_tiem: " + start_time);
			List<String> valus = extra_data.filterlist_Data(weather.getLocation().getName(), start_time, finsh_time);
			List<weather_weathers> list_weather = conv.Filterlist_value_converted_to_object(valus);

			System.out.println("2 - :" + list_weather);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(list_weather);
			response.setContentType("application/json");

			response.getWriter().write(json);
		} else if (url.contains("Mapreduce")) {
			String data = null;
			try {
				data = averaged(request, response, weather);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ObjectMapper objectMapper = new ObjectMapper();
			String jsons = objectMapper.writeValueAsString(data);
			response.setContentType("application/json");

			response.getWriter().write(jsons);

			System.out.println(data);
		}
	}

	public weather_weathers viewdata(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String city = request.getParameter("city");
		if (city == null || city.isEmpty()) {
			city = "Ho%Chi%Minh";
		}
		String encodedCity = URLEncoder.encode(city, "UTF-8");

		try {
			weather_weathers weather = trans_data.json_to_object(encodedCity);
			System.out.println(weather);
			load_data.load(weather);

			Time_Weather time_W = time_con.conversions(weather.getLocation().getLocaltime(),
					weather.getCurrent().getCondition().getText());

			request.setAttribute("weather", weather);
			request.setAttribute("time_W", time_W);

			RequestDispatcher rd = request.getRequestDispatcher("/NewFile.jsp");
			rd.forward(request, response);

			return weather;

		} catch (Exception e) {
			out.println("Error: " + e.getMessage());
			return null;
		}
	}

	public String averaged(HttpServletRequest request, HttpServletResponse response, weather_weathers weather)
			throws Exception {
		// Path directory =
		// Paths.get("E:\\csdl_nc_cuoiky\\demo001\\output\\output_temp_c");
		ServletContext context = getServletContext();

		// Lấy đường dẫn thư mục thực thi của ứng dụng web
		String appPath = context.getRealPath("/");

		// In ra đường dẫn thư mục thực thi
		System.out.println("Đường dẫn thư mục thực thi: " + appPath);

		Path directory = Paths.get(appPath + "\\output_mapreduce\\output_temp_c");
		boolean directoryExists = Files.exists(directory) && Files.isDirectory(directory);
		if (directoryExists) {
			try {
				Files.walk(directory).sorted(java.util.Comparator.reverseOrder()).map(Path::toFile)
						.forEach(File::delete);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		running.mapreduce(weather.getLocation().getName(), appPath);

		File file = new File(appPath + "\\output_mapreduce\\output_temp_c\\part-r-00000");

		String data = null;

		// Mở file để đọc dữ liệu
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("\t");
				if (parts.length >= 2) {
					data = parts[1];
					System.out.println(data);
				} else {
					System.out.println("Dữ liệu không hợp lệ.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
