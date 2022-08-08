package com.example.monkeyshop.controller;

import com.example.monkeyshop.pojo.Cart;
import com.example.monkeyshop.service.OrderService;
import com.example.monkeyshop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController{

    @Autowired
    OrderService orderService;

    //查询所有订单信息
    @RequestMapping("/findAll")
    public JsonResult<List<Cart>> findAll(){
        List<Cart> data = orderService.findAll();
        return new JsonResult<>(OK,data);
    }
    //查询所有没有购买的订单信息
    @RequestMapping("/buying")
    public JsonResult<List<Cart>> buying(){
        List<Cart> data = orderService.buying();
        return new JsonResult<>(OK,data);
    }
    //查询所有已购买的订单信息
    @RequestMapping("/buyed")
    public JsonResult<List<Cart>> buyed(){
        List<Cart> data = orderService.buyed();
        return new JsonResult<>(OK,data);
    }

}
