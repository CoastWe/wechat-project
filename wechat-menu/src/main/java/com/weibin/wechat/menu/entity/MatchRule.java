package com.weibin.wechat.menu.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 * @author weibin
 * @date 2016年2月25日
 */
public class MatchRule {
	@JsonProperty("group_id")
	private String groupId;
	private String sex ;
	@JsonProperty("client_platform_type")
	private String clientPlatformType ;
	private String country;
	private String province;
	private String city;
	private String language;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClientPlatformType() {
		return clientPlatformType;
	}
	public void setClientPlatformType(String clientPlatformType) {
		this.clientPlatformType = clientPlatformType;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
}
