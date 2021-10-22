package com.cy.store.service.impl;

import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.CartService;
import com.cy.store.service.ex.AccessDeniedException;
import com.cy.store.service.ex.CartNotFoundException;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UpdateException;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceimpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;
    //将商品添加到购物车中
    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        //查询当前要添加的这个购物车是否在表中存在
        Cart resule = cartMapper.findByUidAndPid(uid, pid);
        if (resule == null){
            //表示这个商品没有添加到购物车中
            //创建一个cart对象
            Cart cart = new Cart();
            //补全数据
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            Product product = productMapper.findById(pid);
            cart.setPrice(product.getPrice());
            cart.setCreatedUser(username);
            cart.setCreatedTime(new Date());
            cart.setModifiedUser(username);
            cart.setModifiedTime(new Date());
            //将cart数据插入数据库
            Integer rows = cartMapper.insert(cart);
            if (rows != 1){
                throw new InsertException("插入数据时产生未知的异常");
            }

        }else {//反之当前商品在购物车中存在，则更新这条数据的num值
            int num = resule.getNum() + amount;
            Integer rows = cartMapper.updateNumByCid(
                    resule.getCid(),
                    num,
                    username,
                    new Date()
            );
            if (rows != 1){
                throw new UpdateException("更新数据产生未知的异常");
            }

        }
    }
    //根据uid查询所有购物车中的商品
    @Override
    public List<CartVO> getVoByUid(Integer uid) {

        return cartMapper.findVOByUid(uid);
    }
    //更新用户的购物车数据数量
    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if (result == null){
            throw  new CartNotFoundException("数据不存在");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num=result.getNum()+1;
        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if (rows != 1){
            throw new UpdateException("更新数据失败");
        }
        return num;
    }

    //更新用户的购物车数据数量
    @Override
    public Integer reduceNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if (result == null){
            throw  new CartNotFoundException("数据不存在");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num=result.getNum()-1;
        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if (rows != 1){
            throw new UpdateException("更新数据失败");
        }
        return num;
    }
    //删除购物车中对应的商品
    @Override
    public void delete(Integer cid) {
        cartMapper.deleteByCid(cid);
    }

    @Override
    public List<CartVO> getVoByCid(Integer uid, Integer[] cids) {
        List<CartVO> list = cartMapper.findVOByCid(cids);
        Iterator<CartVO> it = list.iterator();
        while (it.hasNext()){
            CartVO cartVO=it.next();
            if (!cartVO.getUid().equals(uid)){
                //表示当前的数据不属于当前用户
                //从集合中移除用户数据
                it.remove();
            }
        }
        return list;
    }
}
