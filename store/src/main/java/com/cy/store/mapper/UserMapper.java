package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface UserMapper {
    //根据账号查询所有信息
    User findByUsername(String username);
    //进行用户 注册
    Integer insert(User user);
    //修改用户密码
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);
    //根据uid查询所有数据
    User findByUid(Integer uid);
    //更新用户数据信息
    Integer updateInfoByUid(User user);
    //修改用户头像
    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser")String modifiedUser,
            @Param("modifiedTime")Date modifiedTime);
    //用于修改错误的密码
    void updatePassword(Integer uid,String password);
}
