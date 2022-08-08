package com.example.monkeyshop.service.impl;

import com.example.monkeyshop.mapper.CategoryMapper;
import com.example.monkeyshop.mapper.UserMapper;
import com.example.monkeyshop.pojo.Cate;
import com.example.monkeyshop.pojo.Category;
import com.example.monkeyshop.service.CategoryService;
import com.example.monkeyshop.service.ex.DeleteException;
import com.example.monkeyshop.service.ex.InsertException;
import com.example.monkeyshop.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public Cate findAll() {
        Cate cate = new Cate();
        List<Category> parent = categoryMapper.findAllParent();
        List<Category> children = categoryMapper.findAll();
        cate.setChildren(children);
        cate.setParent(parent);
        return cate;
    }

    @Override
    public void add(Category category) {
        Integer row = categoryMapper.insert(category);
        if (row == null){
            throw new InsertException("分类添加数据产生异常");
        }
    }

    @Override
    public void del(Integer cateId) {
        Integer row = categoryMapper.del(cateId);
        if (row == null){
            throw new DeleteException("删除分类产生异常");
        }
    }

    @Override
    public void updateById(Category category) {
        if (category.getCatePatentId()==null){
            throw new UpdateException("修改分类产生异常,没有父分类编号");
        }
        if (category.getCateName()==null){
            throw new UpdateException("修改分类产生异常,没有分类名称编号");
        }
        Integer row = categoryMapper.updateById(category);
        if (row == null){
            throw new UpdateException("修改分类产生异常,修改异常");
        }
    }

    @Override
    public Category findById(Integer cateId) {
        Category category = categoryMapper.findById(cateId);
        return category;
    }
}
