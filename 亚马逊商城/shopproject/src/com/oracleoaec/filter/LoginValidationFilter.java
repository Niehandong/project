package com.oracleoaec.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginValidationFilter implements Filter {


	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//判断是否登录
		//需要强转回HttpServletRequest类型
		HttpServletRequest request=(HttpServletRequest)req;
//		getSession(boolean create)意思是返回当前reqeust中的HttpSession ，
//		如果当前reqeust中的HttpSession 为null，当create为true，就创建一个新的Session，否则返回null； 
//		简而言之： 
//		HttpServletRequest.getSession(ture)等同于 HttpServletRequest.getSession() 
//		HttpServletRequest.getSession(false)等同于 如果当前Session没有就为null； 
		HttpSession session = request.getSession(false);
		System.out.println("session:"+session);
		if(session==null ||	session.getAttribute("user")==null){
			//没登录，对不起，请去登录页面登录
			HttpServletResponse response =(HttpServletResponse)resp;			
			response.sendRedirect("login.jsp");
		}else{
			//如果已登录，放行
			chain.doFilter(req, resp);
		}
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
