package com.oracleoaec.test;

import java.util.List;

import com.oracleoaec.biz.ICartBiz;
import com.oracleoaec.bizimpl.CartBizImpl;
import com.oracleoaec.pojo.Cart;


public class TestCart {
	public static void main(String[] args) {
		ICartBiz cartBiz=new CartBizImpl();
//		//System.out.println("---测试添加购物车方法addToCart(Cart cart)----");
//		Cart cart=new Cart();
//		cart.setId(1L);
//		cart.setPid(1L);
//		cart.setQuantity(2L);
//		cart.setUserId(1L);
//		int total=cartBiz.addToCart(cart);
//		System.out.println("---添加购物车成功--"+total);
		
//		System.out.println("----查询指定用户的购物车数量checkCartCount(Long userId)----");
//		int total=cartBiz.checkCartCount(3L);
//		System.out.println("查询指定用户的购物车数量"+total);
		
		//System.out.println("---查询某个用户的所有购物车对象----");
//		List<Cart> list=cartBiz.usersCarts(3L);
//		for(Cart cart:list){
//			System.out.println(cart);
//		}
		
//		System.out.println("----清空购物车-----");
//		int total=cartBiz.emptyCarts(1L);
//		System.out.println("清空购物车成功"+total);
		
//		System.out.println("-----根据购物车ID删除购物车----");
//		int total=cartBiz.deleteCartById(5L);
//		System.out.println("删除购物车成功"+total);
		
//		System.out.println("-----修改指定产品的数量-----");
//		int total=cartBiz.alertCartQuantity(6L, 100L);
//		System.out.println("--修改成功--"+total);
	}
}
