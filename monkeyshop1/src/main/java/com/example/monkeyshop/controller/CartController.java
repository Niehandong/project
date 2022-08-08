package com.example.monkeyshop.controller;

import com.example.monkeyshop.pojo.Cart;
import com.example.monkeyshop.service.CartService;
import com.example.monkeyshop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController extends BaseController{

    @Autowired
    CartService cartService;

    ////将商品信息插入到数据库中
    @RequestMapping("/add")
    public JsonResult<Void> add(@RequestParam("id") Integer id,
                                @RequestParam("quantity") Integer quantity,
                                @RequestParam("userId") String userId){
//        System.out.println("id:"+id);
//        System.out.println("quantity:"+quantity);
//        System.out.println("userId:"+userId);
        cartService.add(id,quantity,userId);
        return new JsonResult<>(OK);
    }

    //点击立即购买后，将商品信息插入到购物车列表中
    @RequestMapping("/goBuy")
    public JsonResult<Cart> goBuy(@RequestParam("id") Integer id,
                                  @RequestParam("quantity") Integer quantity,
                                  @RequestParam("userId") String userId){
        Cart data = cartService.goBuy(id,quantity,userId);
        return new JsonResult<>(OK,data);
    }

    //根据用户名称查询对应的商品信息
    @RequestMapping("/findByUserId")
    public JsonResult<List<Cart>> findByUserId(@RequestParam("userId") String userId){
        List<Cart> data = cartService.findByUserId(userId);
        return new JsonResult<>(OK,data);
    }

    //对商品信息中的数量进行减少
    @RequestMapping("/subNum")
    public JsonResult<Void> subNum(@RequestParam("cartId") Integer cartId,
                                   @RequestParam("userId") String userId,
                                   @RequestParam("cartQuantity") Integer cartQuantity
    ){
        cartService.subNum(cartId,userId,cartQuantity);
        return new JsonResult<>(OK);
    }
    //对商品信息中的数量进行增加
    @RequestMapping("/addNum")
    public JsonResult<Void> addNum(@RequestParam("cartId") Integer cartId,
                                   @RequestParam("userId") String userId,
                                   @RequestParam("cartQuantity") Integer cartQuantity
    ){
        cartService.addNum(cartId,userId,cartQuantity);
        return new JsonResult<>(OK);
    }
    //根据商品id和用户名对购物车表进行删除
    @RequestMapping("/cartDel")
    public JsonResult<Void> cartDel(
            @RequestParam("cartId") Integer cartId,
            @RequestParam("userId") String userId
    ){
        //根据商品id和用户名对购物车表进行删除
        cartService.delByCartId(cartId,userId);
        return new JsonResult<>(OK);
    }

    @RequestMapping("/eids")
    public JsonResult<List<Cart>> eids(@RequestParam(value = "ids[]") Integer[] ids,
                                        @RequestParam("userId") String userId
    ){
//        System.out.println("eids:"+ Arrays.toString(ids));
//        System.out.println("eids111:"+ ids);
        //对数组进行遍历查询
        List<Cart> data = cartService.eids(ids,userId);
//        System.out.println("userId:"+userId);
        return new JsonResult<>(OK,data);
    }

    //点击支付按钮，将商品进行支付
    @RequestMapping("/gopay")
    public JsonResult<Void> goPay(
            @RequestParam(value = "ids[]") Integer[] ids,
            @RequestParam("userId") String userId
    ){
//        System.out.println(Arrays.toString(ids));
        cartService.updataByCartId(ids,userId);
        return new JsonResult<>(OK);
    }
}
