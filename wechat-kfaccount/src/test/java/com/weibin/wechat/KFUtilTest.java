package com.weibin.wechat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.weibin.wechat.entity.KfAccount;
import com.weibin.wechat.entity.message.Text;
import com.weibin.wechat.entity.message.TextMessage;

public class KFUtilTest {
	private KfAccount account;
	private Text text = new Text();
	private TextMessage textMessage = new TextMessage();
	private String xml;
	@Before
	public void before(){
		account= new KfAccount();
		account.setUserName("test1@test");
//		account.setPassword("123");
		account.setNickname("wo");
		account.setStatus(0);
		xml = "{\"kf_account\" : \"test1@test\",\"nickname\" :\"客服1\",\"password\" : \"pswmd5\"}";
		text.setContent("nihao");
		textMessage.setTouser("o-kb6s1kc9B0RbAb0oJ3HBNqEh9M");
		textMessage.setMsgtype("text");
		textMessage.setText(text);
	}
	@Test
	public void test() throws JsonGenerationException, JsonMappingException, IOException{
//		System.out.println(KfAccountUtil.addKF(account,AccessTokenUtil.queryAccessToken().getAccessToken()));
//		System.out.println(KfAccountUtil.sendMessage(textMessage, AccessTokenUtil.queryAccessToken().getAccessToken()));
//		KfAccountUtil.getAllKF(AccessTokenUtil.queryAccessToken().getAccessToken());
//		System.out.println(account);
	}
}
