package com.example.monkeyshop.pojo;

public class Category {
    public Integer cateId;
    public String cateName;
    public Integer catePatentId;

    @Override
    public String toString() {
        return "Category{" +
                "cateId=" + cateId +
                ", cateName='" + cateName + '\'' +
                ", catePatentId=" + catePatentId +
                '}';
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getCatePatentId() {
        return catePatentId;
    }

    public void setCatePatentId(Integer catePatentId) {
        this.catePatentId = catePatentId;
    }

}


