package com.weibin.wechat.message.entity.resp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 视频消息封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="Video")
public class Video {
	// 媒体文件id
	@XmlElement(name="MediaId")
	@XmlCDATA
	private String mediaId;
	//视频消息的标题 
	@XmlElement(name="Title")
	@XmlCDATA
	private String title;
	//视频消息的描述
	@XmlElement(name="Description")
	@XmlCDATA
	private String description;

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
	
	

}
