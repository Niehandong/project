package com.cy.store.test;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressmapperTest {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    public AddressService addressService;
    @Test
    public void test01(){
//        Address a = new Address();
//        a.setUid(8);
//        a.setPhone("1578845100");
//        a.setName("女朋友");
//
//        addressMapper.insert(a);
        Integer row = addressMapper.countByUid(8);
        System.out.println(row);
    }

    @Test
    public void test02(){
        Address a = new Address();
        a.setPhone("1578845100");
        a.setName("小王");

        addressService.addNewAddress(9,"管理员",a);
    }
    @Test
    public void test03(){
        List<Address> byUid = addressMapper.findByUid(8);
        for (Address u:byUid){
            System.out.println(u);
        }

    }
    @Test
    public void test04(){
//        Address byAid = addressMapper.findByAid(8);
//        System.out.println(byAid);
//        Integer integer = addressMapper.updateNonDefault(8);
//        System.out.println(integer);
        Integer integer = addressMapper.updateDefaultByAid(8, "小霸王", new Date());
        System.out.println(integer);
    }

    @Test
    public void test05() throws AccessDeniedException {
        addressService.setDefault(8,8,"管理员");
    }

    @Test
    public void test06() throws Exception {
//        addressMapper.deleteByAid(1);

//        Address lastModified = addressMapper.findLastModified(8);
//        System.out.println(lastModified);
        addressService.delete(7,8,"居委会");
    }
    @Test
    public void test07(){

    }
    }