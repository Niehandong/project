package com.oracleoaec.bizimpl;

import java.util.List;

import com.oracleoaec.biz.ICartBiz;
import com.oracleoaec.dao.ICartDao;
import com.oracleoaec.daoimpl.CartDaoImpl;
import com.oracleoaec.pojo.Cart;

public class CartBizImpl implements ICartBiz {
	ICartDao icd = new CartDaoImpl();

	//添加购物车
	public int addToCart(Cart cart) {
		//检测是否已经添加到购物车
		Cart checkCart = icd.checkCart(cart);
		System.out.println("checkcart:"+checkCart);
		if (checkCart == null){
			System.out.println("没有添加到购物车时，则进行添加到购物车");
			//没有添加到购物车时，则进行添加到购物车
			icd.addCart(cart);
		} else {
			System.out.println("已经添加到购物车时，更新购物车");
			//已经添加到购物车时，更新购物车
			checkCart.setQuantity(checkCart.getQuantity()+cart.getQuantity());
			icd.updateCart(checkCart);
		}
		
		int sum=0;
		Cart cart2=new Cart();
		cart2.setUserId(cart.getUserId());
		List<Integer> count = icd.updateCartCount(cart2);
		for (Integer i : count) {
			sum+=i;
		}
		return sum;
	}

	



	//查询指定用户的购物车数量
	public int checkCartCount(Long userId) {
		int sum=0;
		Cart cart=new Cart();
		cart.setUserId(userId);
		List<Integer> count = icd.updateCartCount(cart);
		for (Integer i : count) {
			sum+=i;
		}
		return sum;
	}



	//查询某个用户的所有购物车对象
	public List<Cart> usersCarts(Long userId) {
		Cart cart=new Cart();
		cart.setUserId(userId);
		return icd.usersCarts(cart);
	}
	

	//清空购物车
	public int emptyCarts(Long userId) {
		Cart cart=new Cart();
		cart.setUserId(userId);
		return icd.deleteCarts(cart);
	}



	//根据购物车ID删除购物车
	public int deleteCartById(Long id) {
		Cart cart=new Cart();
		cart.setId(id);
		return icd.deleteCartById(cart);
	}



	//修改指定产品的数量
	public int alertCartQuantity(Long id, Long quantity) {
		Cart cart=new Cart();
		cart.setId(id);
		cart.setQuantity(quantity);
		return icd.alertCartQuantity(cart);
	}

}
