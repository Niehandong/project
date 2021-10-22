package com.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Utils {
	private static  Properties properties;
	private static Utils utils;
	
	//实现单例模式，初始化的时候读取外面的配置文件db.properties
	private Utils(){
		try {
			properties=new Properties();
			InputStream in=this.getClass().getClassLoader()
					.getResourceAsStream("db.properties");
			properties.load(in);
			in.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	//获取单例对象
	public static Utils getInstance(){
		if(utils==null){
			utils=new Utils();
		}
		return utils;
	}
	//读取properties文件
	public String getProperties(String key){
		return properties.getProperty(key);
	}
	public static void main(String[] args) {
		Utils utils=Utils.getInstance();
		System.out.println(utils.getProperties("driver"));
	}
}
