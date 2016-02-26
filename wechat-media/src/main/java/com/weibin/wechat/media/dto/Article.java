package com.weibin.wechat.media.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *  
 * @author weibin
 * @date 2016年2月25日
 */
public class Article {
	private String title;
	@JsonProperty("thumb_media_id")
	private String thumbMediaId;
	private String author;
	private String digest;
	@JsonProperty("show_cover_pic ")
	private String showCoverPic;
	private String content;
	@JsonProperty("content_source_url")
	private String contentSourceUrl;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getShowCoverPic() {
		return showCoverPic;
	}
	public void setShowCoverPic(String showCoverPic) {
		this.showCoverPic = showCoverPic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentSourceUrl() {
		return contentSourceUrl;
	}
	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}
	
}
