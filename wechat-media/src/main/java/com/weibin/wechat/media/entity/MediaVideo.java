package com.weibin.wechat.media.entity;
/**
 *  
 * @author weibin
 * @date 2016年2月25日
 */
public class MediaVideo {
	private String title;
	private String introduction;
	private String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public MediaVideo(String title, String introduction) {
		super();
		this.title = title;
		this.introduction = introduction;
	}
	public MediaVideo() {
		// TODO Auto-generated constructor stub
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
