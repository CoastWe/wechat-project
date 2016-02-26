package com.weibin.wechat;

import java.io.File;

import org.junit.Test;

import com.weibin.wechat.media.entity.MediaType;
import com.weibin.wechat.media.util.MediaUtil;
import com.weibin.wechat.util.AccessTokenUtil;

/**
 *  
 * @author weibin
 * @date 2016年2月24日
 */
public class MediaUtilTest {
	@Test
	public void test(){
		File file = new File("D:\\QQ截图20151107103158.png");
		System.out.println(file);
		String token = AccessTokenUtil.queryAccessToken().getAccessToken();
		;
		System.out.println(MediaUtil.uploadMedia(token, MediaType.image, file));
//		System.out.println(MediaUtil.downlaodMedia(token, "BTcYnkQRkMc5ZKtPk8WRdCMdLyy-mXBK1ochv-XbuGitHtdhNFMfS0LNEfJUdo5q", null, null));
	}
}
