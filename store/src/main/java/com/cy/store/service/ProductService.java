package com.cy.store.service;

import com.cy.store.entity.Product;

import java.util.List;

public interface ProductService {
    //查询所有的热销排行
    List<Product> findHotList();
    //根据id查询商品信息
    Product findById(Integer id);
    //查询所有的新到好货
    List<Product> findGoodList();
}
