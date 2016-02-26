package com.weibin.wechat.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * @author weibin
 *
 */
public class WxConfig {
	public static final String APPID;
	public static final String APPSECRET;
	public static final String TOKEN;
	private static Logger log = Logger.getLogger(WxConfig.class);
	
	static{
		InputStream in = WxConfig.class.getClassLoader().
							getResourceAsStream("config.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
			APPID = pro.getProperty("APPID","");
			APPSECRET = pro.getProperty("APPSECRET", "");
			TOKEN = pro.getProperty("TOKEN","");
			log.error(APPID+":"+APPSECRET+":"+TOKEN);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
			throw new RuntimeException("load config error " + e.getMessage());
		}
		
	}
	
//	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
//		System.out.println(WxConfig.APPID);
//		AccessTokenUtil.queryAccessToken();
//		ObjectMapper mapper = new ObjectMapper();
//		FilterProvider filters = new SimpleFilterProvider().addFilter("myfilte", SimpleBeanPropertyFilter.filterOutAllExcept("expires_in"));
//		mapper.setFilters(filters);
//		System.out.println(mapper.writeValueAsString(AccessTokenUtil.queryAccessToken()));
//	}
}
