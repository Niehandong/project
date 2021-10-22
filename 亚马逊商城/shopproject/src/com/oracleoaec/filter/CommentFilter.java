package com.oracleoaec.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



import com.oracleoaec.bizimpl.CommentBizImpl;
import com.oracleoaec.pojo.Comment;

public class CommentFilter implements Filter{

	public void destroy() {		
		
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//allComments()表示查看所有留言
		List<Comment> allComments = new CommentBizImpl().allComments();
		req.setAttribute("allComments", allComments);
		chain.doFilter( req, resp);
	}

	
	public void init(FilterConfig arg0) throws ServletException {
				
	}

}
