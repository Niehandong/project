package com.example.monkeyshop.controller;

import com.example.monkeyshop.pojo.User;
import com.example.monkeyshop.service.UserService;
import com.example.monkeyshop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("user")
@RestController
public class Usercontroller extends BaseController{

    @Autowired
    UserService userService;
    //注册用户
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public JsonResult<Void> reg(User user){
//        进行注册用户的操作
      userService.reg(user);
      return new JsonResult<>(OK);
    }

    //登录用户
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult<User> login(User user){
        //进行登录操作
        User data = userService.login(user.getUserId(),user.getUserPassword());
//        System.out.println("data:"+data);
        return new JsonResult<>(OK,data);
    }

    // 根据用户名查询用户的所有信息
    @RequestMapping("/finduserId")
    public JsonResult<User> finduserId(User user){
        User data = userService.findByUserId(user.getUserId());
        System.out.println(user.getUserId());
        return new JsonResult<>(OK,data);
    }

    //更改用户信息
    @RequestMapping("/userUpdate")
    public JsonResult<Void> userUpdate(User user){
        System.out.println(user);
        userService.userUpdate(user);
        return new JsonResult<>(OK);
    }

    //查询所有用户的信息
    @RequestMapping("findAll")
    public JsonResult<List<User>> findAll(String keyword){
        List<User> data = userService.findAll(keyword);
        return new JsonResult<List<User>>(OK,data);
    }

    //根据id删除对应的用户信息
    @RequestMapping("/del")
    public JsonResult<Void> delById(User user){
        userService.delById(user.getId());
        return new JsonResult<>(OK);
    }
    //根据用户id查询对应的信息
    @RequestMapping("/findById")
    public JsonResult<User> findById(Integer id){
        User data = userService.findById(id);
        return new JsonResult<>(OK,data);
    }

}
