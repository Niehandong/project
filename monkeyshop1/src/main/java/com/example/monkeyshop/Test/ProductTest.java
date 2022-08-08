package com.example.monkeyshop.Test;

import com.example.monkeyshop.pojo.Product;
import com.example.monkeyshop.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTest {

    @Autowired
    ProductService productService;

    @Test
    public void test01(){
        List<Product> all = productService.findAll();
        for (Product u:all) {
            System.out.println(u);
        }
    }

    @Test
    public void test02(){
//        List<Product> all = productService.findAll();
        String dd = "/image/6fa31455-9712-4bcc-9397-e7ed91cfe925.jpg";
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static";
        File file = new File(path, dd);

        //删除文件
//        FileSystemUtils.deleteRecursively(new File("D:\\新建文件夹"));
        System.out.println("删除成功"+file);
    }

    @Test
    public void test03(){
        List<Product> byFid = productService.findByFid(2);
        for (Product u:byFid ) {
            System.out.println(u);
        }
    }

    @Test
    public void test04(){
        List<Product> products = productService.randFind();
        for (Product u:products ) {
            System.out.println(u);
        }
    }
}
