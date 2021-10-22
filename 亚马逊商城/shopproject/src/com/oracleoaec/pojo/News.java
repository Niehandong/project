package com.oracleoaec.pojo;

import java.io.Serializable;
import java.sql.Date;

public class News implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private Long hnId;
	private String hnTitle;
	private String hnContent;
	private Date hnCreateTime;
	
	public News() {
		
	}

	
	
	public News(Long hnId, String hnTitle, String hnContent, Date hnCreateTime) {
		this.hnId = hnId;
		this.hnTitle = hnTitle;
		this.hnContent = hnContent;
		this.hnCreateTime = hnCreateTime;
	}



	public Long getHnId() {
		return hnId;
	}

	public void setHnId(Long hnId) {
		this.hnId = hnId;
	}

	public String getHnTitle() {
		return hnTitle;
	}

	public void setHnTitle(String hnTitle) {
		this.hnTitle = hnTitle;
	}

	public String getHnContent() {
		return hnContent;
	}

	public void setHnContent(String hnContent) {
		this.hnContent = hnContent;
	}

	public Date getHnCreateTime() {
		return hnCreateTime;
	}

	public void setHnCreateTime(Date hnCreateTime) {
		this.hnCreateTime = hnCreateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
	public String toString() {
		return "News [hnId=" + hnId + ", hnTitle=" + hnTitle + ", hnContent=" + hnContent + ", hnCreateTime="
				+ hnCreateTime + "]";
	}

	
	
	
	
}
