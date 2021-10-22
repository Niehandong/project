package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.mapper.OrderMapper;
import com.cy.store.service.AddressService;
import com.cy.store.service.CartService;
import com.cy.store.service.OrderService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;
@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CartService cartService;

    @Override
    public Order create(Integer aid, Integer uid, String username, Integer[] cids) throws AccessDeniedException {
        List<CartVO> list = cartService.getVoByCid(uid, cids);
        Long totalPrice = 0l;
        for (CartVO c:list){
            totalPrice +=c.getRealPrice() * c.getNum();
        }
        Address address = addressService.getByAid(aid, uid);
        Order order = new Order();
        order.setUid(uid);
        order.setRecvName(address.getName());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        order.setRecvPhone(address.getPhone());
        //支付、总价、时间
        order.setStatus(0);
        order.setPayTime(new Date());
        order.setTotalPrice(totalPrice);
        order.setOrderTime(new Date());
        //日志
        order.setCreatedUser(username);
        order.setCreatedTime(new Date());
        order.setModifiedUser(username);
        order.setModifiedTime(new Date());
        //查询数据
        Integer rows = orderMapper.insertOrder(order);
        if (rows != 1){
            throw new InsertException("插入数据异常");
        }
        for (CartVO c:list){
            //创建一个订单项数据对象
            OrderItem orderItem = new OrderItem();
            orderItem.setOid(order.getOid());
            orderItem.setPid(c.getPid());
            orderItem.setTitle(c.getTitle());
            orderItem.setImage(c.getImage());
            orderItem.setPrice(c.getPrice());
            orderItem.setNum(c.getNum());
            //日志信息
            orderItem.setCreatedUser(username);
            orderItem.setCreatedTime(new Date());
            orderItem.setModifiedUser(username);
            orderItem.setModifiedTime(new Date());
            orderMapper.insertOrderItem(orderItem);
            //插入数据库操作
           rows = orderMapper.insertOrderItem(orderItem);
            if (rows != 1){
                throw new InsertException("插入数据异常");
            }
        }
        return order;
    }
}
