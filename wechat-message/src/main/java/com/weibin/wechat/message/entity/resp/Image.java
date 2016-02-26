package com.weibin.wechat.message.entity.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 微信图像封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="Image")
@XmlAccessorType(XmlAccessType.FIELD)
public class Image {
	@XmlElement(name="MediaId")
	@XmlCDATA
	private String mediaid;

	public String getMediaid() {
		return mediaid;
	}

	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}
	
}
