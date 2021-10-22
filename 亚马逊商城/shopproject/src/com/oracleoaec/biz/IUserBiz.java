package com.oracleoaec.biz;

import com.oracleoaec.pojo.HwuaUser;

public interface IUserBiz {
	/**
	 * 注册，保存用户
	 * @param user
	 * @return
	 */
	int saveUser(HwuaUser user);
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	HwuaUser Login(String username,String password);
	/**
	 * 重名验证
	 * @param username
	 * @return UserId >0用户名已存在
	 */
	Long checkName(String username);
	
	/**
	 * 查询邮箱是否已注册
	 * @param email
	 * @return
	 */
	Long checkEmail(String email);
	
	/**
	 * 根据用户名，邮箱，找回忘记的密码	
	 * @return 返回user用户对象,该对象里面只保存了用户密码
	 */
	public HwuaUser getPassword(String userName,String email);
	
}
