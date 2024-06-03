package website_weather.Models;

import java.io.Serializable;

public class weather_condition implements Serializable{

	private static final long serialVersionUID = -589485120225772683L;
	
	private String text;
	private String icon;
	private String code;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "weather_condition [text=" + text + ", icon=" + icon + ", code=" + code + "]";
	}
	
}
