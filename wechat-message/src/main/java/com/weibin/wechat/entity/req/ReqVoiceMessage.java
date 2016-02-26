package com.weibin.wechat.entity.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.weibin.wechat.message.entity.BaseMessage;

/**
 * 微信声音消息封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="xml")
public class ReqVoiceMessage extends ReqBaseMessage {
	// 媒体ID
	@XmlElement(name="MediaId")
	@XmlCDATA
	private String mediaid;
	// 语音格式
	@XmlElement(name="Format")
	@XmlCDATA
	private String format;
	// 语音识别结果，UTF8编码
	@XmlElement(name="Recognition")
	@XmlCDATA
	private String recognition;
	public String getMediaid() {
		return mediaid;
	}
	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	
}
