package com.cy.store.contorller;

import com.cy.store.entity.Order;
import com.cy.store.service.OrderService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session) throws AccessDeniedException {
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);

        Order data = orderService.create(aid, uid, username, cids);
        return  new JsonResult<>(OK,data);
    }
}
