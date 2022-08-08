package com.example.monkeyshop.service;

import com.example.monkeyshop.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 注册功能
     * @param user
     */
    void reg(User user);

    /**
     * 登录功能
     * @param userId
     * @param userPassword
     * @return
     */
    User login(String userId, String userPassword);

    //根据用户名查找所有的信息
    User findByUserId(String userId);

    //更新用户信息
    void userUpdate(User user);
    //查询所有用户信息
    List<User> findAll(String keyword);

    //根据用户的id删除对应的信息
    void delById(Integer userId);
    //根据id查询用户的所有信息
    User findById(Integer id);
}
