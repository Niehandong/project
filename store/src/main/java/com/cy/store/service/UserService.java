package com.cy.store.service;

import com.cy.store.entity.User;

import java.util.Date;


public interface UserService {

    //用户注册
    void reg(User user);
    //用户登录功能
    User login(String username,String password);
    //修改密码
    void changePassword(Integer uid,String username,String oldpassword,String newpassword);
    //根据用户的id查询用户的数据
    User getByUid(Integer uid);
    //更新用户的数据操作
    void changeInfo(Integer uid,String username,User user);
    //修改用户头像
    void changeAvatar(Integer uid, String avatar, String username, Date modifiedTime);
}
