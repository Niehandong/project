package com.example.monkeyshop.Test;

import com.example.monkeyshop.pojo.Cart;
import com.example.monkeyshop.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTest {

    @Autowired
    OrderService orderService;

    @Test
    public void test01(){
        List<Cart> all = orderService.findAll();
        System.out.println(all);
    }
}
