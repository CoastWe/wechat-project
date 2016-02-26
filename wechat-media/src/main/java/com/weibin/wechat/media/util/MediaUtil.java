package com.weibin.wechat.media.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.weibin.wechat.media.dto.NewsMedia;
import com.weibin.wechat.media.dto.UpdateNewsMedia;
import com.weibin.wechat.media.entity.MediaType;
import com.weibin.wechat.media.entity.MediaVideo;
import com.weibin.wechat.media.entity.WeixinMedia;
import com.weibin.wechat.util.HttpUtil;
import com.weibin.wechat.util.JacksonUtil;

/**
 * @author weibin
 *
 */
public class MediaUtil {
	private static Logger log = Logger.getLogger(MediaUtil.class);
	
//	上传临时素材
	public static String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
//	下载临时素材
	public static String DOWLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
//  添加永久素材 除news和image
	public static String ADD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";
//	添加永久的news
	public static String ADD_NEWS = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
//	获取永久的文件
	public static String GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
//	删除永久的文件
	public static String DEL_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
//	修改永久图文
	public static String UPDATE_NEWS = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";

	
	
	
	/**
	 * @param token
	 * @param type
	 * @param file
	 * @return
	 */
	public static WeixinMedia uploadMedia(String token,MediaType type,File file){
		String url = UPLOAD_URL.replace("ACCESS_TOKEN", token).replace("TYPE", type.name());
		String rt = HttpUtil.executePost(url, file, 2000);
		log.info(rt);
		WeixinMedia media = JacksonUtil.nonDefaultMapper().fromJson(rt, WeixinMedia.class);
		return media;	
	}
	
	/**
	 * @param token
	 * @param mediaId
	 * @param filePath
	 * @param type
	 * @return
	 */
	public static String downlaodMedia(String token,String mediaId,String filePath,MediaType type){
		String url = DOWLOAD_URL.replace("ACCESS_TOKEN", token).replace("MEDIA_ID", mediaId);
		log.info(url);
		String rt = HttpUtil.downloadGet(url, filePath);
		return rt;
	}
	
	
	/**
	 * 添加永久材料 除图文消息，和视频消息
	 * @param token
	 * @param type
	 * @param file
	 * @return
	 */
	public static WeixinMedia upload(String token,MediaType type,File file){
		String url = ADD_MATERIAL.replace("ACCESS_TOKEN", token);
		log.info(url);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("media", file);
		String rt = HttpUtil.executePost(url, map, 4000);
		log.info(rt);
		JacksonUtil jsonUtil = JacksonUtil.nonDefaultMapper();
		WeixinMedia weixinMedia = jsonUtil.fromJson(rt, WeixinMedia.class);
		weixinMedia.setType(type.name());
		return weixinMedia;
	}
	
	/**
	 * 添加永久材料 图文消息
	 * @param token
	 * @param type
	 * @param file
	 * @return
	 */
	public static WeixinMedia uploadNews(String token,MediaType type,NewsMedia object){
		String url = ADD_NEWS.replace("ACCESS_TOKEN", token);
		log.info(url);
		String json = JacksonUtil.nonDefaultMapper().toJson(object);
		String rt = HttpUtil.executePost(url, json, 2000);
		log.info(rt);
		JacksonUtil jsonUtil = JacksonUtil.nonDefaultMapper();
		WeixinMedia weixinMedia = jsonUtil.fromJson(rt, WeixinMedia.class);
		weixinMedia.setType(type.name());
		return weixinMedia;
	}
	
	/**
	 * 添加永久材料 视频消息
	 * @param token
	 * @param type
	 * @param file
	 * @return
	 */
	public static WeixinMedia uploadVideo(String token,MediaType type,File file,MediaVideo object){
		String url = ADD_MATERIAL.replace("ACCESS_TOKEN", token);
		log.info(url);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("media", file);
		map.put("description", object);
		String rt = HttpUtil.executePost(url, map, 4000);
		log.info(rt);
		JacksonUtil jsonUtil = JacksonUtil.nonDefaultMapper();
		WeixinMedia weixinMedia = jsonUtil.fromJson(rt, WeixinMedia.class);
		weixinMedia.setType(type.name());
		return weixinMedia;
	}
	
	
	
	/**
	 * 获取永久的视频
	 * @param token
	 * @param mediaId
	 * @return
	 */
	public static MediaVideo getVideo(String token,WeixinMedia mediaId){
		String url = GET_MATERIAL.replace("ACCESS_TOKEN", token);
		String json = JacksonUtil.nonDefaultMapper().toJson(mediaId);
		log.info(url);
		String rt = HttpUtil.executePost(url, json, 4000);
		log.info(rt);
		JacksonUtil jsonUtil = JacksonUtil.nonDefaultMapper();
		MediaVideo mediavideo= jsonUtil.fromJson(rt, MediaVideo.class);
		return mediavideo;
	}
	
	/**
	 * 获取图文
	 * @param token
	 * @param mediaId
	 * @return
	 */
	public static List<NewsMedia> getNews(String token,WeixinMedia mediaId){
		String url = GET_MATERIAL.replace("ACCESS_TOKEN", token);
		JacksonUtil jsonUtil = JacksonUtil.nonDefaultMapper();
		String json = jsonUtil.toJson(mediaId);
		log.info(url);
		String rt = HttpUtil.executePost(url, json, 4000);
		log.info(rt);
		JsonNode jsonTree;
		try {
			jsonTree = jsonUtil.getMapper().readTree(rt);
			JsonNode articles = jsonTree.get("news_item");
			JavaType type = jsonUtil.contructCollectionType(ArrayList.class, NewsMedia.class);
			List<NewsMedia> list = jsonUtil.fromJson(articles.toString(), type);
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return null;
	}
	
	/**
	 * 获取普通永久文件
	 * @param token
	 * @param mediaId
	 * @param filePath
	 * @return
	 */
	public static String getMedia(String token,WeixinMedia mediaId,String filePath){
		String url = GET_MATERIAL.replace("ACCESS_TOKEN", token);
		String json = JacksonUtil.nonDefaultMapper().toJson(mediaId);
		log.info(url);
		String rt = HttpUtil.downloadPost(url,filePath,json);
		log.info(rt);
		return rt;
	}
	

	/**
	 * 删除文件
	 * @param token
	 * @param mediaId
	 * @return
	 */
	public static String delMaterial(String token,WeixinMedia mediaId){
		String url = DEL_MATERIAL.replace("ACCESS_TOKEN", token);
		String json = JacksonUtil.nonDefaultMapper().toJson(mediaId);
		log.info(url);
		String rt = HttpUtil.executeGet(url, 2000);
		log.info(rt);
		return rt;
	}
	
	/**
	 * @param token
	 * @param mediaId
	 * @return
	 */
	public static String updateNews(String token,UpdateNewsMedia mediaId){
		String url = DEL_MATERIAL.replace("ACCESS_TOKEN", token);
		String json = JacksonUtil.nonDefaultMapper().toJson(mediaId);
		log.info(url);
		String rt = HttpUtil.executeGet(url, 2000);
		log.info(rt);
		return rt;
	}
}
