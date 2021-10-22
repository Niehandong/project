package com.oracleoaec.bizimpl;

import java.util.List;

import com.oracleoaec.biz.INewsBiz;
import com.oracleoaec.dao.INewsDao;
import com.oracleoaec.daoimpl.NewsDaoImpl;
import com.oracleoaec.pojo.News;

public class NewsBizImpl implements INewsBiz{
	INewsDao ind=new NewsDaoImpl();

	public List<News> getNews() {
		return ind.getNews();
	}

	public News getNewsById(Long hnId) {
		News news=new News();
		news.setHnId(hnId);
		return ind.getNewsById(news);
	}

	
	
	
	
	
}
