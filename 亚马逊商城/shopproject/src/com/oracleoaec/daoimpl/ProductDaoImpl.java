package com.oracleoaec.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.IProductDao;
import com.oracleoaec.pojo.Product;
import com.tools.BaseDao;


public class ProductDaoImpl extends BaseDao implements IProductDao{
	
	//查询指定行范围的商品	 
	public List<Product> findProducts(final int currentPage,final int pageSize){		
		String sql="select hp_id,hp_name,hp_price,hp_file_name"+
					" from hwua_product"+
					" order by hp_id"+
					" limit ?,?";
		int start=(currentPage-1)*pageSize;//设置起始位置
		Object param[]={start,pageSize};
		List<Product> list=new ArrayList<Product>();
		ResultSet rs=query(sql, param);
		try {
			while(rs.next()){
				Product product=new Product();
				product.setHpId(rs.getLong("hp_id"));				
				product.setHpName(rs.getString("hp_name"));
				product.setHpPrice((double)rs.getLong("hp_price"));
				product.setHpFileName(rs.getString("hp_file_name"));
				list.add(product);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		close();
		return list;
	}

   
	//通过id查询指定的商品
	public Product findProductById(Product product) {
		
		String sql="select* from hwua_product where hp_id=?";
		Object param[]={product.getHpId()};
		ResultSet rs=query(sql, param);
		Product p=new Product();
		try {
			if(rs.next()){
				p.setHpId(rs.getLong(1));
				p.setHpName(rs.getString(2));
				p.setHpDescription(rs.getString(3));
				p.setHpPrice(rs.getDouble(4));
				p.setHpStock(rs.getLong(5));
				p.setHpcId(rs.getLong(6));
				p.setHpcChildId(rs.getLong(7));
				p.setHpFileName(rs.getString(8));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return p;		
	}
	
	//根据某一父级目录查询产品
	// 查询指定行范围的商品
	public List<Product> productByParentCategory(Product product,int currentPage,int pageSize) {
		String sql="select HP_ID,HP_NAME,HP_PRICE,HP_FILE_NAME"+
					" from hwua_product"+
					" where hpc_id=?"+
					" limit ?,?";
		int start=(currentPage-1)*pageSize;
		
		Object param[]={product.getHpcId(),start,pageSize};
		ResultSet rs=query(sql, param);
		List<Product> list=new ArrayList<Product>();
		try {
			while(rs.next()){
				Product p = new Product();
				p.setHpId(rs.getLong("HP_ID"));
				p.setHpName(rs.getString("HP_NAME"));
				p.setHpPrice(rs.getDouble("HP_PRICE"));
				p.setHpFileName(rs.getString("HP_FILE_NAME"));
				list.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 	
		close();
		return list;
	}
	
	//根据某一子级目录查询产品
	//查询指定行范围的商品
	public List<Product> productByChildCategory(Product product,int currentPage,int pageSize) {
		String sql="select HP_ID,HP_NAME,HP_PRICE,HP_FILE_NAME"+
					" from hwua_product"+
					" where hpc_child_id=?"+
					" limit ?,?";
		int start=(currentPage-1)*pageSize;
		
		Object param[]={product.getHpcChildId(),start,pageSize};
		ResultSet rs=query(sql, param);
		List<Product> list=new ArrayList<Product>();
		try {
			while(rs.next()){
				Product p = new Product();
				p.setHpId(rs.getLong("HP_ID"));
				p.setHpName(rs.getString("HP_NAME"));
				p.setHpPrice(rs.getDouble("HP_PRICE"));
				p.setHpFileName(rs.getString("HP_FILE_NAME"));
				list.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return list;		
	}
	
	//更新指定产品库存
	public int changeStock(Product product) {			
		String sql="update hwua_product set hp_stock=? where hp_id=?";
		Object param[]={product.getHpStock(),product.getHpId()};
		int total=update(sql, param);
		close();
		return total;		
	}
	
	
	//查询所有商品总数
	public int findProducts() {	
		String sql="select count(hp_id) from hwua_product";
		Object param[]={};
		ResultSet rs=query(sql, param);
		int count=0;
		try {
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return count;
	}
	
	//指定父级目录产品数量
	public int productByParentCategory(Product product) {
		String sql="select count(hp_id) from hwua_product where hpc_id=?";
		Object param[]={product.getHpcId()};
		ResultSet rs=query(sql, param);
		int count=0;
		try {
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		close();
		return count;
	}
	
	//指定子级目录商品数量
	public int productByChildCategory(Product product) {	
		String sql="select count(hp_id) from hwua_product where hpc_child_id=?";
		Object param[]={product.getHpcChildId()};
		ResultSet rs=query(sql, param);
		int count=0;
		try {
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return count;
	
	}
	
	//根据商品名模糊查询产品
	public List<Product> queryProducts(String qname,int currentPage,int pageSize) {
		String sql="select HP_ID,HP_NAME,HP_PRICE,HP_FILE_NAME"+
					" FROM HWUA_PRODUCT"+
					" WHERE HP_NAME LIKE concat('%',?,'%')"+
					" limit ?,?";
		int start=(currentPage-1)*pageSize;
		Object param[]={qname,start,pageSize};
		
		List<Product> list=new ArrayList<Product>();
		
		ResultSet rs=query(sql, param);
		try {
			while(rs.next()){
				Product p = new Product();
				p.setHpId(rs.getLong("HP_ID"));
				p.setHpName(rs.getString("HP_NAME"));
				p.setHpPrice(rs.getDouble("HP_PRICE"));
				p.setHpFileName(rs.getString("HP_FILE_NAME"));
				list.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return list;
	}
	
	//根据商品名模糊查询产品数量
	public int countQueryProducts(String qname) {
		String sql="select count(hp_id) from hwua_product where hp_name like ?";
		Object param[]={"%"+qname+"%"};
		int count=0;
		ResultSet rs=query(sql, param);
		try {
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return count;
		
	}
}





 














