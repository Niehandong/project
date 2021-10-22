package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.pojo.Product;

public interface IProductDao {
	
	
	
	
	/**
	 * 查询指定行范围的商品
	 * @return
	 */
	List<Product> findProducts(int start,int end);
	
	
	/**
	 * 查询商品总数
	 * @return
	 */
	int findProducts();
	
	
	Product findProductById(Product product);
	
	/**
	 * 根据某一父级目录查询产品
	 * 查询指定行范围的商品
	 * @param categoryId
	 * @return List<Product>
	 */
	List<Product> productByParentCategory(Product product,int start,int end);
	
	/**
	 * 
	 * 指定父级目录产品数量
	 * @param parentId
	 * @return
	 */
	int productByParentCategory(Product product);
	
	/**
	 * 根据某一子级目录查询产品
	 * 查询指定行范围的商品
	 * @param categoryId
	 * @return List<Product>
	 */
	List<Product> productByChildCategory(Product product,int start,int end);
	
	/**
	 * 指定子级目录商品数量
	 * @param childId
	 * @return
	 */
	int productByChildCategory(Product product);
	
	/**
	 * 更新指定产品库存
	 * @param hpStock
	 * @return
	 */
	int changeStock(Product product);
	
	/**
	 * 根据商品名模糊查询产品
	 * @param qname
	 * @return
	 */
	
	List<Product> queryProducts(String qname,int start,int end);
	
	/**
	 * 根据商品名模糊查询产品数量
	 * @param qname
	 * @return
	 */
	int countQueryProducts(String qname);
	
}
