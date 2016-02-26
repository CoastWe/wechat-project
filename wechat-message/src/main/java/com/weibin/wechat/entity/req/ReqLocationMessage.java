package com.weibin.wechat.entity.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.weibin.wechat.message.entity.BaseMessage;

/**
 * 微信地理消息封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="xml")
public class ReqLocationMessage extends ReqBaseMessage {
	// 地理位置维度
	@XmlElement(name="Location_X")
	private String locationX;
	// 地理位置经度
	@XmlElement(name="Location_Y")
	private String locationY;
	// 地图缩放大小
	@XmlElement(name="Scale")
	private String scale;
	// 地理位置信息
	@XmlElement(name="Label")
	@XmlCDATA
	private String label;
	public String getLocationX() {
		return locationX;
	}
	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}
	public String getLocationY() {
		return locationY;
	}
	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	
}
