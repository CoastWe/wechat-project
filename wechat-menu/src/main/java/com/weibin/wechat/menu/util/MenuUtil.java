package com.weibin.wechat.menu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weibin.wechat.menu.entity.Button;
import com.weibin.wechat.menu.entity.ComplexButton;
import com.weibin.wechat.menu.entity.Menu;
import com.weibin.wechat.menu.entity.ViewButton;
import com.weibin.wechat.util.HttpUtil;
import com.weibin.wechat.util.JacksonUtil;
import com.weibin.wechat.util.WxConfig;

/**
 * 自定义菜单工具类
 * 
 * @author chenweibin
 * @date 2015-8-8
 */
public class MenuUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);

	// 菜单创建（POST）
	public final static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 菜单查询（GET）
	public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	// 菜单删除（GET）
	public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * 创建菜单
	 * 
	 * @param menu 菜单实例
	 * @param accessToken 凭证
	 * @return true成功 false失败
	 */
	public static boolean createMenu(Menu menu, String accessToken) {
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		String rt = HttpUtil.executePost(url, JacksonUtil.nonDefaultMapper().toJson(menu), 2000);
		return true;
	}

	/**
	 * 查询菜单
	 * 
	 * @param accessToken 凭证
	 * @return
	 */
	public static String getMenu(String accessToken) {
		String result = null;
		String requestUrl = menu_get_url.replace("ACCESS_TOKEN", accessToken);
		// 发起GET请求查询菜单
		result = HttpUtil.executeGet(requestUrl, 2000);
		return result;
	}

	/**
	 * 删除菜单
	 * 
	 * @param accessToken 凭证
	 * @return true成功 false失败
	 */
	public static boolean deleteMenu(String accessToken) {
		boolean result = false;
		String requestUrl = menu_delete_url.replace("ACCESS_TOKEN", accessToken);
		HttpUtil.executeGet(requestUrl, 2000);
		return result;
	}
	public static void main(String[] args) {
		String url = "www.baidu.com";
		ViewButton btn11 = new ViewButton();
		btn11.setName("我的摄像机");
		btn11.setType("view");
		btn11.setUrl("http://wechatdev.sky-light.com.hk/front/wechat/static/home.html");
		
//		ViewButton btn21 = new ViewButton();
//		btn21.setName("Buy Camera");
//		btn21.setType("view");
//		
//		System.out.println(url);
//		btn21.setUrl(url);

		ViewButton btn22 = new ViewButton();
		btn22.setName("让摄像机上网");
		btn22.setType("view");
		btn22.setUrl("http://wechatdev.sky-light.com.hk/front/wechat/static/airkiss.html");

		ViewButton btn23 = new ViewButton();
		btn23.setName("绑定账号");
		btn23.setType("view");
		btn23.setUrl("http://wechatdev.sky-light.com.hk/front/wechat/static/airkiss");
		
		ViewButton btn24 = new ViewButton();
		btn24.setName("俊腾测试");
		btn24.setType("view");
		btn24.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WxConfig.APPID+"&redirect_uri=http://wechatdev.sky-light.com.hk/front/wechat/home&response_type=54&scope=snsapi_base&state=wechat/static/talk.html#wechat_redirect");
		
		ViewButton btn25 = new ViewButton();
		btn25.setName("伟滨测试");
		btn25.setType("view");
		btn25.setUrl("http://wechatdev.sky-light.com.hk/front/wechat/static/airkiss.html");
		
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("更多");
		mainBtn2.setSub_button(new Button[] { btn22,btn23,btn24,btn25});
//		mainBtn2.setSub_button(new Button[] { btn22,btn23 });

		Menu menu = new Menu();
		menu.setButton(new Button[] { btn11, mainBtn2});
		System.out.println(JacksonUtil.nonDefaultMapper().toJson(menu));
	}
}
