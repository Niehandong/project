package com.cy.store.contorller;

import com.cy.store.contorller.ex.*;
import com.cy.store.entity.User;
import com.cy.store.service.UserService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    //用户注册
    @RequestMapping("/reg")
    public JsonResult<Void> reg(User user){

        userService.reg(user);
        return new JsonResult<>(OK);
    }
    //用户登录
    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User data = userService.login(username, password);
        //将uid和username存入到session中
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());
        //打印输出session中的uid和username值
        //System.out.println(getuidFromSession(session));
        //System.out.println(getUsernameFromSession(session));
        return new JsonResult<>(OK,data);
    }
    //修改用户密码
    @RequestMapping("/chang_password")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);
        System.out.println("修改成功");
        return new JsonResult<>(OK);
    }
    //根据uid查询用户所有信息
    @RequestMapping("/get_by_uid")
    public  JsonResult<User> getByUid(HttpSession session){
        //根据uid对用户信息进行查询
        User data = userService.getByUid(getuidFromSession(session));
        return new JsonResult<>(OK,data);
    }
    //对用户信息进行更新操作
    @RequestMapping("/change_info")
    public JsonResult<Void> changeInfo(HttpSession session,User user){
        //获取uid
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid,username,user);
        return new JsonResult<>(OK);
    }

    //设置上传文件的最大值
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    //限制上传文件类型
    public static final List<String> AVATAR_TYPE =new ArrayList<>();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    @RequestMapping(value = "/change_avatar")
    @ResponseBody
    public JsonResult<String> changeAvatar(
            HttpSession session,
           @RequestParam("file") MultipartFile file){
        //判断文件是否为空
        if (file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        //判断文件大小
        if (file.getSize() > AVATAR_MAX_SIZE){
            throw new FileSizeException("文件超出限制");
        }
        //获取文件的类型，
        String contentType = file.getContentType();
        //判断文件类型是否符合规定的后缀
        if (!AVATAR_TYPE.contains(contentType)){
            throw new FileTypeException("文件类型不支持");
        }
        //上传的文件.../upload/文件.png
        String parent = session.getServletContext().getRealPath("upload");
        //file的对象指向这个路径，file是否存在
        File dir = new File(parent);
        if (!dir.exists()){//检查目录是否存在
            dir.mkdir();//创建目录
        }
        //获取文件名称
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename:"+originalFilename);
        String suffix="";
        int index = originalFilename.lastIndexOf(".");
        suffix = originalFilename.substring(index);
        //随机生成的文件名
        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;

        File dest = new File(dir, filename);//这是一个空文件
        //将参数file中的数据写入到这个空文件中
        try {
            file.transferTo(dest);//将file文件中数据写入到dest文件中
        }catch (FileStateException e){
            throw new FileStateException("文件状态异常");
        }catch (IOException e){
           throw new FileUploadIOException("文件读写异常");
        }
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        //头像返回路径
        String avatar="/upload/" + filename;
        userService.changeAvatar(uid,avatar,username,new Date());
        //返回路径给前端，将用于头像的展示使用
        return new JsonResult<>(OK,avatar);
    }
}
