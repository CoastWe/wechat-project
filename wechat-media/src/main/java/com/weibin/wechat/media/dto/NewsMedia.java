package com.weibin.wechat.media.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 * @author weibin
 * @date 2016年2月25日
 */
public class NewsMedia {
	@JsonProperty("articles")
	private List<Article> articles;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
}
