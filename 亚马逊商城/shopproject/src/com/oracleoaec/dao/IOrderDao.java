package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.pojo.Order;

public interface IOrderDao {

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
	public List<Order> searchAllOrder(Order order);
	
	/**
	 * 查询指定Id的订单
	 * @param hoId
	 * @return
	 */
	public Order searchOrderById(Order order);
	
	/**
	 * 修改指定的订单状态
	 * @param eoId
	 * @param eoStatus
	 * @return
	 */
	public int updateOrder(Order order);
	
	/**
	 * 删除指定Id的订单
	 * @param eoId
	 * @return
	 */
	public int deleteOrder(Order order);
	
	
	
	
	
	
	
	
	
}
