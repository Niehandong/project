package com.oracleoaec.bizimpl;

import javax.xml.registry.infomodel.User;

import com.oracleoaec.biz.IUserBiz;
import com.oracleoaec.dao.IUserDao;
import com.oracleoaec.daoimpl.UserDaoImpl;
import com.oracleoaec.pojo.HwuaUser;

public class UserBizImpl implements IUserBiz{
	IUserDao iud=new UserDaoImpl();
	
	public int saveUser(HwuaUser user) {
		return iud.saveUser(user);
	}
	
	public HwuaUser Login(String username, String password) {
		HwuaUser user=new HwuaUser();
		user.setUserName(username);
		user.setPassword(password);
		
		return iud.checkUser( user);
	}

	public Long checkName(String username) {
		
		HwuaUser user=new HwuaUser();
		user.setUserName(username);
		return iud.checkName(user);
	}
	
	public Long checkEmail(String email) {
		HwuaUser user=new HwuaUser();
		user.setEmail(email);
		return iud.checkEmail(user);
	}
	
	
	 //根据用户名，邮箱，找回忘记的密码		
	public HwuaUser getPassword(String userName,String email){
		HwuaUser user=new HwuaUser();
		user.setUserName(userName);
		user.setEmail(email);
		//返回只包含用户密码的对象
		return iud.getPassword(user);
	}
}
