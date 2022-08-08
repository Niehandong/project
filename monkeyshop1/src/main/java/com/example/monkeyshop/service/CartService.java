package com.example.monkeyshop.service;

import com.example.monkeyshop.pojo.Cart;

import java.util.List;

public interface CartService {
    //将商品信息插入到数据库中
    void add(Integer id, Integer quantity, String userId);
    //根据用户名称查询对应的商品信息
    List<Cart> findByUserId(String userId);
    //对商品信息中的数量进行减少
    void subNum(Integer cartId, String userId,Integer cartQuantity);
    //对商品信息中的数量进行增加
    void addNum(Integer cartId, String userId, Integer cartQuantity);
    //根据商品id和用户名对购物车表进行删除
    void delByCartId(Integer cartId, String userId);
    //对数组进行遍历查询
    List<Cart> eids(Integer[] ids,String userId);
    //点击支付按钮，将商品进行支付
    void updataByCartId(Integer[] ids, String userId);
    //点击立即购买后，将商品信息插入到购物车列表中
    Cart goBuy(Integer id, Integer quantity, String userId);
}
