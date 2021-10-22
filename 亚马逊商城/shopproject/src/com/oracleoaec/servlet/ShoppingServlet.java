package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.biz.ICartBiz;
import com.oracleoaec.biz.IOrderBiz;
import com.oracleoaec.biz.IOrderDetailBiz;
import com.oracleoaec.biz.IProductBiz;
import com.oracleoaec.bizimpl.CartBizImpl;
import com.oracleoaec.bizimpl.OrderBizImpl;
import com.oracleoaec.bizimpl.OrderDetailBizImpl;
import com.oracleoaec.bizimpl.ProductBizImpl;
import com.oracleoaec.pojo.Cart;
import com.oracleoaec.pojo.HwuaUser;
import com.oracleoaec.pojo.Order;
import com.oracleoaec.pojo.OrderDetail;
import com.oracleoaec.pojo.OrderView;
import com.oracleoaec.pojo.Product;
import com.oracleoaec.pojo.Shopping;

public class ShoppingServlet extends HttpServlet {
	ICartBiz cartBiz = new CartBizImpl();
	IProductBiz productBiz = new ProductBizImpl();
	IOrderDetailBiz iodb = new OrderDetailBizImpl();
	IOrderBiz orderBiz = new OrderBizImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getRequestURI();
		int index = url.lastIndexOf("/");
		String path = url.substring(index + 1);
		System.out.println("path:" + path);
		if (path.equals("shopping")) {
			List<Shopping> list = getShopingList(req, resp);
			// 将集合放入request中
			req.setAttribute("shoppingList", list);
			// 给出响应页面
			req.getRequestDispatcher("shopping.jsp").forward(req, resp);
		} else if (path.equals("doBuy")) {
			doBuy(req, resp);
		} else if (path.equals("goingToBuy")) {
			goingToBuy(req, resp);
		}

	}

	// 点击立即购买时，执行的操作
	public void goingToBuy(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("------goingToBuy------");
		// 获取传递过来的参数，参数是字符串类型
		String param = req.getQueryString();
		System.out.println("param:" + param);// param:3_1
		String[] params = param.split("_"); // [3,1]
		// 获取字符串数组中的第一个值，该值表示商品的主键，并且转换成Long类型
		Long pid = Long.valueOf(params[0]);
		// 获取字符串数组中的第二个值，该值表示要购买的该商品的数量，并转换成Long类型
		Long quantity = Long.valueOf(params[1]);
		// 从session中获取用户对象
		HwuaUser u = (HwuaUser) req.getSession().getAttribute("user");
		
		// 添加购物车
		cartBiz.addToCart(new Cart(pid, quantity, u.getUserId()));
		
		//转发到查询购物车中所有商品信息的集合
		req.getRequestDispatcher("/shopping").forward(req, resp);
	}

	// 执行购买操作
	public void doBuy(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("------执行购买操作-------");
		// 获取用户信息
		HwuaUser user = (HwuaUser) req.getSession().getAttribute("user");
		// 创建订单对象并赋值
		Order order = new Order();
		order.setHoUserId(user.getUserId());
		order.setHoUserName(user.getUserName());
		order.setHoUserAddress(user.getAddress());
		order.setHoCreateTime(new Date());
		order.setHoStatus(1l);
		order.setHoType(1l);
		// 获取购物车中所有商品信息的集合
		List<Shopping> list = getShopingList(req, resp);

		Double hoCost = 0.0; // 表示订单总金额

		// 遍历购物车中所有的商品，计算出总金额，赋值给hoCost
		for (Shopping s : list) {
			hoCost = s.getHpPrice() * s.getQuantity() + hoCost;
		}

		System.out.println("订单总额:" + hoCost);
		order.setHoCost(hoCost);// 设置订单总金额
		// 添加订单，将订单详情保存到数据库中，表示购买成功
		int addOrder = orderBiz.addOrder(order);

		// 表示订单，用于在购买成功以后跳出的shopping-result.jsp页面显示购买成功以后的发货情况
		OrderView orderView = new OrderView();

		if (addOrder > 0) {// 下单成功，添加订单明细 修改商品库存
			Long orderId = iodb.getOrderId();// 获得订单的Id
			order.setHoId(orderId);
			orderView.setOder(order);// 设置订单值
			orderView.setShoppinglist(list);// 设置购买时的shoppinglist
			for (Shopping s : list) {
				// 根据订单生成订单详细表
				iodb.addOrderDetail(new OrderDetail(orderId, s.getHpId(), s
						.getQuantity(), s.getHpPrice() * s.getQuantity()));
				// 更新库存，减少库存数量
				productBiz.changeStock(s.getHpStock() - s.getQuantity(),
						s.getHpId());
			}
			// 清空指定用户对应的购物车
			cartBiz.emptyCarts(user.getUserId());

			// orders_view.jsp中会用到orderView获取订单详情
			req.getSession().setAttribute("orderView", orderView);
			// 返回到购物成功页面，三秒中后会自动跳转到orders_view.jsp页面
			resp.sendRedirect("shopping-result.jsp");
		} else {
			resp.getWriter().println("alert('下单失败！即将跳转到首页！')");
			resp.sendRedirect("index.jsp");
		}

	}

	// 查询购物车中所有商品信息的集合
	public List<Shopping> getShopingList(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("----getShopingList----");
		// 保存购物车中所有商品信息的集合
		List<Shopping> shoppingList = new ArrayList<Shopping>();

		HwuaUser user = (HwuaUser) req.getSession().getAttribute("user");
		System.out.println("id:" + user.getUserId());
		// 根据用户ID遍历购物车获得所有的购物车对象
		List<Cart> carts = cartBiz.usersCarts(user.getUserId());
		if (carts != null) {
			// 根据Cart对象的pid查询相关商品的信息
			for (Cart c : carts) {
				// 根据购物车对象中表示商品主键的pid查询出对应的商品
				Product product = productBiz.findProductById(c.getPid());
				// 将商品信息放入到Shopping对象中
				Shopping shoping = new Shopping(c.getId(), product.getHpId(),
						product.getHpFileName(), product.getHpName(),
						product.getHpPrice(), c.getQuantity(),
						product.getHpStock());
				// 将对象放入集合中
				shoppingList.add(shoping);
			}
		}
		return shoppingList;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
