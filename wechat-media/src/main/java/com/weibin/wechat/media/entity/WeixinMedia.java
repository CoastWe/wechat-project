package com.weibin.wechat.media.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 媒体文件信息
 * @author weibin
 *
 */
public class WeixinMedia {
	// 媒体文件类型
	private String type;
	// 媒体文件标识或缩略图的媒体文件标识
	@JsonProperty("media_id")
	private String mediaId;
	// 媒体文件上传的时间
	@JsonProperty("created_at")
	private int createdAt;
	
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "WeixinMedia [type=" + type + ", mediaId=" + mediaId
				+ ", createdAt=" + createdAt + ", url=" + url + "]";
	}

	
	
}
