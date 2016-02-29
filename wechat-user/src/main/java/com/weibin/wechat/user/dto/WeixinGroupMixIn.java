package com.weibin.wechat.user.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *  
 * @author weibin
 * @date 2016年2月25日
 */
@JsonFilter("groupFilter")
@JsonRootName("group")
public interface WeixinGroupMixIn {
}
