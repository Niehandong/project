package com.oracleoaec.bizimpl;



import java.util.List;

import com.oracleoaec.biz.ICategoryBiz;
import com.oracleoaec.dao.ICategoryDao;
import com.oracleoaec.daoimpl.CategoryDaoImpl;
import com.oracleoaec.pojo.Category;


public class CategoryBizImpl implements ICategoryBiz{
	ICategoryDao icd=new CategoryDaoImpl();
	
	//查询指定产品的分类
	public String[] categoryForProduct(int hpcId, int hpcChildId) {
		String[] strs=new String[2];
		//获取父级分类		
		strs[0]=icd.categoryNameById(hpcId);
		
		//获取子级分类		
		strs[1]=icd.categoryNameById(hpcChildId);
		return strs;
	}
	
	//查询所有的分类:父类和子类
	public Object[][] getAllCategory() {
		
		//list里面保存的是所有的父分类
		List<Category> list = icd.parentCategory();		
		
		Object[][] obj=new Object[list.size()][2];		
		
		for (int i = 0; i < list.size(); i++) {
			Category category=list.get(i);
			//obj[i][0]中保存的是所有的父级分类
			obj[i][0]=category;
			//根据父级分类去查询出所有的子级分类，并保存在对应下标为i的obj[i][1]中，
			//实际保存的是一个表示子级分类的list集合
			obj[i][1]=icd.childCategory(category);			
		}
		
		return obj;
	}
	
}
