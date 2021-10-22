package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.pojo.Category;

public interface ICategoryDao {
	
	/**
	 * 查询 所有的父级目录名字
	 * @return hpcName 和 hpcId
	 */
	List<Category> parentCategory();
	
	/**
	 * 查询父级目录下的子目录名字
	 * @param hpcParentId
	 * @return hpcName 和 hpcId
	 */
	List<Category> childCategory(Category category);
	
	
	/**
	 * 查询制定id的目录名称
	 * @param hpcId
	 * @return
	 */
	String categoryNameById(int hpc_id);
	
	
}
