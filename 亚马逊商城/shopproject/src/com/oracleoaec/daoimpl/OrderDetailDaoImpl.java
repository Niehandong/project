package com.oracleoaec.daoimpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.IOrderDetailDao;
import com.oracleoaec.pojo.OrderDetail;
import com.tools.BaseDao;


public class OrderDetailDaoImpl extends BaseDao implements IOrderDetailDao{


	
	//根据订单生成订单详细表
	public int addOrderDetail(OrderDetail orderDetail) {
		String sql="insert into hwua_order_detail(ho_id,hp_id,hod_quantity,hod_cost) " +
				   " values(?,?,?,?)";
		Object param[]={orderDetail.getHoId(),orderDetail.getHpId(),
						orderDetail.getHodQuantity(),orderDetail.getHodCost()};
		int total=0;
		total=update(sql, param);
		close();
		return total;
	}

	//查询热门商品id,用出售的产品数量最多的几个商品表示热门商品
	public List<Long>  hotProducts(int rownum) {		
		String sql="SELECT t.HP_ID "
					+" FROM ("
					+" SELECT  HP_ID,sum(hod_quantity) AS TIMES"
					+" FROM HWUA_ORDER_DETAIL GROUP BY HP_ID "
					+" ORDER BY TIMES  DESC) t"
					+" LIMIT ?"; 
		System.out.println("rownum的值为："+rownum);
		
		Object param[]={rownum};
		ResultSet rs=query(sql, param);
		System.out.println("rs:"+rs);
		List<Long> list=new ArrayList<Long>();
		try {
			while(rs.next()){
				Long index=rs.getLong(1);
				list.add(index);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		close();
		return list;
	}	
	
	//查询当前order表中的序列值
	public Long getOrderId() {
		String sql="select ho_id from hwua_order order by ho_id desc limit 1";
		Object param[]={};
		ResultSet rs=query(sql, param);
		Long index=0L;
		try {
			if(rs.next()){
				index=rs.getLong(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return index;
	}

}
