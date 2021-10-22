package com.oracleoaec.biz;

import java.util.List;

import com.oracleoaec.pojo.Order;

public interface IOrderBiz {
	/**
	 * 添加订单
	 * @param order
	 * @return
	 */
	public int addOrder(Order order);
	
	/**
	 * 查询指定用户所有订单
	 * @return
	 */
	public List<Order> searchAllOrder(Long hoUserId);
	
	/**
	 * 查询指定Id的订单
	 * @param hoId
	 * @return
	 */
	public Order searchOrderById(Long hoId);
	
	/**
	 * 修改指定的订单状态
	 * @param eoId
	 * @param eoStatus
	 * @return
	 */
	public int updateOrder(Long hoId, Long hoStatus);
	
	/**
	 * 删除指定Id的订单
	 * @param eoId
	 * @return
	 */
	public int deleteOrder(Long hoId);
}
