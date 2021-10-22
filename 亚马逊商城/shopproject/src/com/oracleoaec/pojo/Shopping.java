package com.oracleoaec.pojo;

public class Shopping {
	
	private Long hcId;//购物车对象Id
	private Long hpId;//商品的ID
	private String hpFileName;//图片路径
	private String hpName;//商品名
	private Double hpPrice;//商品价格
	private Long quantity;//商品数量
	private Long hpStock;//商品的库存
	
	public Long getHpStock() {
		return hpStock;
	}


	public void setHpStock(Long hpStock) {
		this.hpStock = hpStock;
	}


	public Shopping() {
		
	}


	public Long getHpId() {
		return hpId;
	}


	public void setHpId(Long hpId) {
		this.hpId = hpId;
	}


	public Shopping(Long hcId,Long hpId,String hpFileName, String hpName,
			Double hpPrice, Long quantity,long hpStock) {
		this.hcId=hcId;
		this.hpId=hpId;
		this.hpFileName = hpFileName;
		this.hpName = hpName;
		this.hpPrice = hpPrice;
		this.quantity = quantity;
		this.hpStock=hpStock;
	}

	
	public Long getHcId() {
		return hcId;
	}


	public void setHcId(Long hcId) {
		this.hcId = hcId;
	}

	public String getHpFileName() {
		return hpFileName;
	}


	public void setHpFileName(String hpFileName) {
		this.hpFileName = hpFileName;
	}


	public String getHpName() {
		return hpName;
	}


	public void setHpName(String hpName) {
		this.hpName = hpName;
	}


	public Double getHpPrice() {
		return hpPrice;
	}


	public void setHpPrice(Double hpPrice) {
		this.hpPrice = hpPrice;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Shopping [hpFileName=" + hpFileName + ", hpName=" + hpName + ", hpPrice=" + hpPrice + ", quantity="
				+ quantity + "]";
	}
	
	
	
	
	
	
	
}
