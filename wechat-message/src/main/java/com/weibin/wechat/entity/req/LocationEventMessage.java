package com.weibin.wechat.entity.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.weibin.wechat.message.entity.BaseEvent;

/**
 * 上报地理位置事件
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="xml")
public class LocationEventMessage extends BaseEvent {
	// 地理位置纬度
	@XmlElement(name="Latitude")
	private String latitude;
	// 地理位置经度
	@XmlElement(name="Longitude")
	private String longitude;
	// 地理位置精度
	@XmlElement(name="Precision")
	private String precision;
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
}
