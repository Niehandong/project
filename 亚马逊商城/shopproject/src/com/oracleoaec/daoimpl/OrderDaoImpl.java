package com.oracleoaec.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.oracleoaec.dao.IOrderDao;
import com.oracleoaec.pojo.Order;
import com.tools.BaseDao;

public class OrderDaoImpl extends BaseDao implements IOrderDao{
	
	//添加订单
	public int addOrder(Order order) {		
		String sql="insert into hwua_order(ho_user_id,ho_user_name" +
				",ho_user_address,ho_create_time,ho_cost," +
				"ho_status,ho_type) values(?,?,?,?,?,?,?)";
		Object param[]={order.getHoUserId(),order.getHoUserName(),
				order.getHoUserAddress(),order.getHoCreateTime(),
				order.getHoCost(),order.getHoStatus(),order.getHoType()};
		int total=update(sql, param);
		close();
		return total;
	}

	//查询指定用户所有订单
	public List<Order> searchAllOrder(Order order) {		
		String sql="select* from hwua_order where ho_user_id=?";
		Object param[]={order.getHoUserId()};
		ResultSet rs=query(sql, param);
		List<Order> list=new ArrayList<Order>();
		try {
			while(rs.next()){
				Order o = new Order();
				o.setHoId(rs.getLong(1));
				o.setHoUserId(rs.getLong(2));
				o.setHoUserName(rs.getString(3));
				o.setHoUserAddress(rs.getString(4));
				o.setHoCreateTime(rs.getDate(5));
				o.setHoCost(rs.getDouble(6));
				o.setHoStatus(rs.getLong(7));
				o.setHoType(rs.getLong(8));
				list.add(o);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return list;
	}

	//查询指定Id的订单
	public Order searchOrderById(Order order) {		
		String sql="select* from hwua_order where ho_id=?";
		Object param[]={order.getHoId()};
		ResultSet rs=query(sql, param);
		try {
			if(rs.next()){
				order=new Order();
				order.setHoId(rs.getLong(1));
				order.setHoUserId(rs.getLong(2));
				order.setHoUserName(rs.getString(3));
				order.setHoUserAddress(rs.getString(4));
				order.setHoCreateTime(rs.getDate(5));
				order.setHoCost(rs.getDouble(6));
				order.setHoStatus(rs.getLong(7));
				order.setHoType(rs.getLong(8));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return order;		
	}

	//修改指定的订单状态
	public int updateOrder(Order order) {		
		String sql="update hwua_order set ho_status=? where ho_id=?";
		Object param[]={order.getHoStatus(),order.getHoId()};
		int total=update(sql, param);
		close();
		return total;
	}

	//删除指定Id的订单
	public int deleteOrder(Order order) {	
		String sql="delete from hwua_order where ho_id=?";
		Object param[]={order.getHoId()};
		int total=update(sql, param);
		close();
		return total;
	}

}
