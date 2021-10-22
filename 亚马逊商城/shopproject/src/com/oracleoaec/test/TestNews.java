package com.oracleoaec.test;

import java.util.List;

import com.oracleoaec.biz.INewsBiz;
import com.oracleoaec.bizimpl.NewsBizImpl;
import com.oracleoaec.pojo.News;

public class TestNews {
	public static void main(String[] args) {
		INewsBiz newsBiz=new NewsBizImpl();
		//测试getNews()方法
//		List<News> list=newsBiz.getNews();
//		for(News news:list){
//			System.out.println(news);
//		}
		//测试getNewsById(Long hnId)方法
//		System.out.println("---测试getNewsById(Long hnId)方法---");
//		News news=newsBiz.getNewsById(1L);
//		System.out.println(news);
	}
}
