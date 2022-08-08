package com.example.monkeyshop.mapper;

import com.example.monkeyshop.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    //查询所有的分类信息
    List<Category> findAll();

    //查询所有父类信息
    List<Category> findAllParent();
    //插入一条分类信息到数据库
    Integer insert(Category category);

    Integer del(@Param("cateId") Integer cateId);

    Integer updateById(Category category);

    Category findById(@Param("cateId") Integer cateId);
}
