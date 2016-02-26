package com.weibin.wechat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
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
	@Before
	public void before(){
		group = new WeixinGroup();
		group.setName("nickname");
		group.setId(1);
		xml ="{\"group\":{\"name\":\"test\"}}";
	}
	@Test
	public void test() throws IOException{
		ObjectMapper mapper = JacksonUtil.nonEmptyMapper().getMapper();
		mapper.addMixIn(WeixinGroup.class, WeixinGroupMixIn.class);
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		System.out.println(mapper.writeValueAsString(group));
	}

}
