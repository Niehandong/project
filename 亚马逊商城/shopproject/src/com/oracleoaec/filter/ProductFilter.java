package com.oracleoaec.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.oracleoaec.biz.ICategoryBiz;
import com.oracleoaec.biz.INewsBiz;
import com.oracleoaec.biz.IOrderDetailBiz;
import com.oracleoaec.biz.IProductBiz;
import com.oracleoaec.bizimpl.CategoryBizImpl;
import com.oracleoaec.bizimpl.NewsBizImpl;
import com.oracleoaec.bizimpl.OrderDetailBizImpl;
import com.oracleoaec.bizimpl.ProductBizImpl;

import com.oracleoaec.pojo.News;
import com.oracleoaec.pojo.Product;
import com.tools.PageModel;

public class ProductFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//查找商品
		IProductBiz productBiz=new ProductBizImpl();		
		PageModel<Product> pageModel =productBiz.allProductModel(1, 12);
		List<Product> list=pageModel.getList();
	
		//查找新闻信息
		INewsBiz newsBiz=new NewsBizImpl();
		List<News> news =newsBiz.getNews();		
		
		//查找热门商品
		IOrderDetailBiz orderDetailBiz=new OrderDetailBizImpl();
		List<Product> hotProducts =orderDetailBiz.hotProducts(6);
		
		//查找商品分类
		ICategoryBiz categoryBiz=new CategoryBizImpl();
		Object[][] allCategory =categoryBiz.getAllCategory();
		
		//将查找出来的信息保存到request内置对象中
		req.setAttribute("pageModel", pageModel);
		req.setAttribute("news", news);
		req.setAttribute("categoryInfo", allCategory);
		req.setAttribute("hotProducts", hotProducts);
		
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {	
		
	}

	

}
