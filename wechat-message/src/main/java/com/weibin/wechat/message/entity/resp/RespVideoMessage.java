package com.weibin.wechat.message.entity.resp;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.weibin.wechat.message.entity.BaseMessage;

/**
 * 微信视频回复消息封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="xml")
public class RespVideoMessage extends BaseMessage {
	// 视频
	@XmlElement(name="Video")
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
		
}
