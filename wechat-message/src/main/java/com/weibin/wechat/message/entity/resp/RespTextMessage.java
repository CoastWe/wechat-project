package com.weibin.wechat.message.entity.resp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.weibin.wechat.message.entity.BaseMessage;

/**
 * 微信文本回复消息封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="xml")
public class RespTextMessage extends BaseMessage {
	// 回复的消息内容
	@XmlElement(name="Content")
	@XmlCDATA
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
		
}
