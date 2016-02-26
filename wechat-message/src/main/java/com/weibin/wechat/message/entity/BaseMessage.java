package com.weibin.wechat.message.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
public class BaseMessage {
	// 开发者微信号
	@JsonProperty("touser")
	@XmlElement(name="ToUserName")
	@XmlCDATA
	private String toUserName;
	// 发送方帐号（一个OpenID）
	@XmlElement(name="FromUserName")
	@XmlCDATA
	private String fromUserName;
	// 消息创建时间 （整型）
	@XmlElement(name="CreateTime")
	private long createTime;
	// 消息类型
	@JsonProperty("msgtype")
	@XmlElement(name="MsgType")
	@XmlCDATA
	private String msgType;
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
}
