package com.cy.store.test;

import com.cy.store.entity.Order;
import com.cy.store.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.AccessDeniedException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTest {
   @Autowired
    private OrderService orderService;

   @Test
    public void test01() throws AccessDeniedException {
       Integer[] cids={1};
       Order order = orderService.create(8, 8, "小明", cids);
       System.out.println(order);

   }

}
