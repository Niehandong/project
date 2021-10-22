package com.cy.store.test;

import com.cy.store.contorller.CartController;
import com.cy.store.entity.Cart;
import com.cy.store.entity.User;
import com.cy.store.mapper.CartMapper;
import com.cy.store.service.CartService;
import com.cy.store.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartTest {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartService cartService;
    private CartController cartController;

    @Test
    public void test01(){
//        Cart c = new Cart();
//        c.setUid(8);
//        c.setNum(2);
//        c.setPrice(1000l);
//        c.setPid(10000006);
//        cartMapper.insert(c);

//cartMapper.updateNumByCid(1,3,"管理员",new Date());
        Cart b = cartMapper.findByUidAndPid(8, 10000006);
        System.out.println(b);
    }

    @Test
    public void test02(){
//        cartService.addToCart(8,10000009,5,"小张");
        List<CartVO> voByUid = cartMapper.findVOByUid(8);
        for (CartVO u:voByUid){
            System.out.println(u);
        }
        }
        @Test
    public void test03(){
            Cart byCid = cartMapper.findByCid(1);
            System.out.println(byCid);
    }
    @Test
    public void test04(){
//        cartMapper.deleteByCid(5);
//        System.out.println("执行结束");
        Integer[] cids={1,2,3,4,56,7,8,9};
//        System.out.println(cartService.getVoByCid(8,cids));

    }
}
