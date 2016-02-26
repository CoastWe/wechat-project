package com.weibin.wechat.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.weibin.wechat.entity.KfAccount;

/**
 * @author weibin
 *
 */
public class KfAccountUtil {
	private static Logger log = LoggerFactory.getLogger(KfAccountUtil.class);
	//	添加客服url
	public static final String ADD_KF = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	//修改客服url
	public static final String UPDATE_KF = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
//	删除客服url
	public static final String DEL_KF = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
//	修改客服头像
	public static final String UPLOAD_HEAD_IMG = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
//	获得所有客服
	public static final String LIST_KF = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
//	获得在线的客服
	public static final String ONLINE_LIST_KF = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=ACCESS_TOKEN";
//  发送客服消息
	public static final String SEND_MESSAGE_KF = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	
	/**
	 * 添加客服
	 * @param object 客服类 （必须有username，nickname，password）值
	 * @param token token
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String addKF(Object object,String token) {
		
		String rt = JacksonUtil.nonDefaultMapper().toJson(change(object));
		log.info(rt);
		log.info(ADD_KF.replace("ACCESS_TOKEN", token));
		return HttpUtil.executePost(ADD_KF.replace("ACCESS_TOKEN", token), rt, 2000);
	}
	
	/**
	 * 修改客服
	 * @param object 客服类 （必须有username，nickname，password）值
	 * @param token token
	 * @return
	 */
	public static String updateKF(Object object,String token){
		String rt = JacksonUtil.nonDefaultMapper().toJson(change(object));
		log.info(rt);
		log.info(UPDATE_KF.replace("ACCESS_TOKEN", token));
		return HttpUtil.executePost(UPDATE_KF.replace("ACCESS_TOKEN", token), rt, 2000);
	}
	/**
	 * 设置某个客服的头像
	 * @return
	 */
	public static String setHeadImgKF(String token,String kfAccount,File imgFile){
		String url = UPLOAD_HEAD_IMG.replace("ACCESS_TOKEN", token).replace("KFACCOUNT", kfAccount);
		return null;		
	}
	/**
	 * 删除客服
	 * @param object 客服类（必须有username，nickname，password）值
	 * @param token
	 * @return
	 */
	public static String deleteKF(Object object,String token){
		String rt = JacksonUtil.nonDefaultMapper().toJson(change(object));
		log.info(rt);
		log.info(DEL_KF.replace("ACCESS_TOKEN", token));
		return HttpUtil.executePost(DEL_KF.replace("ACCESS_TOKEN", token), rt, 2000);
	}
	
	/**
	 * 获取客服列表
	 * @param token
	 * @return
	 */
	public static List<KfAccount> getAllKF(String token){
		String rt = HttpUtil.executeGet(LIST_KF.replace("ACCESS_TOKEN", token), 2000);
		log.info(rt);
		List<KfAccount> list = null;
		JacksonUtil jacksonUtil = JacksonUtil.nonDefaultMapper();
		JavaType type = jacksonUtil.contructCollectionType(ArrayList.class, KfAccount.class);
		try {
			JsonNode node = jacksonUtil.getMapper().readTree(rt);
			JsonNode listKf = node.get("kf_list");
			list = jacksonUtil.fromJson(listKf.toString(), type);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
		return list;	
	}
	/**
	 * 获取在线客服列表
	 * @param token
	 * @return
	 */
	public static List<KfAccount> getOnlineAllKF(String token){
		String rt = HttpUtil.executeGet(ONLINE_LIST_KF.replace("ACCESS_TOKEN", token), 2000);
		log.info(rt);
		List<KfAccount> list = null;
		JacksonUtil jacksonUtil = JacksonUtil.nonDefaultMapper();
		JavaType type = jacksonUtil.contructCollectionType(ArrayList.class, KfAccount.class);
		try {
			JsonNode node = jacksonUtil.getMapper().readTree(rt);
			JsonNode listKf = node.get("kf_online_list");
			list = jacksonUtil.fromJson(listKf.toString(), type);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
		return list;	
	}
	
	/**
	 * 发送客服消息
	 * @param object BaseMessage的子类
	 * @param token 凭证
	 * @return
	 */
	public static String sendMessage(Object object,String token){
//		String rt = JacksonUtil.buildNonDefaultBinder().toJson(object);
		String rt = "{\"touser\":\"o-kb6s1kc9B0RbAb0oJ3HBNqEh9M\",\"msgtype\":\"text\",\"text\":{\"content\":\"Hello World\"}}";
		log.info(rt);
		log.info(ADD_KF.replace("ACCESS_TOKEN", token));
		return HttpUtil.executePost(ADD_KF.replace("ACCESS_TOKEN", token), rt, 2000);
	}
	
	/**
	 * 转换客服类，以让json符合格式
	 * @param object
	 * @return
	 */
	private static KfAccount change(Object object){
		KfAccount obj = (KfAccount) object;
		KfAccount account = new KfAccount();
		account.setUserName(obj.getUserName());
		account.setPassword(obj.getPassword());
		account.setNickname(obj.getNickname());
		return account;
	}
}
