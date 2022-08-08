package com.example.monkeyshop.service.ex;

import com.example.monkeyshop.mapper.CartMapper;
import com.example.monkeyshop.pojo.Cart;
import com.example.monkeyshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public List<Cart> findAll() {
        List<Cart> result = cartMapper.findAll();
        if (result == null){
            throw new OrderNotFoundException("订单信息查询异常，请联系管理员");
        }
        return result;
    }

    //查询所有没有购买的订单信息
    @Override
    public List<Cart> buying() {
        List<Cart> result = cartMapper.buying();
        if (result == null){
            throw new OrderNotFoundException("订单信息查询异常，请联系管理员");
        }
        return result;
    }
    //查询所有已购买的订单信息
    @Override
    public List<Cart> buyed() {
        List<Cart> result = cartMapper.buyed();
        if (result == null){
            throw new OrderNotFoundException("订单信息查询异常，请联系管理员");
        }
        return result;
    }
}
