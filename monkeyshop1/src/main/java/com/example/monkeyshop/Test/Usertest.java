package com.example.monkeyshop.Test;

import com.example.monkeyshop.MonkeyshopApplication;
import com.example.monkeyshop.mapper.UserMapper;
import com.example.monkeyshop.pojo.User;
import com.example.monkeyshop.service.UserService;
import com.example.monkeyshop.service.impl.UserServiceImpl;
import com.example.monkeyshop.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Usertest {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Test
    public void test01(){
        User u = new User();
        u.setUserId("admin017");
        u.setUserPassword("123");
        u.setUserAddress("绍兴");
        u.setUserEmail("15788@qq.com");
        u.setUserSex("男");
        u.setUserBirthday("2021-02-03");
        u.setUserMobile("1111222555");

        userMapper.insert(u);
         System.out.println("完成");
    }
    @Test
    public void test02(){
        String username = "admin03";
        User findusername = userMapper.findusername(username);
        System.out.println(findusername);
    }
    @Test
    public void test03(){
        String username = "admin";
        String password = "33";
        User login = userMapper.login(username, password);
        System.out.println(login);

    }

    @Test
    public void test04(){
        User user = new User();
        user.setUserId("admin03");
        user.setUserPassword("33");
        user.setUserSex("男");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setUserUpdate(simpleDateFormat.format(date));
        userService.userUpdate(user);
        System.out.println("完成");
    }

    @Test
    public void test05(){
        Page p = new Page();
        p.setCurrentPage(1);
//        List<User> all = userMapper.findAll(p);
//        System.out.println(all);
        String keyword = null;
//        Integer integer = userMapper.totalPage(keyword);
//        System.out.println(integer);
        List<User> all = userService.findAll( keyword);
        System.out.println(all);

    }

    @Test
    public void test06(){
        userService.findById(33);
        System.out.println("删除完成");
    }

    @Test
    public void test07(){
        User admin = userService.findByUserId("admin");
        System.out.println(admin);
    }
}
