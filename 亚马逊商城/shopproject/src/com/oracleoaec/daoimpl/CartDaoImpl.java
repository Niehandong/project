package com.oracleoaec.daoimpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.ICartDao;
import com.oracleoaec.pojo.Cart;
import com.tools.BaseDao;


public class CartDaoImpl extends BaseDao implements ICartDao{
	
	
	//添加购物车
	public int addCart(Cart cart) {
		
		String sql="insert into hwua_cart(pid,quantity,userid) values(?,?,?)";
		Object param[]={cart.getPid(),cart.getQuantity(),cart.getUserId()};
		int total=0;
		total=update(sql, param);
		System.out.println("--添加购物车成功---"+total);
		
		close();
		return total;
	}
	
	//更新购物车
	public int updateCart(Cart cart) {		
		String sql="update hwua_cart set quantity=? where id=?";
		Object param[]={cart.getQuantity(),cart.getId()};
		int total=update(sql, param);
		System.out.println("----更新购物车成功---"+total);
		close();
		return total;
	}

	//是否已经添加到购物车
	public Cart checkCart(Cart cart) {
		String sql="select* from hwua_cart where pid=? and userId=?";
		Object param[]={cart.getPid(),cart.getUserId()};
		Cart cart2=null;
		ResultSet rs=query(sql, param);
		try {
			if(rs.next()){
				cart2=new Cart();
				System.out.println("进入到ifzhong ");
				cart2.setId(rs.getLong("id"));
				cart2.setPid(rs.getLong("pid"));
				cart2.setQuantity(rs.getLong("quantity"));
				cart2.setUserId(rs.getLong("userid"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return cart2;
	}
	
	public static void main(String[] args) {
		ICartDao dao=new CartDaoImpl();
		Cart cart=new Cart();
		Cart cart2=dao.checkCart(cart);
		System.out.println(cart2);
	}
	//查询指定用户的购物车数量
	public List<Integer> updateCartCount(Cart cart) {
		String sql="select quantity from hwua_cart where userid=?";
		Object param[]={cart.getUserId()};
		ResultSet rs=query(sql, param);
		
		List<Integer> list=new ArrayList<Integer>();
		try {
			while(rs.next()){
				Integer count=(int) rs.getLong("quantity");
				list.add(count);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return list;
	}

	//查询某个用户的所有购物车对象
	public List<Cart> usersCarts(Cart cart) {		
		String sql="select id,pid,quantity from hwua_cart where userid=?";
		Object param[]={cart.getUserId()};
		List<Cart> list=new ArrayList<Cart>();
		Cart cart2=null;
		ResultSet rs=query(sql, param);
		try {
			while(rs.next()){
				cart2=new Cart();
				cart2.setId(rs.getLong("id"));
				cart2.setPid(rs.getLong("pid"));
				cart2.setQuantity(rs.getLong("quantity"));
				list.add(cart2);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		close();
		return list;
	}

	//删除指定用户的购物车对象
	public int deleteCarts(Cart cart) {	
		String sql="delete from hwua_cart where userid=?";
		Object param[]={cart.getUserId()};
		int total=update(sql, param);
		close();
		return total;
	}

	//根据购物车ID删除购物车
	public int deleteCartById(Cart cart) {		
		String sql="delete from hwua_cart where id=?";
		Object param[]={cart.getId()};
		int total=update(sql, param);
		close();
		return total;
	}

	//修改指定产品的数量
	public int alertCartQuantity(Cart cart) {		
		String sql="update hwua_cart set quantity=? where id=?";
		Object param[]={cart.getQuantity(),cart.getId()};
		int total=update(sql, param);
		close();
		return total;
	}

}
