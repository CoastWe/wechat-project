package com.weibin.wechat.entity.message;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class VoiceMessage extends BaseMessage{
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
}
