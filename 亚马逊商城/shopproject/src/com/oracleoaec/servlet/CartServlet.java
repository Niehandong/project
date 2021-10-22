package com.oracleoaec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.biz.ICartBiz;
import com.oracleoaec.bizimpl.CartBizImpl;
import com.oracleoaec.pojo.Cart;
import com.oracleoaec.pojo.HwuaUser;

public class CartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------CartServlet-------");
		String url=request.getRequestURI();
		System.out.println(url);
		int index=url.lastIndexOf("/");
		String path=url.substring(index+1);
		System.out.println("path:"+path);
		if(path.equals("alterQuantity")){
			alertCatQuantity(request,response);
		}else if(path.equals("addToCart")){
			addToCart(request,response);
		}else if(path.equals("deleteCart")){
			deleteCart(request,response);
		}
	}
	
	//修改购物车产品的数量
	public void alertCatQuantity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] split =  request.getQueryString().split("_");
		System.out.println("获得的ajax传递过来的字符串参数是："+request.getQueryString());
		long split1=Integer.parseInt(split[0]);
		long split2=Integer.parseInt(split[1]);
		System.out.println("split1:"+split1);
		System.out.println("split2:"+split2);
		int alertCartQuantity = new CartBizImpl().alertCartQuantity(split1, split2);
		if(alertCartQuantity>0){
			int checkCartCount = new CartBizImpl().checkCartCount(((HwuaUser)request.getSession().getAttribute("user")).getUserId());
			response.getWriter().print(checkCartCount);
			
		}
	}
	
	//添加到购物车
	public void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getQueryString();
		String[] params = param.split("_");
		Long pid = Long.valueOf(params[0]);
		HwuaUser u=(HwuaUser)request.getSession().getAttribute("user");
		
		ICartBiz icb = new CartBizImpl();
		int addToCart = icb.addToCart(new Cart(pid,Long.valueOf(params[1]), u.getUserId()));
		request.getSession().setAttribute("cartCount", addToCart);
		response.getWriter().println(addToCart);
	}
	
	//删除购物车
	public void deleteCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cartId = request.getQueryString();
		System.out.println("要删除的购物车id："+cartId);
		long cartId2=Integer.parseInt(cartId);
		 
		int deleteCartById = new CartBizImpl().deleteCartById(cartId2);
		if(deleteCartById>0){
			int checkCartCount = new CartBizImpl().checkCartCount(((HwuaUser)request.getSession().getAttribute("user")).getUserId());
			request.getSession().setAttribute("cartCount", checkCartCount);
			
			request.getRequestDispatcher("/shopping").forward(request, response);
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
