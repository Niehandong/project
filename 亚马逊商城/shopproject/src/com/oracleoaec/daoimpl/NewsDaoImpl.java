package com.oracleoaec.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.INewsDao;
import com.oracleoaec.pojo.News;
import com.tools.BaseDao;


public class NewsDaoImpl extends BaseDao implements INewsDao{
	
	public List<News> getNews() {
		
		String sql="select* from hwua_news";
		Object param[]={};
		List<News> list=new ArrayList<News>();
		ResultSet rs=query(sql, param);
		try {
			while(rs.next()){
				News news=new News();
				news.setHnId(rs.getLong(1));
				news.setHnTitle(rs.getString(2));
				news.setHnContent(rs.getString(3));
				news.setHnCreateTime(rs.getDate(4));
				list.add(news);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return list;
	}
	
	public News getNewsById(News news) {
		String sql="select* from hwua_news where hn_id=?";
		Object param[]={news.getHnId()};
		News news2=new News();
		ResultSet rs=query(sql, param);
		try {
			if(rs.next()){
				news2.setHnId(rs.getLong(1));
				news2.setHnTitle(rs.getString(2));
				news2.setHnContent(rs.getString(3));
				news2.setHnCreateTime(rs.getDate(4));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return news2;
	
	}

}
