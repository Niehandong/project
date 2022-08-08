package com.example.monkeyshop.controller;

import com.example.monkeyshop.controller.ex.FileEmptyException;
import com.example.monkeyshop.controller.ex.FileSizeException;
import com.example.monkeyshop.controller.ex.FileTypeException;
import com.example.monkeyshop.pojo.Category;
import com.example.monkeyshop.pojo.Product;
import com.example.monkeyshop.service.CategoryService;
import com.example.monkeyshop.service.ProductService;
import com.example.monkeyshop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {


    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    //图片文件大小的上限值
    public static  final int AVATAR_MAX_SIZE = 1*1024*1024;
    //允许上传图片的文件类型
    public static  final List<String> AVATAR_TYPES = new ArrayList<String>();

    /** 初始化允许上传的头像的文件类型 */
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/jpg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
        AVATAR_TYPES.add("image/pjpeg");
        AVATAR_TYPES.add("image/x-png");

    }

    //根据id查询所有的商品列表
    @RequestMapping("/findById")
    public JsonResult<Product> findById(@RequestParam("id") Integer id){
        Product data = productService.findById(id);
        return new JsonResult<>(OK,data);
    }

    //根据id对商品列表进行修改
    @RequestMapping("/update")
    public JsonResult<Void> update(
            @RequestParam("file")MultipartFile file,
            Product product,
            @RequestParam("cateId")Integer cateId
    ){
        //查询所有的分类信息
        Category category = categoryService.findById(cateId);

        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static";
        Product byId = productService.findById(product.getId());
        File delfile = new File(path, byId.getFilename());
        FileSystemUtils.deleteRecursively(delfile);


        //文件上传返回图片存储路径
        String filename = fileAdd(file);
        product.setFilename(filename);
        product.setFid(category.getCatePatentId());
        product.setCid(category.getCateId());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        product.setUpdateTime(format.format(date));
        productService.updateById(product);

        return new JsonResult<>(OK);
    }

    //根据fid查询商品所有信息
    @RequestMapping("/findByFid")
    public JsonResult<List<Product>> findByFid(@RequestParam("fid") Integer fid){
        List<Product> data = productService.findByFid(fid);
        return new JsonResult<>(OK,data);
    }

    //随机查询6条数据
    @RequestMapping("/randFind")
    public JsonResult<List<Product>> randFind(){
        List<Product> data = productService.randFind();
        return new JsonResult<>(OK,data);
    }
    //随机查询4条商品数据
    @RequestMapping("/randFinds")
    public JsonResult<List<Product>> randFinds(){
        List<Product> data = productService.randFinds();
        return new JsonResult<>(OK,data);
    }
    //添加一条商品列表
    @RequestMapping("/add")
    public JsonResult<Void> add(@RequestParam("file")MultipartFile file,
                                Product product,
                                @RequestParam("cateId")Integer cateId
    ) {
        //查询所有的分类信息
        Category category = categoryService.findById(cateId);
        //文件上传返回图片存储路径
        String filename = fileAdd(file);
        product.setFilename(filename);
        //判断是否为根目录
        if(category.getCatePatentId()==0){
            //如果是根目录，则存入分类
            product.setFid(category.getCateId());
        }else {
            product.setFid(category.getCatePatentId());
        }
        product.setCid(category.getCateId());

//        System.out.println(product);
        //将数据插入到数据库
        productService.productAdd(product);

        return new JsonResult<>(OK);
    }

    //查询所有商品列表信息
    @RequestMapping("/findAll")
    public JsonResult<List<Product>> findAll(){
        List<Product> data = productService.findAll();
        return new JsonResult<>(OK,data);
    }

    //根据id删除对应的商品列表信息
    @RequestMapping("/del")
    public JsonResult<Void> del(@RequestParam("Id") Integer Id){
        productService.del(Id);
        return new JsonResult<>(OK);
    }

    //实现商品上传的类
    private String fileAdd(MultipartFile file){
        //判断上传文件是否为空
        if (file.isEmpty()){
            throw new FileEmptyException("上传的图片文件不能为空");
        }
        //判断上传文件大小是否超出限制
        if (file.getSize()>AVATAR_MAX_SIZE){
            throw new FileSizeException("上传文件超过了"+AVATAR_MAX_SIZE+"KB的图像大小");
        }
        //判断上传文件类型是否超出限制
        String contentType = file.getContentType();
        if (!AVATAR_TYPES.contains(contentType)){
            throw new FileTypeException("不支持使用该类型的文件作为头像，允许的文件类型："+AVATAR_TYPES);
        }
        //获取文件名
        String filename = file.getOriginalFilename();
        //获取文件后缀
        int index = filename.lastIndexOf(".");
        String suffixName;
        if (index>0){
            suffixName = filename.substring(filename.lastIndexOf("."));
        }else {
            suffixName = ".png";
        }

        //重新生成文件名
        filename = UUID.randomUUID()+suffixName;

        //获取项目路径

        ClassPathResource resource = new ClassPathResource("");
//        String projectPath = resource.getFile().getAbsolutePath() + "\\static\\image";
        //项目的根路径
        String property = System.getProperty("user.dir");
        //拼接成到静态目录下的路径
        File filepath = new File(property + "/src/main/resources/static/image");
        System.out.println("projectPath:"+filepath);
        //判断文件路径是否存在，如果不存在则创建文件夹
        if (!filepath.exists()){
            filepath.mkdirs();
        }
        //保存到文件夹路径下的名称
        File file1 = new File(filepath, "/" + filename);
        //保存文件
        try {
            file.transferTo(file1);
        }catch (IOException e){
            e.printStackTrace();
        }
        //保存到数据库的真实相对路径
        String relativePath = "/image/"+filename;

        return relativePath;
    }
}
