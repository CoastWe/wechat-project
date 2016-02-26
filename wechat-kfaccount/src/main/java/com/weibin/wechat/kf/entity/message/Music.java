package com.weibin.wechat.kf.entity.message;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 微信音乐封装
 * @author chenweibin
 * @date 2015-8-6
 */
public class Music {
	// 音乐标题

	private String title;
	// 音乐描述

	private String description;
	// 音乐链接

	private String musicurl;
	// 高质量音乐链接，WIFI环境优先使用该链接播放音乐

	private String hqmusicurl;
	// 缩略图的媒体id，通过上传多媒体文件得到的id
	@JsonProperty("thumb_media_id")
	private String thumbmediaid;
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
	public String getMusicurl() {
		return musicurl;
	}
	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}
	public String getHqmusicurl() {
		return hqmusicurl;
	}
	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
	}
	public String getThumbmediaid() {
		return thumbmediaid;
	}
	public void setThumbmediaid(String thumbmediaid) {
		this.thumbmediaid = thumbmediaid;
	}
	
	

}
