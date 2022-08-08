package com.example.monkeyshop.service;

import com.example.monkeyshop.pojo.Cart;

import java.util.List;

public interface OrderService {
    //查询所有订单信息
    List<Cart> findAll();
    //查询所有没有购买的订单信息
    List<Cart> buying();
    //查询所有已购买的订单信息
    List<Cart> buyed();
}
