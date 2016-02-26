package com.weibin.wechat.entity;

import java.io.Serializable;

/**
 * JSSDK的凭证
 * @author weibin
 *	@date 2015-08-12	
 */
public class Ticket implements Serializable{
	// 接口访问凭证
	private String ticket;
	// 凭证有效期，单位：秒
	private int expiresIn;
	private int errcode;
	private String errmsg;
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
		
}
