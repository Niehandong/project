package com.oracleoaec.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracleoaec.biz.ICartBiz;
import com.oracleoaec.biz.IUserBiz;
import com.oracleoaec.bizimpl.CartBizImpl;
import com.oracleoaec.bizimpl.ProductBizImpl;
import com.oracleoaec.bizimpl.UserBizImpl;
import com.oracleoaec.pojo.HwuaUser;
import com.oracleoaec.pojo.Product;

public class UserServlet extends HttpServlet {
	IUserBiz userBiz = new UserBizImpl();
	ICartBiz cartBiz = new CartBizImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getRequestURI();
		int index = url.lastIndexOf("/");
		String path = url.substring(index + 1);
		if (path.equals("login")) {
			login(req, resp);
		} else if (path.equals("quit")) {
			quit(req, resp);
		} else if (path.equals("register")) {
			register(req, resp);
		}else if(path.equals("checkEmail")){
			checkEmail(req, resp);
		}else if(path.equals("checkUserName")){
			checkUserName(req, resp);
		}else if(path.equals("retrieve_password")){
			retrievePassword(req, resp);
		}
	}
	
	//用户登录时，忘记密码，这里时找回密码的处理
	protected void retrievePassword(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("------retrievePassword-------");
		String userName=req.getParameter("userName");
		String email=req.getParameter("email");		
		String uname=req.getParameter("uname");//这里获取的真实姓名没用到
		
		//根据用户名和邮箱，找回用户密码，返回的对象中只保存了密码
		HwuaUser user=userBiz.getPassword(userName, email);
		//将结果放入request中
		req.setAttribute("user", user);
		//转发到响应页面
		req.getRequestDispatcher("back.jsp").forward(req, resp);
	}
	
	//注册时发出ajax请求，对用户名进行验证，保证用户名唯一
	protected void checkUserName(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("-----checkUserName-----");
		
		String username = req.getParameter("userName");
		System.out.println("userName="+username);
		
		Long userId = new UserBizImpl().checkName(username);
		if(userId==0){//不存在该用户名
			resp.getWriter().println(0);
		}
		else{//该用户名已经存在
			resp.getWriter().println(1);
		}
	}
	
	//注册时发出ajax请求，对邮箱进行验证，保证邮箱唯一
	protected void checkEmail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("----checkEmail------");
		String email = req.getQueryString();
		Long uid = new UserBizImpl().checkEmail(email);
		if(uid>0){
			resp.getWriter().println("1");
		}
	}
	//用户注册
	protected void register(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("------register------");
		String userName = req.getParameter("userName");
		String password = req.getParameter("passWord");
		String sex = req.getParameter("sex");
		
		String identityCode = req.getParameter("identity");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		
		//获取出生日期
		String birth=req.getParameter("birthday");
		
		//将出生日期转换成ate类型
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		try {
			birthday = format.parse(birth);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		System.out.println("birthday:"+birthday);
		
		//将注册用户的信息封装成对象
		HwuaUser user = new HwuaUser(userName, password, sex, birthday, identityCode, email, mobile, address);
		
		
		int saveUser = userBiz.saveUser(user);
		if(saveUser==1){//注册成功
			resp.sendRedirect("reg-result.jsp");
		}else{//注册失败
			resp.sendRedirect("register.jsp");
		}
	}
	
	// 用户退出
	protected void quit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("-----quit-----");
		req.getSession().invalidate();// 使session失效
		resp.sendRedirect("index.jsp");// 跳转到首页
	}

	// 登录验证
	protected void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("------login-------");
		// 获取用户名和密码
		String username = req.getParameter("userName");
		String password = req.getParameter("passWord");
		// 登录验证
		HwuaUser user = userBiz.Login(username, password);

		// 用户保存浏览过的商品的集合
		List<Product> viewedProduct = null;

		if (user == null) {// 用户没有登录
			resp.sendRedirect("login.jsp");
		} else {
			// 遍历cookie 找出最近浏览商品的pID记录
			HttpSession session = req.getSession();
			Cookie[] cookies = req.getCookies();
			List<Cookie> cookieList = null;
			if (cookies != null && cookies.length > 0) {// 取出用户的cookie
				cookieList = new ArrayList<Cookie>();
				for (Cookie cookie : cookies) {
					if (cookie.getName().startsWith("" + user.getUserId())) {
						cookieList.add(cookie);
						if (cookieList.size() > 4) {
							cookieList.remove(0);
						}
					}
				}
				if (cookieList.size() > 0) {// 存在当前用户的cookie
					viewedProduct = new ArrayList<Product>();

					for (Cookie cookie : cookieList) {
						Product product = new ProductBizImpl()
								.findProductById(Long.valueOf(cookie.getValue()));
						viewedProduct.add(product);
					}
					// 将最近浏览的商品信息的集合放入到session中，用于在index.jsp页面的最近浏览中显示
					session.setAttribute("viewedProduct", viewedProduct);
				}
			}
			// 将用户对象保存到session中
			session.setAttribute("user", user);
			// 给出登录程勇以后的响应页面
			resp.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
