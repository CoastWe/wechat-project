package com.weibin.wechat.user.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.weibin.wechat.user.dto.WeixinGroupMixIn;
import com.weibin.wechat.user.entity.WeixinGroup;
import com.weibin.wechat.util.HttpUtil;
import com.weibin.wechat.util.JacksonUtil;

/**
 *  
 * @author weibin
 * @date 2016年2月25日
 */
public class UserUtil {
//	创建组
	private static String CREATE = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
//	查询所有的组
	private static String ALL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
//	查询用户所在的组
	private static String GET_ID = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
	
	/**
	 * 创建组
	 * @param token
	 * @param group
	 * @return
	 */
	public static WeixinGroup createGroups(String token,WeixinGroup group){
		String url = CREATE.replace("ACCESS_TOKEN", token);
		JacksonUtil jsoJacksonUtil = JacksonUtil.nonEmptyMapper();
		jsoJacksonUtil.enableRoot(true, true);
		jsoJacksonUtil.enableFilter("groupFilter", new String[]{"name"});
		jsoJacksonUtil.getMapper().addMixIn(WeixinGroup.class, WeixinGroupMixIn.class);
		String rt = HttpUtil.executePost(url, jsoJacksonUtil.toJson(group), 2000);
		group = jsoJacksonUtil.fromJson(rt, WeixinGroup.class);
		return group;	
	}
	
	/**
	 * 获取所有的组
	 * @param token
	 * @return
	 */
	public static List<WeixinGroup> getAll(String token){
		String url = ALL.replace("ACCESS_TOKEN", token);
		String rt = HttpUtil.executeGet(url, 2000);
		JacksonUtil jsUtil = JacksonUtil.nonEmptyMapper();
		try {
			JsonNode node = jsUtil.getMapper().readTree(rt);
			JsonNode groups = node.get("groups");
			return jsUtil.fromJson(groups.toString(), jsUtil.contructCollectionType(ArrayList.class, WeixinGroup.class));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * 获取用户所在的组
	 * @param token
	 * @param openId
	 * @return
	 */
	public static WeixinGroup getId(String token,String openId){
		String url = GET_ID.replace("ACCESS_TOKEN", token);
		return null;
	}
}
