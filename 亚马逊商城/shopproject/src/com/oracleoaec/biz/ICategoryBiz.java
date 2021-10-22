package com.oracleoaec.biz;


public interface ICategoryBiz {
	
	/**
	 * 查询指定产品的分类
	 * @param hpcId 产品父目录id
	 * @param hpcChildId 产品子目录id
	 * @return
	 */
	String[] categoryForProduct(int hpcId,int hpcChildId);
	
	
	/**
	 * 查询所有的分类父类和子类
	 * @return key为父目录(hpId hpName) value为子目录(hpId hpName)的Map
	 */
	Object[][] getAllCategory();
	
	
	/**
	 * 获得父级标签和子标签
	 * @param hpcId
	 * @return
	 *//*
	Object[][] getCategoryByPid(Long hpcId);
	
	
	Object[][] getCategoryByCid(Long hpcChildId);*/
	
	
	
}
