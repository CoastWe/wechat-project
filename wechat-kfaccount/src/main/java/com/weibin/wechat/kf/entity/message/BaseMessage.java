package com.weibin.wechat.kf.entity.message;

import com.weibin.wechat.entity.KfAccount;

/**消息格式{
    "touser":"OPENID",
    "msgtype":"text",
    "text":
    {
         "content":"Hello World"
    },
    "customservice":
    {
         "kf_account": "test1@kftest"
    }
}
 * @author weibin
 *
 */
public class BaseMessage {
	private String touser;
	private String msgtype;
	private KfAccount customservice;
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public KfAccount getCustomservice() {
		return customservice;
	}
	public void setCustomservice(KfAccount customservice) {
		this.customservice = customservice;
	}
		
}
