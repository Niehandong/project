package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.pojo.News;

public interface INewsDao {
	
	/**
	 * 查询最新的rownum条消息
	 * @param rownum
	 * @return List<News>
	 */
	public List<News> getNews();
	
	public News getNewsById(News news);
	
	
	
	
	
	
	
	
	
	
}
