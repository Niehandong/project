package com.oracleoaec.test;

import com.oracleoaec.biz.ICategoryBiz;
import com.oracleoaec.bizimpl.CategoryBizImpl;

public class TestCategory {
	public static void main(String[] args) {
		ICategoryBiz categoryBiz=new CategoryBizImpl();
		
		System.out.println("-----查询指定产品的分类categoryForProduct------");
		String names[]=categoryBiz.categoryForProduct(2, 8);
		for(String name:names){
			System.out.println(name);
		}
		
//		System.out.println("------查询所有的分类父类和子类getAllCategory------");
//		Object obj[][]=categoryBiz.getAllCategory();
//		for(int i=0;i<obj.length;i++){
//			for(int j=0;j<obj[i].length;j++){
//				System.out.println(obj[i][j]);
//			}
//		}
	}
}
