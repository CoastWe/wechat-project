package com.weibin.wechat.kf.entity.message;

import com.fasterxml.jackson.annotation.JsonProperty;
//@JsonFilter("kffilter")
public class KfAccount {
	@JsonProperty("kf_account")
	private String userName;
	@JsonProperty("password")
	private String password;
	@JsonProperty("kf_id")
	private String id;
	@JsonProperty("kf_headimgurl")
	private String headImgUrl;
	@JsonProperty("nickname")
	private String nickname;
	@JsonProperty("kf_nick")
	private String kfNick;
	@JsonProperty("status")
	private long status;
	@JsonProperty("auto_accept")
	private long autoAccept;
	@JsonProperty("accepted_case")
	private long acceptedCase;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getKfNick() {
		return kfNick;
	}
	public void setKfNick(String kfNick) {
		this.kfNick = kfNick;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public long getAutoAccept() {
		return autoAccept;
	}
	public void setAutoAccept(long autoAccept) {
		this.autoAccept = autoAccept;
	}
	public long getAcceptedCase() {
		return acceptedCase;
	}
	public void setAcceptedCase(long acceptedCase) {
		this.acceptedCase = acceptedCase;
	}
	@Override
	public String toString() {
		return "KfAccount [userName=" + userName + ", password=" + password
				+ ", id=" + id + ", headImgUrl=" + headImgUrl + ", nickname="
				+ nickname + ", kfNick=" + kfNick + ", status=" + status
				+ ", autoAccept=" + autoAccept + ", acceptedCase="
				+ acceptedCase + "]";
	}
	
	
}
