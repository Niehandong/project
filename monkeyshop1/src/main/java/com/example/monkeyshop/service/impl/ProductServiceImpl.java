package com.example.monkeyshop.service.impl;

import com.example.monkeyshop.mapper.ProductMapper;
import com.example.monkeyshop.pojo.Product;
import com.example.monkeyshop.service.ProductService;
import com.example.monkeyshop.service.ex.DeleteException;
import com.example.monkeyshop.service.ex.InsertException;
import com.example.monkeyshop.service.ex.UpdateException;
import com.example.monkeyshop.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;


    @Override
    public void productAdd(Product product) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        product.setCurrentTime(format.format(date));
        product.setUpdateTime(format.format(date));
        Integer row = productMapper.insert(product);
        if (row == null){
            throw new InsertException("插入商品数据产生异常");
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> result = productMapper.selectAll();
        return result;
    }

    @Override
    public void del(Integer id) {
        //根据id查询商品列表的所有信息
        Product product = productMapper.findById(id);
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static";
        System.out.println("path:"+product.getFilename());
        System.out.println("user:"+path);
        File file = new File(path, product.getFilename());

        FileSystemUtils.deleteRecursively(file);
        Integer row = productMapper.delById(id);
        if (row == null){
            throw new DeleteException("删除商品列表产生异常");
        }
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }

    @Override
    public void updateById(Product product) {

       Integer row =  productMapper.updateById(product);


       if (row == null){
           throw new UpdateException("商品列表更新出现异常");
       }
    }

    @Override
    public List<Product> findByFid(Integer fid) {
        List<Product> result = productMapper.findByFid(fid);
        if (result == null){
            throw new UserNotFoundException("商品信息没有查询到1");
        }
        return result;
    }

    @Override
    public List<Product> randFind() {
        List<Product> result = productMapper.randFind();
        if (result == null){
            throw new UserNotFoundException("首页商品信息没有查询到");
        }
        return result;
    }

    @Override
    public List<Product> randFinds() {
        List<Product> result = productMapper.randFinds();
        if (result == null){
            throw new UserNotFoundException("首页商品信息没有查询到");
        }
        return result;
    }

}
