package mapreduce;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import website_weather.Models.weather_weathers;


public class write_input_data {
	public static String write_data(List<weather_weathers> weather_list, String address_input) throws IOException {

		// Đường dẫn đến file
		File file = new File(address_input+"\\input_mapreduce\\file.txt");

		// Kiểm tra xem file đã tồn tại chưa, nếu không thì tạo mới
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(""); // Ghi một chuỗi rỗng để xóa nội dung của file
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Mở file để ghi dữ liệu
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			for (weather_weathers weather : weather_list) {
				String name = weather.getLocation().getName();
				String temp_c = String.valueOf(weather.getCurrent().getTemp_c());
				//String precip_mm = String.valueOf(weather.getCurrent().getPrecip_mm());

				String data_temp_c = name + ", " + temp_c + "\n";
				// String data_precip_mm = name + ", " + precip_mm + "\n";

				// Ghi dữ liệu vào file
				writer.write(data_temp_c);
				// writer.write(data_precip_mm);
			}
			System.out.println("Dữ liệu đã được ghi vào file thành công.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file.toString();
	}

}
