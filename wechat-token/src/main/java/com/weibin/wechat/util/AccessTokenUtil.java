package com.weibin.wechat.util;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weibin.wechat.entity.AccessToken;

public class AccessTokenUtil {
	private final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static Logger log = Logger.getLogger(AccessTokenUtil.class);
	/**
	 * 凭证的存储需要全局唯一
	 * <p>
	 * 单机部署情况下可以存在内存中 <br>
	 * 分布式情况需要存在集中缓存或DB中
	 */
	private static AccessToken token;
	
	private static ScheduledExecutorService timer;
	
	static {
		timer = Executors
				.newSingleThreadScheduledExecutor(new ThreadFactory() {
					public Thread newThread(Runnable run) {
						Thread t = new Thread(run);
						t.setDaemon(true);
						return t;
					}
				});
		init();
	}
	
	private static void init() {
		if (queryAccessToken() == null) {
			refreshToken();
		}
		initTimer(queryAccessToken());
	}
	
	/**
	 * 获取存储的token
	 */
	public static AccessToken queryAccessToken() {
		if(token == null){
			refreshToken();
		}
		return token;
	}
	
	// 刷新凭证并更新全局凭证值
	private static void refreshToken() {
		try {
			log.info(WxConfig.APPID);
			log.info("start referToken");
			getToken();
			
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	/**
	 * 获取接口访问凭证
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public static void getToken() {
		log.info(WxConfig.APPID);
		String requestUrl = TOKEN_URL.replace("APPID", WxConfig.APPID).replace("APPSECRET", WxConfig.APPSECRET);
		// 发起GET请求获取凭证
		String rt = null;
		try {
			rt = HttpUtil.executeGet(requestUrl,2000);
			ObjectMapper mapper = new ObjectMapper();
			AccessToken token = mapper.readValue(rt, AccessToken.class);
			token.setCreateTime(System.currentTimeMillis());
			saveAccessToken(token);
		}catch(Exception e){
			log.error(e);
			saveAccessToken(null);
			log.error("get token fail");
		}

	}
	
	/**
	 * 保存token
	 */
	private static void saveAccessToken(AccessToken accessToken) {
		token = accessToken;
	}
	
	
	/**
	 * 定义定时器
	 * @param token
	 */
	private static void initTimer(AccessToken token){
		log.info(" init token timer");
		long refreshTime = 7000;
		
		long delay = (long)(100*(new Random().nextDouble()));
		
		timer.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				AccessToken actk = queryAccessToken();
				// 200秒内只刷新一次，防止分布式集群定时任务同一段时间内重复刷新
				if (actk==null || actk.getAccessToken() == null
						|| (System.currentTimeMillis() - actk.getCreateTime() > 200000)) {
					refreshToken();
				}
			}
		}, delay, refreshTime, TimeUnit.SECONDS);
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				timer.shutdown();
			}
		}));
	}
	
	
	
}
