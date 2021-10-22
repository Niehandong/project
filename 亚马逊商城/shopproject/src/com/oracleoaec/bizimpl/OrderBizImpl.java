package com.oracleoaec.bizimpl;

import java.util.List;

import com.oracleoaec.biz.IOrderBiz;
import com.oracleoaec.dao.IOrderDao;
import com.oracleoaec.daoimpl.OrderDaoImpl;
import com.oracleoaec.pojo.Order;

public class OrderBizImpl implements IOrderBiz{
	
	private IOrderDao iod=new OrderDaoImpl();
	
	//添加订单
	public int addOrder(Order order) {
		
		return iod.addOrder(order);
	}

	//查询指定用户所有订单
	public List<Order> searchAllOrder(Long hoUserId) {
		Order order=new Order();
		order.setHoUserId(hoUserId);
		return iod.searchAllOrder(order);
	}

	//查询指定Id的订单
	public Order searchOrderById(Long hoId) {
		Order order=new Order();
		order.setHoId(hoId);
		return iod.searchOrderById(order);
	}

	//修改指定的订单状态
	public int updateOrder(Long hoId, Long hoStatus) {
		Order order=new Order();
		order.setHoId(hoId);
		order.setHoStatus(hoStatus);
		return iod.updateOrder(order);
	}

	//删除指定Id的订单
	public int deleteOrder(Long hoId) {
		Order order=new Order();
		order.setHoId(hoId);
		return iod.deleteOrder(order);
	}

}
