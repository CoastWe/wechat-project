package com.weibin.wechat.user.util;

import com.weibin.wechat.user.entity.WeixinGroup;
import com.weibin.wechat.util.HttpUtil;
import com.weibin.wechat.util.JacksonUtil;

/**
 *  
 * @author weibin
 * @date 2016年2月25日
 */
public class UserUtil {
	private static String CREATE = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
	
	public static WeixinGroup createGroups(String token,WeixinGroup group){
		String url = CREATE.replace("ACCESS_TOKEN", token);
		String body = JacksonUtil.nonDefaultMapper().toJson(group);
		String rt = HttpUtil.executePost(url, body, 2000);
		group = JacksonUtil.nonDefaultMapper().fromJson(rt, WeixinGroup.class);
		return group;	
	}
}
