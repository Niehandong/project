package com.cy.store.service.impl;

import com.cy.store.entity.Product;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ProductService;
import com.cy.store.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    //查询所有的热销排行
    @Override
    public List<Product> findHotList() {
        List<Product> list = productMapper.findHotList();
        for (Product product:list){
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedUser(null);
            product.setModifiedTime(null);
        }

        return list;
    }
    //根据id查询商品信息
    @Override
    public Product findById(Integer id) {
        Product product = productMapper.findById(id);
        if(product == null){
            throw new ProductNotFoundException("尝试访问的商品数据不存在");
        }
        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);

        return product;
    }
    //查询所有的新到好货
    @Override
    public List<Product> findGoodList() {
        return productMapper.findGoodList();
    }
}
