package com.oracleoaec.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.ICategoryDao;
import com.oracleoaec.pojo.Category;
import com.tools.BaseDao;


public class CategoryDaoImpl extends BaseDao implements ICategoryDao{

	//查询 所有的父级目录名字
	public List<Category> parentCategory() {		
		String sql="select hpc_id,hpc_name,HPC_PARENT_ID from hwua_product_category" +
				" where hpc_id=hpc_parent_id";
		Object param[]={};
		List<Category> list=new ArrayList<Category>();
		ResultSet rs=query(sql, param);
		try {
			while(rs.next()){
				Category c = new Category();
				c.setHpcId(rs.getInt(1));
				c.setHpcName(rs.getString(2));
				c.setHpcParentId(rs.getInt(3));
				list.add(c);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return list;
	}

	//查询父级目录下的子目录名字
	public List<Category> childCategory(Category category) {		
		String sql="select hpc_id,hpc_name from hwua_product_category" +
				" where hpc_parent_id=? and hpc_id!=?";
		Object param[]={category.getHpcParentId(),category.getHpcParentId()};
		ResultSet rs=query(sql, param);
		List<Category> list=new ArrayList<Category>();
		try {
			while(rs.next()){
				Category c = new Category();
				c.setHpcId(rs.getInt(1));
				c.setHpcName(rs.getString(2));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	//查询制定id的目录名称
	public String categoryNameById(int hpc_id) {
		
		String sql="select hpc_name from hwua_product_category where hpc_id=?";
		Object param[]={hpc_id}; 
		ResultSet rs=query(sql, param);
		String hpcName="";
		try {
			if(rs.next()){
				hpcName=rs.getString(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return hpcName;
	}

}
