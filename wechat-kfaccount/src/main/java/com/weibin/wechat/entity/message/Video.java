package com.weibin.wechat.entity.message;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 视频消息封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="Video")
public class Video {
	// 媒体文件id
	@JsonProperty("media_id")
	private String mediaId;
	//视频消息的标题 

	private String title;
	//视频消息的描述

	private String description;
	@JsonProperty("thumb_media_id")
	private String thumbMediaId;

	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
	

}
