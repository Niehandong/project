package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.biz.INewsBiz;
import com.oracleoaec.bizimpl.NewsBizImpl;
import com.oracleoaec.pojo.News;

public class NewsServlet extends HttpServlet{
	INewsBiz newsBiz=new NewsBizImpl();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取新闻信息的主键id
		String nid = req.getParameter("nid");
		Long hnId = Long.valueOf(nid);
		//根据id查询指定的新闻信息
		News news = newsBiz.getNewsById(hnId);
		//查询所有的新闻信息
		List<News> newsList = newsBiz.getNews();
		
		req.setAttribute("news", newsList);
		req.setAttribute("newsInfo", news);
		//给出响应页面
		req.getRequestDispatcher("news_view.jsp").forward(req, resp);
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	
	
	
	
	
	
}
