package com.weibin.wechat.message.entity.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.weibin.wechat.message.entity.BaseMessage;
@XmlRootElement(name="xml")
public class ReqTextMessage extends ReqBaseMessage {
	// 消息内容
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
