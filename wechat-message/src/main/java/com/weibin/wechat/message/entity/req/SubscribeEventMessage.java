package com.weibin.wechat.message.entity.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.weibin.wechat.message.entity.BaseEvent;
@XmlRootElement(name="xml")
public class SubscribeEventMessage extends BaseEvent {
	// 事件KEY值
	@XmlElement(name="EventKey")
	@XmlCDATA
	private String eventKey;
	// 用于换取二维码图片
	@XmlElement(name="Ticket")
	@XmlCDATA
	private String ticket;
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
