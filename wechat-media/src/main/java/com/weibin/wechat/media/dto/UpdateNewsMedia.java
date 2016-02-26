package com.weibin.wechat.media.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 * @author weibin
 * @date 2016年2月25日
 */
public class UpdateNewsMedia {
	@JsonProperty("media_id")
	private String mediaId;
	private String index;
	@JsonProperty("articles")
	private Article article;
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}
