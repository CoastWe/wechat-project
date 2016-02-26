package com.weibin.wechat.entity.message;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class MusicMessage extends BaseMessage{
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
}

