package com.tools;

import java.util.ArrayList;
import java.util.List;

public class PageModel<E> {
	//这里的三个成员变量是直接赋值
	private int currentPage = 1;// 当前页
	private int pageSize = 12; // 页面容量
	private int totalCount; // 总记录数
	
	//这里的三个成员变量是 通过计算得到的
	private int totalPage; // 页数总数
	private int prePage;  //上一页
	private int nextPage;//下一页

	private List<Integer> pageList;// 页号数组

	private List<E> list; // 保存数据库中分页查出的每页的记录

	private String source;// 用于判读执行的标记属性 0表示所有产品 1表示大类产品 2表示小类产品 3表示模糊查询
	private int hpcId;// 保存商品分类的主键
	private String qname;// 保存模糊搜索的商品名

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//在设置总记录数的时候设置存放页码的集合，
		//注意：方法的调用必须是在赋值的下面,因为不赋值就得不到总页数		
		pageList = new ArrayList<Integer>();
		setPageList(pageList);
	}
	//计算获取总页数   公式： 总页数=（总记录数/页面容量）+（1）
	public int getTotalPage() {
		//return totalPage;
		if(getTotalCount()%getPageSize()==0){
			totalPage=getTotalCount()/getPageSize();
		}else{
			totalPage=getTotalCount()/getPageSize()+1;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	//设置上一页
	public int getPrePage() {
		if(getCurrentPage()<=1){
			prePage=1;
		}else{
			prePage=getCurrentPage()-1;
		}
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	
	//设置下一页
	public int getNextPage() {
		if(getCurrentPage()>=getTotalPage()){
			nextPage=getTotalPage();
		}else{
			nextPage=getCurrentPage()+1;
		}
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public List<Integer> getPageList() {
		return pageList;
	}

	// 设置页面数组
	public void setPageList(List<Integer> pageList) {
		for (int i = 0; i < getTotalPage(); i++) {
			pageList.add(i + 1);
		}
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getHpcId() {
		return hpcId;
	}

	public void setHpcId(int hpcId) {
		this.hpcId = hpcId;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

}
