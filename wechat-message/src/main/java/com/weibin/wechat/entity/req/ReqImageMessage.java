package com.weibin.wechat.entity.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.weibin.wechat.message.entity.BaseMessage;
@XmlRootElement(name="xml")
public class ReqImageMessage extends ReqBaseMessage {
	// 图片链接
	@XmlElement(name="PicUrl")
	@XmlCDATA
	private String picurl;
	// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	@XmlElement(name="MediaId")
	@XmlCDATA
	private String mediaid;
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getMediaid() {
		return mediaid;
	}
	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}
	
	
	
}
