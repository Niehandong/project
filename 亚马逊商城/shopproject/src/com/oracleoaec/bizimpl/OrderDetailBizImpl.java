package com.oracleoaec.bizimpl;


import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.biz.IOrderDetailBiz;
import com.oracleoaec.biz.IProductBiz;
import com.oracleoaec.dao.IOrderDetailDao;
import com.oracleoaec.dao.IProductDao;
import com.oracleoaec.daoimpl.OrderDetailDaoImpl;
import com.oracleoaec.daoimpl.ProductDaoImpl;
import com.oracleoaec.pojo.OrderDetail;
import com.oracleoaec.pojo.Product;

public class OrderDetailBizImpl implements IOrderDetailBiz{

	IOrderDetailDao iodd=new OrderDetailDaoImpl();
	IProductDao productDao=new ProductDaoImpl();
	//根据订单生成订单详细表
	public int addOrderDetail(OrderDetail orderDetail) {
		
		return iodd.addOrderDetail(orderDetail);
	}

	//查询热门商品
	public List<Product> hotProducts(int rownum) {
		List<Long> hotPids= iodd.hotProducts(rownum);//获得热门商品id
		List<Product> list=new ArrayList<Product>();
		for (Long pid : hotPids) {
			Product product2=new Product();
			product2.setHpId(pid);
			//查询热门商品
			Product product = productDao.findProductById(product2);
			list.add(product);
		}
		return list;
	}

	//查询当前order表中的序列值
	public Long getOrderId() {
		return iodd.getOrderId();
	}
	
}
