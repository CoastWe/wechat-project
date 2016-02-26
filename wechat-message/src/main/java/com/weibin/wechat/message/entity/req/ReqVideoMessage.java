package com.weibin.wechat.message.entity.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.weibin.wechat.message.entity.BaseMessage;

/**
 * 微信视频消息封装基类
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="xml")
public class ReqVideoMessage extends ReqBaseMessage {
	// 视频消息媒体id
	@XmlElement(name="MediaId")
	@XmlCDATA
	private String mediaid;
	// 视频消息缩略图的媒体id
	@XmlElement(name="ThumbMediaId")
	@XmlCDATA
	private String thumbmediaid;
	public String getMediaid() {
		return mediaid;
	}
	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}
	public String getThumbmediaid() {
		return thumbmediaid;
	}
	public void setThumbmediaid(String thumbmediaid) {
		this.thumbmediaid = thumbmediaid;
	}
	
}
