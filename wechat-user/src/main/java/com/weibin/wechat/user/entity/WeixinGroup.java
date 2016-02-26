package com.weibin.wechat.user.entity;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * 公众账号分组信息
 * 
  * @author chenweibin
 * @date 2015-8-6
 */
@JsonRootName("group")
public class WeixinGroup {
	// 分组id
	private int id;
	// 分组名称
	private String name;
	// 分组内的用户数
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "WeixinGroup [id=" + id + ", name=" + name + ", count=" + count
				+ "]";
	}
	
	
}

