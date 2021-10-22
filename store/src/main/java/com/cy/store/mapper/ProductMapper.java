package com.cy.store.mapper;

import com.cy.store.entity.Product;

import java.util.List;

public interface ProductMapper {
    //查询所有热销商品
    List<Product> findHotList();
    //根据商品的ID来查询商品所有信息
    Product findById(Integer id);
    //查询所有的新到好货
    List<Product> findGoodList();
}
