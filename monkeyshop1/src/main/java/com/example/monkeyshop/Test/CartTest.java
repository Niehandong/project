package com.example.monkeyshop.Test;

import com.example.monkeyshop.mapper.CartMapper;
import com.example.monkeyshop.pojo.Cart;
import com.example.monkeyshop.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartTest {
    @Autowired
    CartService cartService;

    @Autowired
    CartMapper cartMapper;

    @Test
    public void test01(){
        List<Cart> admin = cartService.findByUserId("admin");
        System.out.println(admin);
    }

    @Test
    public void test02(){
        Integer[] nums = new Integer[5];
        nums[0] =1;
        nums[1]=2;
        nums[2]=3;
        nums[3]=4;
//        System.out.println(Arrays.toString(nums));
        String userId = "admin";
        List<Cart> eids = cartMapper.eids(nums,userId);
        System.out.println(eids);
    }

    @Test
    public void test03(){
//        Integer[] nums = new Integer[4];
//        nums[0] =4;
//        nums[1]=6;
//        nums[2]=1;
//        nums[3]=4;
////        System.out.println(nums.length);
//        for (int i =0;i<nums.length;i++){
//            System.out.println(nums[i]);
//        }

        int[] ints = new int[0];
        if (ints.length == 0){
            System.out.println("--------------");
        }else {
            System.out.println("11111111111111");
        }
    }

    @Test
    public void test04(){
        Integer id = 18;
        Integer quantity = 1;
        String userId = "admin";
        Cart cart = cartService.goBuy(id, quantity, userId);
        System.out.println(cart);
    }

}
