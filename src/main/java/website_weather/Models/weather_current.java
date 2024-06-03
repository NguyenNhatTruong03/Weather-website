package website_weather.Models;


import java.io.Serializable;

public class weather_current implements Serializable{
	
	private static final long serialVersionUID = -4774355936355961820L;
	
	private String last_updated_epoch;
	private String last_updated;
	private float temp_c;
	private float temp_f;
	private int is_day;
	private weather_condition condition;
	private float wind_mph;
	private float wind_kph;
	private float wind_degree;
	private String wind_dir;
	private float pressure_mb;
	private float pressure_in;
	private float precip_mm;
	private float precip_in;
	private float humidity;
	private float cloud;
	private float feelslike_c;
	private float feelslike_f;
	private float vis_km;
	private float vis_miles;
	private float uv;
	private float gust_mph;
	private float gust_kph;
	private weather_air_quality air_quality;
	public String getLast_updated_epoch() {
		return last_updated_epoch;
	}
	public void setLast_updated_epoch(String last_updated_epoch) {
		this.last_updated_epoch = last_updated_epoch;
	}
	public String getLast_update() {
		return last_updated;
	}
	public void setLast_update(String last_update) {
		this.last_updated = last_update;
	}
	public float getTemp_c() {
		return temp_c;
	}
	public void setTemp_c(float temp_c) {
		this.temp_c = temp_c;
	}
	public float getTemp_f() {
		return temp_f;
	}
	public void setTemp_f(float temp_f) {
		this.temp_f = temp_f;
	}
	public int isIs_day() {
		return is_day;
	}
	public void setIs_day(int is_day) {
		this.is_day = is_day;
	}
	public weather_condition getCondition() {
		return condition;
	}
	public void setCondition(weather_condition condition) {
		this.condition = condition;
	}
	public float getWind_mph() {
		return wind_mph;
	}
	public void setWind_mph(float wind_mph) {
		this.wind_mph = wind_mph;
	}
	public float getWind_kph() {
		return wind_kph;
	}
	public void setWind_kph(float wind_kph) {
		this.wind_kph = wind_kph;
	}
	public float getWind_degree() {
		return wind_degree;
	}
	public void setWind_degree(float wind_degree) {
		this.wind_degree = wind_degree;
	}
	public String getWind_dir() {
		return wind_dir;
	}
	public void setWind_dir(String wind_dir) {
		this.wind_dir = wind_dir;
	}
	public float getPressure_mb() {
		return pressure_mb;
	}
	public void setPressure_mb(float pressure_mb) {
		this.pressure_mb = pressure_mb;
	}
	public float getPressure_in() {
		return pressure_in;
	}
	public void setPressure_in(float pressure_in) {
		this.pressure_in = pressure_in;
	}
	public float getPrecip_mm() {
		return precip_mm;
	}
	public void setPrecip_mm(float precip_mm) {
		this.precip_mm = precip_mm;
	}
	public float getPrecip_in() {
		return precip_in;
	}
	public void setPrecip_in(float precip_in) {
		this.precip_in = precip_in;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getCloud() {
		return cloud;
	}
	public void setCloud(float cloud) {
		this.cloud = cloud;
	}
	public float getFeelslike_c() {
		return feelslike_c;
	}
	public void setFeelslike_c(float feelslike_c) {
		this.feelslike_c = feelslike_c;
	}
	public float getFeelslike_f() {
		return feelslike_f;
	}
	public void setFeelslike_f(float feelslike_f) {
		this.feelslike_f = feelslike_f;
	}
	public float getVis_km() {
		return vis_km;
	}
	public void setVis_km(float vis_km) {
		this.vis_km = vis_km;
	}
	public float getVis_miles() {
		return vis_miles;
	}
	public void setVis_miles(float vis_miles) {
		this.vis_miles = vis_miles;
	}
	public float getUv() {
		return uv;
	}
	public void setUv(float uv) {
		this.uv = uv;
	}
	public float getGust_mph() {
		return gust_mph;
	}
	public void setGust_mph(float gust_mph) {
		this.gust_mph = gust_mph;
	}
	public float getGust_kph() {
		return gust_kph;
	}
	public void setGust_kph(float gust_kph) {
		this.gust_kph = gust_kph;
	}
	public weather_air_quality getAir_quality() {
		return air_quality;
	}
	public void setAir_quality(weather_air_quality air_quality) {
		this.air_quality = air_quality;
	}
	@Override
	public String toString() {
		return "weather_current [last_updated_epoch=" + last_updated_epoch + ", last_update=" + last_updated
				+ ", temp_c=" + temp_c + ", temp_f=" + temp_f + ", is_day=" + is_day + ", condition=" + condition
				+ ", wind_mph=" + wind_mph + ", wind_kph=" + wind_kph + ", wind_degree=" + wind_degree + ", wind_dir="
				+ wind_dir + ", pressure_mb=" + pressure_mb + ", pressure_in=" + pressure_in + ", precip_mm="
				+ precip_mm + ", precip_in=" + precip_in + ", humidity=" + humidity + ", cloud=" + cloud
				+ ", feelslike_c=" + feelslike_c + ", feelslike_f=" + feelslike_f + ", vis_km=" + vis_km
				+ ", vis_miles=" + vis_miles + ", uv=" + uv + ", gust_mph=" + gust_mph + ", gust_kph=" + gust_kph
				+ ", air_quality=" + air_quality + "]";
	}
	
}
