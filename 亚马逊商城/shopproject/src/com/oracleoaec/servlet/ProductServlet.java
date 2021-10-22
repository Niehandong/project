package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.biz.ICategoryBiz;
import com.oracleoaec.biz.IProductBiz;
import com.oracleoaec.bizimpl.CategoryBizImpl;
import com.oracleoaec.bizimpl.ProductBizImpl;

import com.oracleoaec.pojo.HwuaUser;
import com.oracleoaec.pojo.Product;
import com.tools.PageModel;


public class ProductServlet extends HttpServlet {

	ICategoryBiz categoryBiz = new CategoryBizImpl();
	IProductBiz productBiz = new ProductBizImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url=req.getRequestURI();
		int index=url.lastIndexOf("/");
		String path=url.substring(index+1);
		if(path.equals("pview")){
			pview(req, resp);
		}else if(path.equals("ref")){
			ref(req,resp);
		}else if(path.equals("category")){
			query(req, resp);
		}
	}
	
	
	//根据类别查询商品
	protected void query(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("--------category--------");
		String cate = req.getParameter("cate");
		String hpcIds = req.getParameter("hpcId");
		
		//将数字类型的字符串转换成数字
		int hpcId=Integer.parseInt(hpcIds);
		
		if(cate.equals("parent")){//通过父类分类查询商品
			System.out.println("---------parent--------");
			req.setAttribute("pageModel", productBiz.pageByParentCategory(hpcId, 1, 12));
		}else if(cate.equals("child")){//通过子类分类查询商品
			System.out.println("--------child----------");
			req.setAttribute("pageModel",productBiz.pageByChildCategory(hpcId, 1, 12));
		}		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	
	//根据输入的商品名称进行模糊查询 
	protected void ref(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
System.out.println("-------分页查询的productservlet--------");
		//用于接收前端发过来的参数的PageModel对象
		PageModel<Product> model=new PageModel<Product>();
		String qname = req.getParameter("qname");
		
		 String source = req.getParameter("source");
		 String page = req.getParameter("page");
		 String cid = req.getParameter("hpcId");
		 
		 //设置按商品名称进行模糊查询的关键字
		 model.setQname(qname);
		 //设置当前页
		 int currentPage= Integer.valueOf(page);
		 model.setCurrentPage(currentPage);
		 //设置要搜索的商品的主键
		 int hpcId=Integer.valueOf(cid);
		 model.setHpcId(hpcId);
		 System.out.println("---------------------");
		 System.out.println("qname="+qname+"hpcId="+hpcId+"--"+"source="+source+"--"+"currentPage="+currentPage);
		System.out.println("--------------------");
		 if("0".equals(source)){//对全部商品进行分页查询
			 System.out.println("source=0");
			 req.setAttribute("pageModel", productBiz.allProductModel(model.getCurrentPage(), model.getPageSize()));
			 
		 }else if("1".equals(source)){//对商品，大的分类进行分页查询
			 System.out.println("source=1");
			 PageModel<Product> pageModel=productBiz.pageByParentCategory(model.getHpcId(), model.getCurrentPage(),model.getPageSize());
			 req.setAttribute("pageModel",pageModel);
		
		 }else if("2".equals(source)){//对商品，小的分类进行分页查询
			 System.out.println("source=2");
			 PageModel<Product> pageModel=productBiz.pageByChildCategory(model.getHpcId(), model.getCurrentPage(),model.getPageSize());
			 req.setAttribute("pageModel",pageModel);
			 
		 }else{//对模糊查询,进行分页查询
			 System.out.println("source=3");
			 PageModel<Product> pageModel=productBiz.queryProducts(model.getQname(), model.getCurrentPage(), model.getPageSize());
			
			 req.setAttribute("pageModel",pageModel);
		 }
		 
		 
		 req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	
	//根据商品id查询指定的商品
	protected void pview(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("-----pview------");
		//获取商品的id
				String pId = req.getParameter("pId");
				long hpId = Integer.parseInt(pId);

				// 根据id查询指定商品
				Product product = productBiz.findProductById(hpId);

				// 查找商品分类
				Object[][] allCategory = categoryBiz.getAllCategory();

				// 将商品分类保存到request中
				req.setAttribute("categoryInfo", allCategory);

				// 将Long类型的数据转换成int类型数据
				int hpcId = product.getHpcId().intValue();
				int hpcChildId = product.getHpcChildId().intValue();

				// 查询指定产品的分类:下标为0表示父级分类，下标为1表示子级分类
				String[] categoryInfo = categoryBiz.categoryForProduct(hpcId,
						hpcChildId);

				String[] categoryForProduct = new String[4];
				// 获取并保存父级分类的主键hpcId值
				categoryForProduct[0] = product.getHpcId().toString();
				// 保存父级分类的名称
				categoryForProduct[1] = categoryInfo[0];
				// 获取并保存子级分类的hpcChildId
				categoryForProduct[2] = product.getHpcChildId().toString();
				// 保存子级分类的名称
				categoryForProduct[3] = categoryInfo[1];

				for (String string : categoryForProduct) {
					System.out.println(string);
				}

				HwuaUser user = (HwuaUser) req.getSession().getAttribute("user");

				if (user != null) {// 用户已登录
					// cookie保存用户浏览产品情况 key:userid+pId value:pId
					Cookie cookieViewed = new Cookie("" + user.getUserId() + pId, pId);
					cookieViewed.setMaxAge(60 * 60 * 24 * 7);
					resp.addCookie(cookieViewed);
					
					List<Cookie> cookieList = new ArrayList<Cookie>();
					Cookie[] cookies = req.getCookies();
					if (cookies != null && cookies.length > 0) {// 获取浏览器所有的cookie
						for (Cookie cookie : cookies) {
							if (cookie.getName().startsWith("" + user.getUserId())) {
								cookieList.add(cookie);// 遍历cookie 把当前用户的cookie取出
														// 用List<Cookie>保存
								if (cookieList.size() > 5) {
									cookie.setMaxAge(0);
									;// 当前用户的cookie超过了5个，删除最早的那个
								}
							}
						}
					}

				}
				req.setAttribute("productInfo", product);
				req.setAttribute("categoryForProduct", categoryForProduct);
				req.getRequestDispatcher("product_view.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	

}
