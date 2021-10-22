package com.cy.store.test;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ordermapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test01(){
        Order order = new Order();
        order.setUid(8);
        order.setRecvName("红花");
        order.setRecvPhone("123456789");
        orderMapper.insertOrder(order);
    }

    @Test
    public void test02(){
        OrderItem o = new OrderItem();
        o.setOid(1);
        o.setPid(10000004);
        o.setTitle("士大夫撒旦发射点发生");
        orderMapper.insertOrderItem(o);
    }
}