package com.oracleoaec.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.oracleoaec.bizimpl.NewsBizImpl;
import com.oracleoaec.pojo.News;

public class Newsfilter implements Filter {


	public void destroy() {}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//获取新闻信息
		List<News> news = new NewsBizImpl().getNews();
		req.setAttribute("news", news);
		chain.doFilter(req, resp);
	}

	
	public void init(FilterConfig arg0) throws ServletException {}

   

}
