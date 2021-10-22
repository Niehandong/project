package com.oracleoaec.pojo;
/*表示分类的表中保存了父级分类和子级分类，
 * 区别是:父级分类的hpcParentId=hpcId
 * 而子级分类的hpcParentId!=hpcId，而是指向一个父级分类的hpcId
*/
public class Category {
	private int hpcId;//主键
	private String hpcName;//类别名称
	private int hpcParentId;//父级分类主键关联
	
	
	public Category() {
		
	}


	public int getHpcId() {
		return hpcId;
	}


	public void setHpcId(int hpcId) {
		this.hpcId = hpcId;
	}


	public String getHpcName() {
		return hpcName;
	}


	public void setHpcName(String hpcName) {
		this.hpcName = hpcName;
	}


	public int getHpcParentId() {
		return hpcParentId;
	}


	public void setHpcParentId(int hpcParentId) {
		this.hpcParentId = hpcParentId;
	}


	@Override
	public String toString() {
		return "Category [hpcId=" + hpcId + ", hpcName=" + hpcName + ", hpcParentId=" + hpcParentId + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
