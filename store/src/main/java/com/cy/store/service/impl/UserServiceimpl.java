package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.UserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    //进行用户注册
    @Override
    public void reg(User user) {
        //获取用户名
        String username = user.getUsername();
        //根据用户名查询是否被占用
        User result = userMapper.findByUsername(username);
        //判断用户名是否为空
        if (result!=null){
            //如果用户名不为空，说明用户名被占用
            throw new UsernameDuplicatedException("尝试注册的用户名["+username+"]已经被占用");
        }
        //获取网页中注册的密码
        String oldpassword = user.getPassword();
        //获取盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //补全盐值
        user.setSalt(salt);
        //获取MD5加密算法
        String md5Password = getMD5Password(oldpassword, salt);
        //将md5加密算法存入到user中
        user.setPassword(md5Password);

        //补全数据 is_delete设置成0
        user.setIsDelete(0);
        //创建用户
        user.setCreatedUser(user.getUsername());
        //修改用户
        user.setModifiedUser(user.getUsername());
        //创建时间
        Date date = new Date();
        user.setCreatedTime(date);
        //修改时间
        user.setModifiedTime(date);



        Integer row=userMapper.insert(user);
        if (row != 1){
            throw new InsertException("添加用户数据出现未知问题，请联系管理员");
        }
    }
    //根据用户名和密码进行登录
    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUsername(username);
            if (result == null){
                throw new UserNotFoundException("用户数据不存在");
            }
            //检查用户的密码是否匹配
            //获取数据库中加密后的的密码
        String oldpassword = result.getPassword();
        //先获取盐值
        String salt = result.getSalt();
        //对盐值和密码进行MD5加密算法
        String md5Password = getMD5Password(password, salt);
        //将密码进行比较
        if (!md5Password.equals(oldpassword)){
            throw new PasswordNotMatchException("用户密码错误");
        }
        //判断isdelete字段的值是否为1表示标记为删除
        if (result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }
      //调用mapper层的findByusername来查询用户的数据
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());

        return user;
    }

    //修改密码
    @Override
    public void changePassword(Integer uid, String username, String oldpassword, String newpassword) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1 ){
            throw new UserNotFoundException("用户数据不存在");
        }
        //输入的原始密码和数据库中的密码进行比较
        String oldMD5password = getMD5Password(oldpassword, result.getSalt());
        if (!result.getPassword().equals(oldMD5password)){
            throw new PasswordNotMatchException("密码错误");
        }
        //将新的密码设置到数据
        String newMD5password = getMD5Password(newpassword, result.getSalt());
        Integer row = userMapper.updatePasswordByUid(uid, newMD5password, username, new Date());
        if (row !=1){
            throw new InsertException("更新数据时产生未知的异常");
        }
    }

    //根据用户的id查询用户的数据
    @Override
    public User getByUid(Integer uid) {
        //根据uid查询所有信息
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }
        User u = new User();
        u.setPhone(result.getPhone());
        u.setEmail(result.getEmail());
        u.setGender(result.getGender());
        u.setUsername(result.getUsername());

        return u;
    }

    //更新用户的数据操作
    @Override
    public void changeInfo(Integer uid, String username, User user) {
        //根据uid查询所有信息
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }
        user.setUid(uid);
        //user.setUsername(username);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer row = userMapper.updateInfoByUid(user);
        if (row == null){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }
    //修改用户头像
    @Override
    public void changeAvatar(Integer uid, String avatar, String username, Date modifiedTime) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        Integer row = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if (row != 1){
            throw new UpdateException("更新用户头像产生未知异常");
        }

    }

    //执行md5算法
    private String getMD5Password(String password,String salt){
        for (int i=0;i<3;i++){
            //执行加密算法MD5
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
            //返回加密后的密码
             return password;
    }
}
