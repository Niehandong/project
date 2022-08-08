package com.example.monkeyshop.controller;

import com.example.monkeyshop.service.ex.InsertException;
import com.example.monkeyshop.service.ex.ServiceException;
import com.example.monkeyshop.service.ex.UsernameDuplicatedException;
import com.example.monkeyshop.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    //操作成功的状态码
    public static final int OK = 200;
    @ExceptionHandler({ServiceException.class})
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void> result = new JsonResult<>();
        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户信息被占用");
        }else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        }

        return result;
    }

}
