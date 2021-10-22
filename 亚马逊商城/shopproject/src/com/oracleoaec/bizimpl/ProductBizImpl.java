package com.oracleoaec.bizimpl;

import java.util.List;

import com.oracleoaec.biz.IProductBiz;
import com.oracleoaec.dao.IProductDao;
import com.oracleoaec.daoimpl.ProductDaoImpl;
import com.oracleoaec.pojo.Product;
import com.tools.PageModel;

public class ProductBizImpl implements IProductBiz {
	IProductDao ipd = new ProductDaoImpl();

	// 查询指定的产品
	public Product findProductById(Long hpId) {
		Product product = new Product();
		product.setHpId(hpId);
		return ipd.findProductById(product);
	}

	// 更新库存
	public int changeStock(Long hpStock, Long hpId) {
		Product product = new Product();
		product.setHpStock(hpStock);
		product.setHpId(hpId);
		return ipd.changeStock(product);
	}

	// 根据首页情况 查询产品获取PageModel对象 ，第一个位置表示当前页，第二个参数表示页面容量
	public PageModel<Product> allProductModel(int currentPage, int pageSize) {
		// 创建工具类PageModel对象
		PageModel<Product> model = new PageModel<Product>();

		// 这里是进行分页查询，得到一页商品的集合，第一个位置表示当前页，第二个参数表示页面容量
		List<Product> list = ipd.findProducts(currentPage, pageSize);
		// 设置查询出来的一页的商品集合
		model.setList(list);

		// 查询全部商品的总记录数
		int totalCount = ipd.findProducts();
		// 设置页面的总记录数
		model.setTotalCount(totalCount);
		// 设置当前页
		model.setCurrentPage(currentPage);

		// 设置查询的类型，即根据source的取值分类：0表示查询全部商品，1表示按照大类查询，2表示按照小类查询，3表示模糊查询
		model.setSource("0");
		// 这里不需要设置hpcId，qname，因为这里是查询全部商品，不考虑分类问题，也不考虑模糊查询问题
		return model;
	}

	// 根据大类id 获取PageModel对象
	public PageModel<Product> pageByParentCategory(int parentId,
			int currentPage, int pageSize) {
		// 创建PageModel对象
		PageModel<Product> model = new PageModel<Product>();
		// 设置查询的类型，即根据source的取值分类：0表示查询全部商品，1表示按照大类查询，2表示按照小类查询，3表示模糊查询

		Product product = new Product();
		// 注意数据的类型转换
		long hpcId = (long) parentId;
		product.setHpcId(hpcId);

		// 根据大类查询商品的总记录数
		int totalCount = ipd.productByParentCategory(product);
		System.out.println("totalCount:" + totalCount);
		// 设置商品的总记录数
		model.setTotalCount(totalCount);
		// 设置当前页
		model.setCurrentPage(currentPage);

		// 根据大类查询一页需要显示的商品的集合
		List<Product> list = ipd.productByParentCategory(product, currentPage,
				pageSize);
		// 设置根据大类查询一页需要显示的集合
		model.setList(list);
		// 这是商品的主键，用于进行大类查询
		model.setHpcId(parentId);
		// 设置查询的类型，即根据source的取值分类：0表示查询全部商品，1表示按照大类查询，2表示按照小类查询，3表示模糊查询
		model.setSource("1");

		return model;
	}

	// 根据小类id 获取PageModel对象
	public PageModel<Product> pageByChildCategory(int childId, int currentPage,
			int pageSize) {
		PageModel<Product> model = new PageModel<Product>();

		// 强制转换数据类型
		long hpcChildId = (long) childId;
		Product product = new Product();
		product.setHpcChildId(hpcChildId);

		// 查询按照小类查询的商品的总记录数
		int totalCount = ipd.productByChildCategory(product);
		// 设置按照小类查询的商品的总记录数
		model.setTotalCount(totalCount);
		// 设置当前页
		model.setCurrentPage(currentPage);

		// 按小类查询，查询一页需要显示的商品的集合
		List<Product> list = ipd.productByChildCategory(product, currentPage,
				pageSize);
		// 设置需要显示的商品的集合
		model.setList(list);

		// 设置查询的类型，即根据source的取值分类：0表示查询全部商品，1表示按照大类查询，2表示按照小类查询，3表示模糊查询
		model.setSource("2");

		// 设置小类查询的商品的主键，用于小类查询
		model.setHpcId(childId);

		return model;
	}

	// 根据产品名 模糊查询
	public PageModel<Product> queryProducts(String qname, int currentPage,
			int pageSize) {
		// 创建PageModel对象
		PageModel<Product> model = new PageModel<Product>();

		// 按模糊查询，查出商品的总记录数
		int totalCount = ipd.countQueryProducts(qname);
		model.setTotalCount(totalCount);
		// 设置当前页
		model.setCurrentPage(currentPage);

		// 按模糊查询，查出一个显示的商品的集合
		List<Product> list = ipd.queryProducts(qname, currentPage, pageSize);
		// 设置需要显示的商品的集合
		model.setList(list);

		// 设置查询的类型，即根据source的取值分类：0表示查询全部商品，1表示按照大类查询，2表示按照小类查询，3表示模糊查询
		model.setSource("3");

		// 设置按模糊查询的商品的关键字
		model.setQname(qname);

		return model;
	}

}
