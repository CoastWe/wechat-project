package com.weibin.wechat.kf.entity.message;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("text")
public class Text {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
