package com.example.monkeyshop.service;

import com.example.monkeyshop.pojo.Product;

import java.util.List;

public interface ProductService {
    //插入一条数据到数据库中
    void productAdd(Product product);
    //查询所有商品列表
    List<Product> findAll();
    //根据id删除对应的商品列表信息
    void del(Integer id);
    //根据id查询所有的商品信息
    Product findById(Integer id);
    //根据id修改商品信息
    void updateById(Product product);
    //根据fid查询商品所有信息
    List<Product> findByFid(Integer fid);
    //随机查询6条数据
    List<Product> randFind();
    //随机查询4条数据
    List<Product> randFinds();
}
