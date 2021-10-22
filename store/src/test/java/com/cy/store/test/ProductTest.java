package com.cy.store.test;

import com.cy.store.entity.Product;
import com.cy.store.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test01(){
        List<Product> hotList = productMapper.findGoodList();
        for (Product u:hotList){
            System.out.println(u);
        }
    }
}
