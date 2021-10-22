package com.cy.store.mapper;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

//订单的持久层接口
public interface OrderMapper {
    //插入订单数据
    Integer insertOrder(Order order);
    //插入订单项的数据
    Integer insertOrderItem(OrderItem orderItem);

}
