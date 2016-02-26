package com.weibin.wechat.message.entity.resp;

import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 微信音乐封装
 * @author chenweibin
 * @date 2015-8-6
 */
public class Music {
	// 音乐标题
	@XmlElement(name="Title")
	@XmlCDATA
	private String title;
	// 音乐描述
	@XmlElement(name="Description")
	@XmlCDATA
	private String description;
	// 音乐链接
	@XmlElement(name="MusicUrl")
	@XmlCDATA
	private String musicurl;
	// 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	@XmlElement(name="HQMusicUrl")
	@XmlCDATA
	private String hqmusicurl;
	// 缩略图的媒体id，通过上传多媒体文件得到的id
	@XmlElement(name="ThumbMediaId")
	@XmlCDATA
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
