package com.cy.store.contorller;

import com.cy.store.entity.Product;
import com.cy.store.service.ProductService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController{
    @Autowired
    private ProductService productService;
    //展示热销排行
    @RequestMapping("/hot_list")
    public JsonResult<List<Product>> getHotList(){
        List<Product> data = productService.findHotList();
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id")Integer id){
        Product data = productService.findById(id);
        return new JsonResult<>(OK,data);
    }
    //展示新到好货
    @RequestMapping("/good_list")
    public JsonResult<List<Product>> getGoodList(){
        List<Product> data = productService.findGoodList();
        return new JsonResult<>(OK,data);
    }
}
