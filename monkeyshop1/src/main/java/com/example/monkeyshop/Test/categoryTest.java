package com.example.monkeyshop.Test;

import com.example.monkeyshop.mapper.CategoryMapper;
import com.example.monkeyshop.pojo.Cate;
import com.example.monkeyshop.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class categoryTest {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;
    @Test
    public void test01(){

        Cate all = categoryService.findAll();


        System.out.println(all);
    }
}
