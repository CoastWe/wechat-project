package com.weibin.wechat.menu.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 菜单
 * 
 * @author chenweibin
 * @date 2015-8-6
 */
public class Menu {
	private Button[] button;
	@JsonProperty("matchrule")
	private MatchRule matchRule;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	public MatchRule getMatchRule() {
		return matchRule;
	}

	public void setMatchRule(MatchRule matchRule) {
		this.matchRule = matchRule;
	}
	 
}
