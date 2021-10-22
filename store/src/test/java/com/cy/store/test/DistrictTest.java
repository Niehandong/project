package com.cy.store.test;

import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.DistrictService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictTest {
    @Autowired
    public DistrictMapper districtMapper;
    @Autowired
    public DistrictService districtService;
    @Test
    public void test01(){
//        List<District> byParent = districtMapper.findByParent("110100");
////        System.out.println(byParent);
//       for (District u:byParent){
//           System.out.println(u);
//       }

        List<District> byParent = districtService.getByParent("86");
        for (District u : byParent){
            System.out.println(u);
        }
    }
    @Test
    public void test02(){
        String name = districtMapper.findNameByCode("610000");
        System.out.println(name);
    }
}
