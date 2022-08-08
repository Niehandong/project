package com.example.monkeyshop.controller;

import com.example.monkeyshop.pojo.Cate;
import com.example.monkeyshop.pojo.Category;
import com.example.monkeyshop.service.CategoryService;
import com.example.monkeyshop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/category")
@RestController
public class CategoryController extends BaseController{
    @Autowired
    CategoryService categoryService;

    //查询所有分类
    @RequestMapping("/findAll")
    public JsonResult<Cate> findAll(){
        Cate data = categoryService.findAll();
        return new JsonResult<>(OK,data);
    }
    //添加分类信息
    @RequestMapping("/add")
    public JsonResult<Void> add(Category category){
        categoryService.add(category);
        return new JsonResult<>(OK);
    }
    //根据id删除对应的分类信息
    @RequestMapping("/del")
    public JsonResult<Void> del(Integer cateId){
        categoryService.del(cateId);
        return new JsonResult<>(OK);
    }
    @RequestMapping("/update")
    public JsonResult<Void> updateById(Category category){
        categoryService.updateById(category);
        return new JsonResult<>(OK);
    }
}
