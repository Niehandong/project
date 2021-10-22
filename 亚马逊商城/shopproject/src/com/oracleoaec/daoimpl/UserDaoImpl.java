package com.oracleoaec.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracleoaec.dao.IUserDao;
import com.oracleoaec.pojo.HwuaUser;
import com.tools.BaseDao;

public class UserDaoImpl extends BaseDao implements IUserDao {

	// 保存用户
	public int saveUser(HwuaUser user) {
		String sql = "insert into hwua_user(hu_user_name,hu_password,hu_sex,hu_birthday,"
				+ "hu_identity_code,hu_email,hu_mobile,hu_address,hu_status)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		Object param[] = { user.getUserName(), user.getPassword(),
				user.getSex(), user.getBirthday(), user.getIdentityCode(),
				user.getEmail(), user.getMobile(), user.getAddress(),
				1 };
		// 执行插入操作
		int total = update(sql, param);
		close();
		return total;
	}

	// 检查用户名是否存在
	public long checkName(HwuaUser user) {
		long id = 0L;
		String sql = "select hu_user_id from hwua_user where hu_user_name=?";
		Object param[] = { user.getUserName() };
		ResultSet rs = query(sql, param);
		try {
			while (rs.next()) {
				id = rs.getLong(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		close();
		return id;
	}

	// 登录验证，返回HwuaUser对象
	public HwuaUser checkUser(HwuaUser user) {
		String sql = "select* from hwua_user where hu_user_name=? and hu_password=?";
		Object param[] = {user.getUserName(), user.getPassword() };
		ResultSet rs = query(sql, param);
		System.out.println(rs);
		HwuaUser user2 = null;
		try {
			if (rs.next()) {	
				user2=new HwuaUser();
				user2.setUserId(rs.getLong(1));			
				user2.setUserName(rs.getString("hu_user_name"));
				user2.setAddress(rs.getString("hu_address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return user2;
	}
	
	// 查询邮箱是否已注册
	public long checkEmail(HwuaUser user) {
		long id = 0L;
		String sql = "select hu_user_id from hwua_user where hu_email=?";
		Object param[] = { user.getEmail() };
		ResultSet rs = query(sql, param);
		try {
			if (rs.next()) {
				id = rs.getLong(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		close();
		return id;
	}
	
	//根据用户名,邮箱，找回忘记的密码
	public HwuaUser getPassword(HwuaUser user){
		String sql="select* from hwua_user where hu_user_name=? and hu_email=?";
		Object params[]={user.getUserName(),user.getEmail()};
		ResultSet rs=query(sql, params);
		HwuaUser user2=null;
		try {
			if(rs.next()){
				user2=new HwuaUser();
				user2.setPassword(rs.getString("hu_password"));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		close();
		return user2;
	}
}
