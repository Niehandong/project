package com.example.monkeyshop.service.impl;

import com.example.monkeyshop.mapper.UserMapper;
import com.example.monkeyshop.pojo.User;
import com.example.monkeyshop.service.UserService;
import com.example.monkeyshop.service.ex.*;
import com.example.monkeyshop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    /**
     * 注册功能
     */
    @Autowired
    UserMapper userMapper;
    @Override
    public void reg(User user) {
        String userId = user.getUserId();
        //查询账号是否重复
        User result = userMapper.findusername(userId);
        //判断账号的查询结果是否为空
        if (result != null){
            throw new UsernameDuplicatedException("尝试注册的用户名["+userId+"]已经被占用");
        }
        //将数据存入到user对象中
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format1 = format.format(date);
        user.setUserCurrent(format1);
        user.setUserUpdate(format1);
        user.setIsAdminLogin(0);
        user.setUserStatus(0);
        //向数据库插入一条数据
        Integer row = userMapper.insert(user);
        //判断插入是否成功
        if (row != 1){
            throw new InsertException("添加用户数据出现未知问题，请联系管理员");
        }

    }

    /**
     * 登录功能
     * @param userId
     * @param userPassword
     * @return
     */
    @Override
    public User login(String userId, String userPassword) {
        //查询账号是否重复
        User result = userMapper.login(userId,userPassword);
//        System.out.println("UserServiceImpl:"+result);
        //判断账号的查询结果是否为空
        if (result == null){
            throw new UserNotFoundException("账号或者密码不正确");
        }
        return result;
    }

    //根据账号查找对应的用户信息
    @Override
    public User findByUserId(String userId) {
        User byUserId = userMapper.findByUserId(userId);
        if (byUserId == null){
            throw new UsernameDuplicatedException("用户名异常");
        }
        return byUserId;
    }

    //将用户信息记录更新到数据库中
    @Override
    public void userUpdate(User user) {
        if (user.getUserName().equals("")){
            user.setUserName(null);
        }
        if (user.getUserSex().equals("")){
            user.setUserSex(null);
        }
        if (user.getUserAddress().equals("")){
            user.setUserAddress(null);
        }
        if (user.getUserBirthday().equals("")){
            user.setUserBirthday(null);
        }
        if (user.getUserEmail().equals("")){
            user.setUserEmail(null);
        }
        if (user.getUserMobile().equals("")){
            user.setUserMobile(null);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setUserUpdate(simpleDateFormat.format(new Date()));
        Integer row = userMapper.userUpdate(user);
        if (row ==null){
            throw new UpdateException("修改数据库异常");
        }
    }

    @Override
    public List<User> findAll(String keyword) {

//        Integer totalCount = userMapper.totalPage(keyword);
//        page.setTotalCount(totalCount);
        List<User> result = userMapper.findAll();
        return result;
    }

    @Override
    public void delById(Integer userId) {
        Integer row = userMapper.delById(userId);
        if (row == null){
            throw new DeleteException("删除失败，过程中出现异常");
        }
    }

    @Override
    public User findById(Integer id) {
        User result = userMapper.findById(id);

        if (result == null){
            throw new UserNotFoundException("用户查找异常");
        }
        return result;
    }
}
