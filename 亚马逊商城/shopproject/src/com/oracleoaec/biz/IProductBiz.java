package com.oracleoaec.biz;



import com.oracleoaec.pojo.Product;
import com.tools.PageModel;

public interface IProductBiz {
	
	
	/**
	 * 查询指定的产品
	 * @param hpId
	 * @return
	 */
	Product findProductById(Long hpId);
	
	/**
	 * 更新库存
	 * @param hpStock
	 * @return
	 */
	int changeStock(Long hpStock,Long hpId);
	
	
	/**
	 * 根据首页情况 查询产品获取PageModel对象
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageModel<Product> allProductModel(int pageNo,int pageSize);
	
	
	/**
	 * 根据大类id 获取PageModel对象
	 * 
	 * @param parentId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageModel<Product> pageByParentCategory(int parentId,int pageNo,int pageSize);
	
	
	/**
	 * 根据小类id 获取PageModel对象
	 * @param childId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageModel<Product> pageByChildCategory(int childId,int pageNo,int pageSize);
	
	/**
	 * 根据产品名 模糊查询
	 * @param qname
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageModel<Product> queryProducts(String qname,int pageNo,int pageSize);
	
	
}
