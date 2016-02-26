package com.weibin.wechat.message.entity.resp;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.weibin.wechat.message.entity.BaseMessage;

/**
 * 微信图文回复消息封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="xml")
public class RespNewsMessage extends BaseMessage {
	// 图文消息个数，限制为10条以内
	@XmlElement(name="ArticleCount")
	private int articlecount;
//	// 多条图文消息信息，默认第一个item为大图
//	@XmlElement(name="item")
//	private List<Article> articles;
	@XmlElement(name="Articles")
	private News news;
	public int getArticlecount() {
		return articlecount;
	}
	public void setArticlecount(int articlecount) {
		this.articlecount = articlecount;
	}
//	public List<Article> getArticles() {
//		return articles;
//	}
//	public void setArticles(List<Article> articles) {
//		this.articles = articles;
//	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
}
