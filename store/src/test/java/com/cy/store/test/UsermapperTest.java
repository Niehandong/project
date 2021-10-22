package com.cy.store.test;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.UserService;
import com.cy.store.service.impl.UserServiceimpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsermapperTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        User user = new User();
        user.setUsername("admin02");
        user.setPassword("123");
        userService.reg(user);
        System.out.println("----------完成----------");
    }

    @Test
    public void test02() {

        User test01 = userService.login("Test01", "123");
        System.out.println(test01);

    }

    @Test
    public void test03() {
        userMapper.updatePasswordByUid(
                9, "321", "管理员", new Date()
        );
        User byUid = userMapper.findByUid(9);
        System.out.println(byUid);
    }

    @Test
    public void test04() {
        userService.changePassword(8, "admin", "111", "123");
        System.out.println("修改成功");
    }

    @Test
    public void test05() {
        //用于修改密码输入错误的方法
//        User a = userMapper.findByUid(9);
//        System.out.println(a);
//        UserServiceimpl u = new UserServiceimpl();
//        String md5Password = u.getMD5Password(a.getPassword(), a.getSalt());
//
//        userMapper.updatePassword(a.getUid(),md5Password);
//         System.out.println("修改成功");
    }

    @Test
    public void test06() {
        User u = new User();
        u.setUid(8);
        u.setGender(1);
        u.setEmail("1578845100@qq.com");
        u.setPhone("1578845100");
        Integer integer = userMapper.updateInfoByUid(u);
        System.out.println(integer);
    }

    @Test
    public void test07() {
//        User u = new User();
//        u.setUid(9);
//        u.setGender(0);
//        u.setEmail("1578845100@qq.com");
//        u.setPhone("1578845100");
//        userService.changeInfo(9,"admin03",u);

        User u = userService.getByUid(8);
        System.out.println(u);
    }

    @Test
    public void test08() {
    userService.changeAvatar(8,"/upload/avter.png","管理员",new Date());
    }
}