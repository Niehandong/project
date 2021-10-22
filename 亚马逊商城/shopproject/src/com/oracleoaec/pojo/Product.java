package com.oracleoaec.pojo;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 商品类
	 */
	private static final long serialVersionUID = 1L;
	private Long hpId;//主键ID
	private String hpName;//商品名
	private String hpDescription;//商品描述
	private Double hpPrice;//价格
	private Long hpStock;//库存
	private Long hpcId;//分类大类id
	private Long hpcChildId;//分类小类id
	private String hpFileName;//图片路径
	
	
	
	public Product() {
		
	}



	public Product(Long hpId, String hpName, String hpDescription, Double hpPrice, Long hpStock, Long hpcId,
			Long hpcChildId, String hpFileName) {
		
		this.hpId = hpId;
		this.hpName = hpName;
		this.hpDescription = hpDescription;
		this.hpPrice = hpPrice;
		this.hpStock = hpStock;
		this.hpcId = hpcId;
		this.hpcChildId = hpcChildId;
		this.hpFileName = hpFileName;
	}



	public Long getHpId() {
		return hpId;
	}



	public void setHpId(Long hpId) {
		this.hpId = hpId;
	}



	public String getHpName() {
		return hpName;
	}



	public void setHpName(String hpName) {
		this.hpName = hpName;
	}



	public String getHpDescription() {
		return hpDescription;
	}



	public void setHpDescription(String hpDescription) {
		this.hpDescription = hpDescription;
	}



	public Double getHpPrice() {
		return hpPrice;
	}



	public void setHpPrice(Double hpPrice) {
		this.hpPrice = hpPrice;
	}



	public Long getHpStock() {
		return hpStock;
	}



	public void setHpStock(Long hpStock) {
		this.hpStock = hpStock;
	}



	public Long getHpcId() {
		return hpcId;
	}



	public void setHpcId(Long hpcId) {
		this.hpcId = hpcId;
	}



	public Long getHpcChildId() {
		return hpcChildId;
	}



	public void setHpcChildId(Long hpcChildId) {
		this.hpcChildId = hpcChildId;
	}



	public String getHpFileName() {
		return hpFileName;
	}



	public void setHpFileName(String hpFileName) {
		this.hpFileName = hpFileName;
	}



	@Override
	public String toString() {
		return "Product [hpId=" + hpId + ", hpName=" + hpName + ", hpDescription=" + hpDescription + ", hpPrice="
				+ hpPrice + ", hpStock=" + hpStock + ", hpcId=" + hpcId + ", hpcChildId=" + hpcChildId + ", hpFileName="
				+ hpFileName + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
}
