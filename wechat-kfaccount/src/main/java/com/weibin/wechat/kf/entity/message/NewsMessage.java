package com.weibin.wechat.kf.entity.message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonAutoDetect
public class NewsMessage extends BaseMessage{

	private News news;
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}



	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		List<Article> list = new ArrayList<Article>();
		for(int i=0;i<5;i++){
			Article article = new Article();
			article.setDescription("dec"+i);
			article.setPicurl("picurl"+i);
			article.setTitle("title"+i);
			article.setUrl("url"+i);
			list.add(article);
		}
		News news = new News();
		news.setArticles(list);
		NewsMessage articleMessage = new NewsMessage();
		articleMessage.setNews(news);
		ObjectMapper mapper = new ObjectMapper();
//		FilterProvider filters = new SimpleFilterProvider().addFilter("myfilte", SimpleBeanPropertyFilter.filterOutAllExcept("expires_in"));
//		mapper.setFilters(filters);
		System.out.println(mapper.writeValueAsString(articleMessage));
	}
}
