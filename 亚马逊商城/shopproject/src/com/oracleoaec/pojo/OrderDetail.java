package com.oracleoaec.pojo;

public class OrderDetail {
	private Long hodId;//主键
	private Long hoId;//订单主键
	private Long hpId;//商品主键
	private Long hodQuantity;
	private Double hodCost;
	
	
	
	public OrderDetail() {
		
	}



	public OrderDetail(Long hodId,Long hpId, Long hodQuantity, Double hodCost) {
		this.hodId=hodId;
		this.hpId = hpId;
		this.hodQuantity = hodQuantity;
		this.hodCost = hodCost;
	}



	public Long getHodId() {
		return hodId;
	}



	public void setHodId(Long hodId) {
		this.hodId = hodId;
	}



	public Long getHoId() {
		return hoId;
	}



	public void setHoId(Long hoId) {
		this.hoId = hoId;
	}



	public Long getHpId() {
		return hpId;
	}



	public void setHpId(Long hpId) {
		this.hpId = hpId;
	}



	public Long getHodQuantity() {
		return hodQuantity;
	}



	public void setHodQuantity(Long hodQuantity) {
		this.hodQuantity = hodQuantity;
	}



	public Double getHodCost() {
		return hodCost;
	}



	public void setHodCost(Double hodCost) {
		this.hodCost = hodCost;
	}



	@Override
	public String toString() {
		return "OrderDetail [hodId=" + hodId + ", HoId=" + hoId + ", hpId=" + hpId + ", hodQuantity=" + hodQuantity
				+ ", hodCost=" + hodCost + "]";
	}  
	
	
	
	
	
	
	
	
	
	
	
	
}
