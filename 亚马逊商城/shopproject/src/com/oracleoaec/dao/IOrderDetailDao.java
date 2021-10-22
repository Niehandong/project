package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.pojo.OrderDetail;

public interface IOrderDetailDao {
	
	/**
	 * 根据订单生成订单详细表
	 * @param orderDetail
	 * @return
	 */
	int addOrderDetail(OrderDetail orderDetail);
	
	
	
	/**
	 * 查询热门商品id
	 * @param rownum 热门商品数量
	 * @return
	 */
	List<Long> hotProducts(int rownum);
	
	/**
	 * 查询当前order表中的序列值
	 * @return
	 */
	Long getOrderId();
	
}
