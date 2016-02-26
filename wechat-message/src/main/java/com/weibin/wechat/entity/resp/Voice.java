package com.weibin.wechat.entity.resp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 微信声音封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="Voice")
public class Voice {
	// 媒体文件id
	@XmlElement(name="MediaId")
	@XmlCDATA
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}


}
