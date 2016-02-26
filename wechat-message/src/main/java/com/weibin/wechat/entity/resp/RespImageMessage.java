package com.weibin.wechat.entity.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.weibin.wechat.message.entity.BaseMessage;

/**
 * 微信图像回复消息封装
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="xml")
public class RespImageMessage extends BaseMessage {
	// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	@XmlElement(name="Image")
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}	
}
