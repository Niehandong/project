package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.pojo.Cart;

public interface ICartDao {
	/**
	 * 添加购物车
	 * @param cart
	 * @return
	 */
	public int addCart(Cart cart);
	
	/**
	 * 更新购物车 
	 * @param cart
	 * @return
	 */
	public int updateCart(Cart cart);
	
	
	/**
	 * 是否已经添加到购物车
	 * @param cart pid userid
	 * @return
	 */
	public Cart checkCart(Cart cart);
	
	public List<Integer> updateCartCount(Cart cart);
	
	
	/**
	 * 查询某个用户的所有购物车对象
	 * @param userId
	 * @return
	 */
	public List<Cart> usersCarts(Cart cart);
	
	
	/**
	 * 删除指定用户的购物车对象
	 * @param userId
	 * @return
	 */
	public int deleteCarts(Cart cart);
	
	/**
	 * 根据购物车ID删除购物车
	 * 
	 * @param ID
	 * @return
	 */
	public int deleteCartById(Cart cart);
	
	
	
	
	
	/**
	 * 修改指定产品的数量
	 * @param id
	 * @param quantity
	 * @return
	 */
	public int alertCartQuantity(Cart cart);
	
	
	
	
	
	
	
}
