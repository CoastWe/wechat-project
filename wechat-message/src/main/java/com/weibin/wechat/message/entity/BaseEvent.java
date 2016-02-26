package com.weibin.wechat.message.entity;

import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 事件基类
 * @author chenweibin
 * @date 2015-8-6
 */
public class BaseEvent extends BaseMessage{
	// 事件类型
	@XmlElement(name="Event")
	@XmlCDATA
	private String event;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}


}
