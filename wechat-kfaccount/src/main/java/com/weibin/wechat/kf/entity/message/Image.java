package com.weibin.wechat.kf.entity.message;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Image {
	@JsonProperty("media_id")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}	
}
