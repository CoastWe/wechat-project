package com.weibin.wechat.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpUtil {
	
	private static Logger log = Logger.getLogger(HttpUtil.class);
	
    public static final int cache = 10 * 1024;  
    public static final boolean isWindows;  
    public static final String splash;  
    public static final String root;  
    static {  
        if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().contains("windows")) {  
            isWindows = true;  
            splash = "\\";  
            root="D:";  
        } else {  
            isWindows = false;  
            splash = "/";  
            root="/search";  
        }  
    }  
	
	/**
	 * 进行get请求
	 * @param url 请求url
	 * @return
	 */
	public static String executeGet(String url,int timeout){
		
		HttpGet httpGet = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
		httpGet.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			httpResponse.getStatusLine();
			HttpEntity httpEntity = httpResponse.getEntity();
			return httpEntity == null ? null : EntityUtils
					.toString(httpEntity, "UTF-8");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return null;	
	}
	/**
	 * 进行post请求
	 * @param url 请求url
	 * @param body 请求参数
	 */
	public static String executePost(String url,String body,int timeout){
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
		httpPost.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		StringEntity entity = new StringEntity(body, "UTF-8");
		httpPost.setEntity(entity);
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			httpResponse.getStatusLine();
			HttpEntity httpEntity = httpResponse.getEntity();
			return httpEntity == null ? null : EntityUtils
					.toString(httpEntity, "UTF-8");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return null;
	}
	/**
	 * 进行post请求
	 * @param url 请求url
	 * @param body 请求参数
	 */
	public static String executePost(String url,File file,int timeout){
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
		httpPost.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		FileBody body = new FileBody(file);
		MultipartEntity entity = new MultipartEntity();
		entity.addPart("media", body);
		httpPost.setEntity(entity);
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			httpResponse.getStatusLine();
			HttpEntity httpEntity = httpResponse.getEntity();
			return httpEntity == null ? null : EntityUtils
					.toString(httpEntity, "UTF-8");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return null;
	}
	
	
	/**
	 * 请求参数
	 * @param url
	 * @param map
	 * @param timeout
	 * @return
	 */
	public static String executePost(String url,Map<String,Object> map,int timeout){
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
		httpPost.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		MultipartEntity entity = new MultipartEntity();
		fillEntity(entity,map);
		httpPost.setEntity(entity);
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			httpResponse.getStatusLine();
			HttpEntity httpEntity = httpResponse.getEntity();
			return httpEntity == null ? null : EntityUtils
					.toString(httpEntity, "UTF-8");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return null;
	}
	
	
	private static void fillEntity(MultipartEntity entity,
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		if(map != null){
			for(Entry en :map.entrySet()){
				String key = (String) en.getKey();
				Object value = en.getValue();
				if(value instanceof File){
					entity.addPart(key, new FileBody((File) value));
				}else if (value instanceof String){
					entity.addPart(key, new StringBody((String) value, ContentType.MULTIPART_FORM_DATA));
				}else{
					entity.addPart(key, new StringBody(JacksonUtil.nonDefaultMapper().toJson(value), ContentType.MULTIPART_FORM_DATA));
				}
			}
		}
		
	}
	/**
	 * 下载文件 
	 * @param url
	 * @param filePath
	 * @return
	 */
	public static String downloadGet(String url,String filePath){
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			InputStream is = httpEntity.getContent();
            if (filePath == null)  
            	filePath = getFilePath(httpResponse);  
            File file = new File(filePath);  
            file.getParentFile().mkdirs();  
            FileOutputStream fileout = new FileOutputStream(file); 
            /** 
             * 根据实际运行效果 设置缓冲区大小 
             */  
            byte[] buffer=new byte[cache];  
            int ch = 0;  
            while ((ch = is.read(buffer)) != -1) {  
                fileout.write(buffer,0,ch);  
            }  
            is.close();  
            fileout.flush();  
            fileout.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return filePath;
	}
	
	/**
	 * 下载文件 
	 * @param url
	 * @param filePath
	 * @return
	 */
	public static String downloadPost(String url,String filePath,String body){
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		StringEntity entity = new StringEntity(body, "UTF-8");
		httpPost.setEntity(entity);
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			InputStream is = httpEntity.getContent();
			if (filePath == null)  
				filePath = getFilePath(httpResponse);  
			File file = new File(filePath);  
			file.getParentFile().mkdirs();  
			FileOutputStream fileout = new FileOutputStream(file); 
			/** 
			 * 根据实际运行效果 设置缓冲区大小 
			 */  
			byte[] buffer=new byte[cache];  
			int ch = 0;  
			while ((ch = is.read(buffer)) != -1) {  
				fileout.write(buffer,0,ch);  
			}  
			is.close();  
			fileout.flush();  
			fileout.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return filePath;
	}
	
	
	/**
	 * 获取默认的文件名
	 * @param httpResponse
	 * @return
	 */
	private static String getFilePath(CloseableHttpResponse httpResponse) {
		// TODO Auto-generated method stub
        String filepath = root + splash;  
        String filename = getFileName(httpResponse);  
  
        if (filename != null) {  
            filepath += filename;  
        } else {  
            filepath += getRandomFileName();  
        }  
        return filepath;
	}
	/**
	 * 获取随机的文件名
	 * @return
	 */
	private static String getRandomFileName() {
		// TODO Auto-generated method stub
        return String.valueOf(System.currentTimeMillis());
	}
	
	/**
	 * 获取服务器的文件名
	 * @param httpResponse
	 * @return
	 */
	private static String getFileName(CloseableHttpResponse httpResponse) {
		// TODO Auto-generated method stub
        Header contentHeader = httpResponse.getFirstHeader("Content-Disposition");  
        String filename = null;  
        if (contentHeader != null) {  
            HeaderElement[] values = contentHeader.getElements();  
            if (values.length == 1) {  
                NameValuePair param = values[0].getParameterByName("filename");  
                if (param != null) {  
                    try {  
                        //filename = new String(param.getValue().toString().getBytes(), "utf-8");  
                        //filename=URLDecoder.decode(param.getValue(),"utf-8");  
                        filename = param.getValue();  
                    } catch (Exception e) {  
                        log.error(e);  
                    }  
                }  
            }  
        }  
        return filename;
	}
	
}
