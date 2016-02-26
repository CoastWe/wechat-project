package com.weibin.wechat.entity.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.weibin.wechat.message.entity.BaseMessage;

public class ReqBaseMessage extends BaseMessage {
	// 消息id，64位整型
	@XmlElement(name="MsgId")
	private long msgid;

	public long getMsgid() {
		return msgid;
	}

	public void setMsgid(long msgid) {
		this.msgid = msgid;
	}	
		
}
