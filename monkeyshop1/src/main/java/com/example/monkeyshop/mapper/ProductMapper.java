package com.example.monkeyshop.mapper;

import com.example.monkeyshop.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    Integer insert(Product product);

    List<Product> selectAll();

    Integer delById(@Param("id") Integer id);

    Product findById(@Param("id") Integer id);

    Integer updateById(Product product);

    List<Product> findByFid(@Param("fid") Integer fid);

    List<Product> randFind();

    List<Product> randFinds();
}
