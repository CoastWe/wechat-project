package com.weibin.wechat.entity.message;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class VideoMessage extends BaseMessage{
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}
