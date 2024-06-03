package website_weather.Models;

import java.io.Serializable;

public class weather_location implements Serializable{
	
	private static final long serialVersionUID = -4774355936355961820L;
	
	private String name;
	private String region;
	private String country;
	private float lat;
	private float lon;
	private String tz_id;
	private String localtime_epoch;
	private String localtime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	public String getTz_id() {
		return tz_id;
	}
	public void setTz_id(String tz_id) {
		this.tz_id = tz_id;
	}
	public String getLocaltime_epoch() {
		return localtime_epoch;
	}
	public void setLocaltime_epoch(String localtime_epoch) {
		this.localtime_epoch = localtime_epoch;
	}
	public String getLocaltime() {
		return localtime;
	}
	public void setLocaltime(String localtime) {
		this.localtime = localtime;
	}
	@Override
	public String toString() {
		return "weather_location [name=" + name + ", region=" + region + ", country=" + country + ", lat=" + lat
				+ ", lon=" + lon + ", tz_id=" + tz_id + ", localtime_epoch=" + localtime_epoch + ", localtime="
				+ localtime + "]";
	}
	
}
