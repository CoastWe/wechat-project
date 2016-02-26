package com.weibin.wechat.message.entity.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.weibin.wechat.message.entity.BaseEvent;

/**
 * 自定义菜单事件
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="xml")
public class MenuEventMessage extends BaseEvent {
	// 事件KEY值，与自定义菜单接口中KEY值对应
	@XmlElement(name="EventKey")
	@XmlCDATA
	private String eventKey;

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
	
}
