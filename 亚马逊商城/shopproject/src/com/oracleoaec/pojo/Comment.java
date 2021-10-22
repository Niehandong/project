package com.oracleoaec.pojo;

import java.util.Date;

/*
 * 表示客户留言
 * */
public class Comment {
	private Long hcId;//主键
	private String hcReply;
	private String hcContent;
	private Date hcCreateTime;
	private Date hcReplyTime;
	private String hcNickName;
	private String hcState;
	
	
	public Comment() {
		
	}


	public Comment(String hcContent, Date hcCreateTime, String hcNickName) {
		
		this.hcContent = hcContent;
		this.hcCreateTime = hcCreateTime;
		this.hcNickName = hcNickName;
	}


	public Long getHcId() {
		return hcId;
	}


	public void setHcId(Long hcId) {
		this.hcId = hcId;
	}


	public String getHcReply() {
		return hcReply;
	}


	public void setHcReply(String hcReply) {
		this.hcReply = hcReply;
	}


	public String getHcContent() {
		return hcContent;
	}


	public void setHcContent(String hcContent) {
		this.hcContent = hcContent;
	}


	public Date getHcCreateTime() {
		return hcCreateTime;
	}


	public void setHcCreateTime(Date hcCreateTime) {
		this.hcCreateTime = hcCreateTime;
	}


	public Date getHcReplyTime() {
		return hcReplyTime;
	}


	public void setHcReplyTime(Date hcReplyTime) {
		this.hcReplyTime = hcReplyTime;
	}


	public String getHcNickName() {
		return hcNickName;
	}


	public void setHcNickName(String hcNickName) {
		this.hcNickName = hcNickName;
	}


	public String getHcState() {
		return hcState;
	}


	public void setHcState(String hcState) {
		this.hcState = hcState;
	}


	
	public String toString() {
		return "Comment [hcId=" + hcId + ", hcReply=" + hcReply + ", hcContent=" + hcContent + ", hcCreateTime="
				+ hcCreateTime + ", hcReplyTime=" + hcReplyTime + ", hcNickName=" + hcNickName + ", hcState=" + hcState
				+ "]";
	}
	
	
	
}
