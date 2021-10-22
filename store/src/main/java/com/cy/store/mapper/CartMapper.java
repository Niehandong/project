package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;

import java.util.Date;
import java.util.List;

public interface CartMapper {
   //插入购物车数据
    Integer insert(Cart cart);
    //根据id更新商品数量
    Integer updateNumByCid(
            Integer cid,
            Integer num,
            String modifiedUser,
            Date modifiedTime
    );
    //根据用户的id和商品的id来查询购物车的数据
    Cart findByUidAndPid(Integer uid,Integer pid);
    //根据uid查询购物车里面所有商品
   List<CartVO> findVOByUid(Integer uid);
   //根据cid查询所有商品
    Cart findByCid(Integer cid);
    //根据cid删除对应的商品
    void deleteByCid(Integer cid);
    //
    List<CartVO> findVOByCid(Integer[] cids);
}
