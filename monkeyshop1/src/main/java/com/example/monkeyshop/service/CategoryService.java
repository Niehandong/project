package com.example.monkeyshop.service;

import com.example.monkeyshop.pojo.Cate;
import com.example.monkeyshop.pojo.Category;

public interface CategoryService {
    //查询所有分类
    Cate findAll();
    //添加分类信息
    void add(Category category);
    //根据id删除对应的信息
    void del(Integer cateId);
    //根据id修改对应的信息
    void updateById(Category category);
    //根据id查询所有的信息
    Category findById(Integer cateId);

}
