package com.weibin.wechat.kf.entity.message;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信声音封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="Voice")
public class Voice {
	// 媒体文件id
	@JsonProperty("media_id")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}


}
