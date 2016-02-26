package com.weibin.wechat.menu.entity;

/**
 * view类型的按钮
 * 
 * @author chenweibin
 * @date 2015-8-6
 */
public class ViewButton extends Button {
	private String type;
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
