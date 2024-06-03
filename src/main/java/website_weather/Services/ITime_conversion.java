package website_weather.Services;

import website_weather.Models.Time_Weather;

public interface ITime_conversion {

	Time_Weather conversions(String Localtime, String Text);

}
