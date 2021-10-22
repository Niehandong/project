package com.cy.store.service;

import com.cy.store.vo.CartVO;

import java.util.List;

public interface CartService {
    //将商品添加到购物车中
    void addToCart(Integer uid,Integer pid,Integer amount,String username);
    //根据uid查询所有购物车中的商品
    List<CartVO> getVoByUid(Integer uid);
    //添加用户的购物车数据数量
    Integer addNum(Integer cid,Integer uid,String username);
    //减少用户的购物车数量
    public Integer reduceNum(Integer cid, Integer uid, String username);
    //删除购物车中对应的商品
    public void delete(Integer cid);

    List<CartVO> getVoByCid(Integer uid,Integer[] cids);
}
