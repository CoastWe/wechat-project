package com.weibin.wechat.message.entity.resp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.weibin.wechat.message.entity.BaseMessage;

/**
 * 微信音乐回复消息封装基类
 * @author chenweibin
 * @date 2015-8-6
 */
@XmlRootElement(name="xml")
public class RespMusicMessage extends BaseMessage {
	// 音乐
	@XmlElement(name="Music")
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	

}
