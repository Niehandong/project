package com.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
	private Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	// 获取连接
	public boolean getConnection() {
		try {
			String driver = Utils.getInstance().getProperties("driver");
			Class.forName(driver);
			String url = Utils.getInstance().getProperties("url");
			
			String user = Utils.getInstance().getProperties("user");
			
			String password = Utils.getInstance().getProperties("password");
			
			conn = DriverManager.getConnection(url, user, password);
			//System.out.println("conn:" + conn);
		} catch (Exception e) {

			e.printStackTrace();
		}
		if(conn!=null){
			return true;
		}else{			
			return false;
		}
	}
	
	// 执行查询操作
	public ResultSet query(String sql, Object param[]) {
		try {
			if (getConnection()) {
				statement = conn.prepareStatement(sql);
				for (int i = 0; i < param.length; i++) {
					statement.setObject(i + 1, param[i]);
				}
				rs = statement.executeQuery();	
			} else {
				System.out.println("查询中的连接失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 执行添加，修改，删除操作
	public int update(String sql, Object param[]) {
		int total=0;
		try {
			if (getConnection()) {
				statement = conn.prepareStatement(sql);
				for(int i=0;i<param.length;i++){
					statement.setObject(i+1, param[i]);
				}
				total=statement.executeUpdate();
			} else {
				System.out.println("update方法中的连接失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return total;
	}

	// 关闭资源
	public void close() {
		//System.out.println("-----关闭资源------");
		try {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
