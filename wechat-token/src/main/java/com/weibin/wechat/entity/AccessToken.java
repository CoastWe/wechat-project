package com.weibin.wechat.entity; 

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 访问凭证
 */
public class AccessToken implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("access_token")
	private String accessToken;// 令牌
	@JsonProperty("expires_in")
	private long expiresIn;// 有效时长 单位秒
	@JsonIgnore
	private long createTime;// 创建时间 单位毫秒
	@JsonProperty("errmsg")
	private String msg;
	@JsonProperty("errcode")
	private long code;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public long getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	
	
}
