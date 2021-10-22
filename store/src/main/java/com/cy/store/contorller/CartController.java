package com.cy.store.contorller;

import com.cy.store.service.CartService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController extends BaseController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session){
        cartService.addToCart(
                getuidFromSession(session),
                pid,
                amount,
                getUsernameFromSession(session)
        );
        return new JsonResult<>(OK);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<CartVO>> getVoByUid(HttpSession session){
        List<CartVO> data = cartService.getVoByUid(getuidFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session){
        Integer data = cartService.addNum(
                cid,
                getuidFromSession(session),
                getUsernameFromSession(session)
        );
        return new JsonResult<>(OK,data);
    }
    @RequestMapping("/num/add/{cid}")
    public JsonResult<Integer> reduceNum(@PathVariable("cid") Integer cid, HttpSession session){
        Integer data = cartService.reduceNum(
                cid,
                getuidFromSession(session),
                getUsernameFromSession(session)
        );
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("{cid}/delete")
    public JsonResult<Integer> delete(@PathVariable("cid") Integer cid){
            cartService.delete(cid);
        return new JsonResult<>(OK);
    }

    @GetMapping("/list")
    public JsonResult<List<CartVO>>  getVOByCids(Integer[] cids,HttpSession session){
//        System.out.println("cids:"+cids.toString());
//        System.out.println("uid:"+getuidFromSession(session));
        List<CartVO> data = cartService.getVoByCid(getuidFromSession(session), cids);
        return new JsonResult<List<CartVO>>(OK,data);
    }
}
