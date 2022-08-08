package com.example.monkeyshop.util;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private int currentPage;//当前页
    private int pageSize=2;//页面容量
    private int totalCount;//总记录数

    private int totalPage;//总页数
    private int prePage;//上一页
    private int nextPage;//下一页

    private List<Integer> myList;


    public List<Integer> getMyList() {
        myList=new ArrayList<Integer>();
        for (int i = 0; i < getTotalPage(); i++) {
            myList.add(i+1);
        }
        return myList;
    }
    public void setMyList(List<Integer> myList) {
        this.myList = myList;
    }
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
    }
    //计算总记录数
    public int getTotalPage() {
        if (getTotalCount()%getPageSize()==0) {//能够整除
            totalPage=getTotalCount()/getPageSize();
        }else {
            totalPage=getTotalCount()/getPageSize()+1;
        }
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    //上一页
    public int getPrePage() {
        if (getCurrentPage()==1) {
            prePage=1;
        }else {
            prePage=getCurrentPage()-1;
        }
        return prePage;
    }
    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }
    //下一页
    public int getNextPage() {
        if (getCurrentPage()==getTotalPage()) {
            nextPage=getTotalPage();
        } else {
            nextPage=getCurrentPage()+1;
        }
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    @Override
    public String toString() {
        return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize
                + ", totalCount=" + totalCount + ", totalPage=" + totalPage
                + ", prePage=" + prePage + ", nextPage=" + nextPage + "]";
    }



}
