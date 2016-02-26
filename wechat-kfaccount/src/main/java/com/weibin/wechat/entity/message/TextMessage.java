package com.weibin.wechat.entity.message;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonAutoDetect
public class TextMessage extends BaseMessage {
	private Text text;

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Text text = new Text();
		text.setContent("nihao ");
		TextMessage textMessage = new TextMessage();
		textMessage.setText(text);
		textMessage.setMsgtype("text");
		textMessage.setTouser("id");
		ObjectMapper mapper = new ObjectMapper();
//		FilterProvider filters = new SimpleFilterProvider().addFilter("myfilte", SimpleBeanPropertyFilter.filterOutAllExcept("expires_in"));
//		mapper.setFilters(filters);
		System.out.println(mapper.writeValueAsString(textMessage));
	}
	
}
