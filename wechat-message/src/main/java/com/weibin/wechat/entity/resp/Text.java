package com.weibin.wechat.entity.resp;

import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

public class Text {
	// 回复的消息内容
	@XmlElement(name="Content")
	@XmlCDATA
	private String content;
}
