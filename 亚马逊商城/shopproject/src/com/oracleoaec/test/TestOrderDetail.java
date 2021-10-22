package com.oracleoaec.test;

import java.util.List;

import com.oracleoaec.biz.IOrderBiz;
import com.oracleoaec.biz.IOrderDetailBiz;
import com.oracleoaec.bizimpl.OrderBizImpl;
import com.oracleoaec.bizimpl.OrderDetailBizImpl;
import com.oracleoaec.pojo.OrderDetail;
import com.oracleoaec.pojo.Product;

public class TestOrderDetail {
	public static void main(String[] args) {
		IOrderDetailBiz orderDetailBiz=new OrderDetailBizImpl();
		
//		System.out.println("--根据订单生成订单详细表--");
//		OrderDetail detail=new OrderDetail();
//		detail.setHodCost(2345.345d);
//		detail.setHodQuantity(20L);
//		detail.setHpId(23L);
//		detail.setHoId(1L);
//		int total=orderDetailBiz.addOrderDetail(detail);
//		System.out.println("--生成订单详情成功--"+total);
		
//		System.out.println("--查询热门商品--");
//		List<Product> list=orderDetailBiz.hotProducts(4);
//		System.out.println("list.size:"+list.size());
//		for(Product product:list){
//			System.out.println(product);
//		}
		
//		System.out.println("--查询当前order表中的序列值--");
//		Long index=orderDetailBiz.getOrderId();
//		System.out.println("当前表中的最大序列值为："+index);
	}
}
