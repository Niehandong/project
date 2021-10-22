package com.oracleoaec.test;

import java.util.Date;

import com.oracleoaec.biz.IUserBiz;
import com.oracleoaec.bizimpl.UserBizImpl;
import com.oracleoaec.pojo.HwuaUser;

public class TestUser {
	public static void main(String[] args) {
		IUserBiz userBiz=new UserBizImpl();	
		System.out.println("-------测试保存操作--------");
//		HwuaUser user=new HwuaUser();
//		user.setAddress("武汉");		
//		user.setPassword("yangxiaoye");
//		user.setBirthday(new Date());
//		user.setEmail("hong@qq.com");
//		user.setUserName("xiaoye");
//		user.setSex("男");
//		user.setIdentityCode("234563");
//		user.setMobile("12345678901");
//		user.setStatus(1);
//		int save=userBiz.saveUser(user);
		//System.out.println("---保存成功---"+save);
		
		//测试登陆：即验证用户名和密码
//		System.out.println("----测试登陆：即验证用户名和密码----");
//		String username="朱琦";
//		String password="1234";
//		HwuaUser user=userBiz.Login(username, password);
//		System.out.println(user);
//		System.out.println("------登陆验证成功-----");
		
		//查询用户名是否已存在		
//		String username="xiaoye";
//		Long id=userBiz.checkName(username);
//		System.out.println("---用户名验证成功---"+id);
		
		//查询邮箱是否已注册
//		String email="hong@qq.com";
//		Long id=userBiz.checkEmail(email);
//		System.out.println("---邮箱验证成功---"+id);
		
		//测试根据用户名和邮箱找回密码
		String userName="xiaoye";
		String  email="hong@qq.com";
		HwuaUser user=userBiz.getPassword(userName, email);
		System.out.println(user);
		
	}
}
