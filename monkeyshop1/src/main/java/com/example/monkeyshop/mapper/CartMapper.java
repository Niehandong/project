package com.example.monkeyshop.mapper;

import com.example.monkeyshop.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    //根据购物车中的商品id查询数据库，获取购物车中的数据
    Cart findByPId(@Param("id") Integer id,@Param("userId") String userId);
    //向数据库插入一条数据
    Integer insert(Cart cart);

    Integer updateById(Cart cartlist);

    List<Cart> findByUserId(@Param("userId") String userId);

    Cart findByCartId(@Param("cartId") Integer cartId, @Param("userId") String userId);

    Integer delByCartId(@Param("cartId") Integer cartId, @Param("userId") String userId);

    List<Cart> eids(@Param("ids") Integer[] ids, @Param("userId") String userId);

    Integer updateByValid(@Param("cartId") Integer cartId, @Param("userId") String userId, @Param("updateTime") String updateTime);

    List<Cart> findAll();

    List<Cart> buying();

    List<Cart> buyed();
}
