package com.weibin.wechat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.weibin.wechat.user.dto.WeixinGroupMixIn;
import com.weibin.wechat.user.entity.WeixinGroup;
import com.weibin.wechat.util.JacksonUtil;

/**
 *  
 * @author weibin
 * @date 2016年2月25日
 */
public class UserTest {
	
	private WeixinGroup group;
	private String xml;
	private String xml1;
	@Before
	public void before(){
		group = new WeixinGroup();
		group.setName("nickname");
		group.setId(1);
		group.setCount(1);
		xml ="{\"groups\": {\"id\": 107, \"name\": \"test\"}}";
	}
	@Test
	public void test() throws IOException{
		JacksonUtil mapper = JacksonUtil.nonDefaultMapper();
		JsonNode node = mapper.fromJson(xml, JsonNode.class);
		
		System.out.println(node.toString());
//		mapper.enableFilter("groupFilter", new String[]{"name"});
//		mapper.getMapper().addMixIn(WeixinGroup.class, WeixinGroupMixIn.class);
//		System.out.println(mapper.toJson(group));
//		System.out.println(mapper.fromJson(xml, WeixinGroup.class));
	}

}
