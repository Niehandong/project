package com.oracleoaec.dao;

import com.oracleoaec.pojo.HwuaUser;

public interface IUserDao {
	
	/**
	 * 注册用户
	 * @param user
	 * @return 插入的行数 1 表示注册成功 0表示注册失败
	 */
	public int saveUser(HwuaUser user);
	/**
	 * 查询用户名是否已存在
	 * @param username
	 * @return 返回用户id id>0表示用户名已存在
	 */
	public long checkName(HwuaUser user);
	
	
	/**
	 * 查询邮箱是否已注册
	 * @param email
	 * @return
	 */
	public long checkEmail(HwuaUser user);
	
	
	/**
	 * 登录验证	
	 * @return 返回user用户对象
	 */
	public HwuaUser checkUser(HwuaUser user);
	
	
	/**
	 * 根据用户名，邮箱，找回忘记的密码	
	 * @return 返回user用户对象,该对象里面只保存了用户密码
	 */
	public HwuaUser getPassword(HwuaUser user);
	
}
