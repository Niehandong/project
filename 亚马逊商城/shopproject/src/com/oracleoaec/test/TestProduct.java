package com.oracleoaec.test;

import com.oracleoaec.biz.IProductBiz;
import com.oracleoaec.bizimpl.ProductBizImpl;

import com.oracleoaec.pojo.Product;

public class TestProduct {
	public static void main(String[] args) {
		IProductBiz productBiz=new ProductBizImpl();
//		System.out.println("-------查询指定的产品findProductById------");
//		Product product=productBiz.findProductById(2L);
//		System.out.println(product);
		
//		System.out.println("------更新库存changeStock------");
//		int total=productBiz.changeStock(20L, 1L);
//		System.out.println("total:"+total);
		
//		System.out.println("--------根据首页情况 查询产品获取PageModel对象allProductModel---------");
//		PageModel<Product> pageModel=productBiz.allProductModel(1, 10);
//		System.out.println(pageModel);
		
//		System.out.println("------根据大类id 获取PageModel对象pageByParentCategory------");
//		PageModel<Product> pageModel=productBiz.pageByParentCategory(1, 1, 10);
//		System.out.println(pageModel);
		
//		System.out.println("------根据小类id 获取PageModel对象pageByChildCategory------");
//		PageModel<Product> pageModel=productBiz.pageByChildCategory(1,1,10);
//		System.out.println(pageModel);
		
//		System.out.println("-----根据产品名 模糊查询queryProducts------");
//		PageModel<Product> pageModel=productBiz.queryProducts("上衣",1, 10);
//		System.out.println(pageModel);
	}
}
