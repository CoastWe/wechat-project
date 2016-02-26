package com.weibin.wechat.entity.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 图文封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Article {
	// 图文消息名称
	@XmlElement(name="Title")
	@XmlCDATA
	private String title;
	// 图文消息描述
	@XmlElement(name="Description")
	@XmlCDATA
	private String description;
	// 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
	@XmlElement(name="PicUrl")
	@XmlCDATA
	private String picurl;
	// 点击图文消息跳转链接
	@XmlElement(name="Url")
	@XmlCDATA
	private String url;
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
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
