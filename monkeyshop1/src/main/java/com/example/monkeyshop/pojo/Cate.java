package com.example.monkeyshop.pojo;

import java.util.List;

public class Cate {
    public List<Category> parent;
    public List<Category> children;

    @Override
    public String toString() {
        return "cate{" +
                "parent=" + parent +
                ", children=" + children +
                '}';
    }

    public List<Category> getParent() {
        return parent;
    }

    public void setParent(List<Category> parent) {
        this.parent = parent;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
