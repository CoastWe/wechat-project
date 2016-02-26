package com.weibin.wechat.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

public class JAXBUtil {
	private static Logger logger = Logger.getLogger(JAXBUtil.class);
	public static  String marshaller(Object t){
		try {
			JAXBContext context = JAXBContext.newInstance(t.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter writer = new StringWriter();
			marshaller.marshal(t, writer);
			String rt = writer.toString();
			System.out.println(rt);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return "";		
	}
	
	public static <T> T unMarshaller(String xml,Class<T> t){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(t);
			Unmarshaller unMarshaller = context.createUnmarshaller();
			T rt = (T) unMarshaller.unmarshal(new StringReader(xml));
			return rt;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
//		String newxml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>12345678</CreateTime>"+
//"<MsgType><![CDATA[news]]></MsgType><ArticleCount>2</ArticleCount><Articles><item><Title><![CDATA[title1]]></Title> <Description><![CDATA[description1]]></Description><PicUrl><![CDATA[picurl]]></PicUrl><Url><![CDATA[url]]></Url></item><item><Title><![CDATA[title]]></Title><Description><![CDATA[description]]></Description><PicUrl><![CDATA[picurl]]></PicUrl><Url><![CDATA[url]]></Url></item></Articles></xml>";
//		marshaller(unMarshaller(newxml,RespNewsMessage.class));
//		String textxml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>12345678</CreateTime>"+
//		"<MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好]]></Content></xml>";
//		marshaller(unMarshaller(textxml,RespTextMessage.class));
//		String imagexml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>12345678</CreateTime>"+
//				"<MsgType><![CDATA[image]]></MsgType><Image><MediaId><![CDATA[media_id]]></MediaId></Image></xml>";
//		marshaller(unMarshaller(imagexml,RespImageMessage.class));
//		String voicexml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>12345678</CreateTime>"+
//				"<MsgType><![CDATA[voice]]></MsgType><Voice><MediaId><![CDATA[media_id]]></MediaId></Voice></xml>";
//		marshaller(unMarshaller(voicexml,RespVoiceMessage.class));
//		String videoxml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>12345678</CreateTime>"+
//				"<MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[media_id]]></MediaId><Title><![CDATA[title]]></Title><Description><![CDATA[description]]></Description></Video> </xml>";
//		marshaller(unMarshaller(videoxml,RespVideoMessage.class));
//		String musicxml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>12345678</CreateTime>"+
//				"<MsgType><![CDATA[music]]></MsgType><Music><Title><![CDATA[TITLE]]></Title><Description><![CDATA[DESCRIPTION]]></Description><MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl><HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl><ThumbMediaId><![CDATA[media_id]]></ThumbMediaId></Music></xml>";
//		marshaller(unMarshaller(musicxml,RespMusicMessage.class));
//		Image image = new Image();
//		image.setMediaid("image");
//		RespImageMessage respImageMessage = new RespImageMessage();
//		respImageMessage.setCreateTime(12345678);
//		respImageMessage.setFromUserName("FROMUSER");
//		respImageMessage.setToUserName("touser");
//		respImageMessage.setMsgType("msgtype");
//		marshaller(respImageMessage);
		
//		String textxml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>12345678</CreateTime>"+
//		"<MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好]]></Content><MsgId>1234567890123456</MsgId></xml>";
//		marshaller(unMarshaller(textxml,ReqTextMessage.class));
	}
}
