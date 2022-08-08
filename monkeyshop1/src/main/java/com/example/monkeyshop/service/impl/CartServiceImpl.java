package com.example.monkeyshop.service.impl;

import com.example.monkeyshop.mapper.CartMapper;
import com.example.monkeyshop.mapper.ProductMapper;
import com.example.monkeyshop.mapper.UserMapper;
import com.example.monkeyshop.pojo.Cart;
import com.example.monkeyshop.pojo.Product;
import com.example.monkeyshop.pojo.User;
import com.example.monkeyshop.service.CartService;
import com.example.monkeyshop.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    UserMapper userMapper;

    //将商品信息插入到数据库中
    @Override
    public void add(Integer id, Integer quantity, String userId) {
        //查询商品信息是否存在
        Product product = productMapper.findById(id);
        if (product == null){
            throw new ProductNotException("没有查询到商品信息");
        }
        //根据用户账号查询用户的所有信息
        User user = userMapper.findByUserId(userId);
        if (user == null){
            throw new UserNotFoundException("查询不到用户信息");
        }
        //根据购物车中的商品id查询数据库，获取购物车中的数据
        Cart cartlist = cartMapper.findByPId(product.getId(),userId);

        if (cartlist == null){
            //如果数据中没有商品信息，则直接想数据库添加商品
            Cart cart = new Cart();

            if (quantity >product.getStock()){
                throw new StockNotFoudException("库存不足，请提醒管理员及时补货");
            }else {
                cart.setCartQuantity(quantity);
            }

            cart.setCartPStock(product.getStock());
            cart.setCartPFilename(product.getFilename());
            cart.setCartPName(product.getName());
            cart.setCartPPrice(product.getPrice());
            cart.setCartPId(product.getId());
            cart.setCartUId(user.getId());
            cart.setCartUUserid(user.getUserId());
            cart.setCartUName(user.getUserName());
            cart.setCartUMobile(user.getUserMobile());
            cart.setCartUAddress(user.getUserAddress());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            cart.setCurrentTime(format.format(date));
            cart.setUpdateTime(format.format(date));
            cart.setCartValid(0);
            // todo  向数据库插入一条数据
           Integer row =  cartMapper.insert(cart);
           if (row == null){
               throw new InsertException("购物车表插入数据异常");
           }
        }else {
            //如果数据库中存在商品信息，则修改商品数量
            int count = cartlist.getCartQuantity() + quantity;
            if (count>cartlist.getCartPStock()){
                throw new StockNotFoudException("库存不足，请提醒管理员及时补货");
            }else {
                cartlist.setCartQuantity(count);
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            //设置修改时间
            cartlist.setUpdateTime(format.format(date));
            //todo  根据id对购物车信息进行更改
            Integer row = cartMapper.updateById(cartlist);
            if (row == null){
                throw new UpdateException("购物车信息更新商品信息出现异常");
            }
        }
    }

    //根据用户名称查询对应的商品信息
    @Override
    public List<Cart> findByUserId(String userId) {
        List<Cart> row = cartMapper.findByUserId(userId);
        if (row == null){
            throw new CartNotFoundException("购物车信息查询出现异常，请重新查询");
        }
        return row;
    }
    //对商品信息中的数量进行减少
    @Override
    public void subNum(Integer cartId, String userId,Integer cartQuantity) {
        //根据商品id和用户id来查询商品
        Cart cart = cartMapper.findByCartId(cartId,userId);
        if (cart == null){
            throw new CartNotFoundException("购物车信息数据没有找到，请及时添加到数据库中");
        }
        Integer quantity = cart.getCartQuantity();
        if (quantity-1 == 0){
            cart.setCartQuantity(1);
        }else {
            cart.setCartQuantity(quantity-1);
        }
        Integer row = cartMapper.updateById(cart);
        if (row == null){
            throw new UpdateException("购物车信息更新减少数量产生异常");
        }
    }
    //对商品信息中的数量进行增加
    @Override
    public void addNum(Integer cartId, String userId, Integer cartQuantity) {
        //根据商品id和用户id来查询商品
        Cart cart = cartMapper.findByCartId(cartId,userId);
        if (cart == null){
            throw new CartNotFoundException("购物车信息数据没有找到，请及时添加到数据库中");
        }
        Integer quantity = cart.getCartQuantity();
        if (quantity+1>cart.getCartPStock()){
            cart.setCartQuantity(quantity);
        }else {
            cart.setCartQuantity(quantity+1);
        }
        Integer row = cartMapper.updateById(cart);
        if (row == null){
            throw new UpdateException("购物车信息更新增加数量产生异常");
        }
    }

    //根据商品id和用户名对购物车表进行删除
    @Override
    public void delByCartId(Integer cartId, String userId) {
        Integer row = cartMapper.delByCartId(cartId,userId);
        if (row == null){
            throw new CartDelException("购物车信息删除出现异常");
        }
    }

    //对数组进行遍历查询
    @Override
    public List<Cart> eids(Integer[] ids,String userId) {
        List<Cart> carts = cartMapper.eids(ids,userId);
        return carts;
    }

    //点击支付按钮，将商品进行支付
    @Override
    public void updataByCartId(Integer[] ids, String userId) {
        //判断数组是否为空
        if (ids.length == 0){
            throw new CartUpdateByValid("商品信息在支付时查询不到商品");
        }

        for (int i =0;i<ids.length;i++){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            //点击支付按钮，将商品进行支付
            Integer row =cartMapper.updateByValid(ids[i], userId,format.format(date));
            if (row == null){
                throw new CartNotFoundException("商品"+ids[i]+"支付时产生异常");
            }
        }

    }

    //点击立即购买后，将商品信息插入到购物车列表中
    @Override
    public Cart goBuy(Integer id, Integer quantity, String userId) {
        //查询商品信息是否存在
        Product product = productMapper.findById(id);
        if (product == null){
            throw new ProductNotException("没有查询到商品信息");
        }
        //根据用户账号查询用户的所有信息
        User user = userMapper.findByUserId(userId);
        if (user == null){
            throw new UserNotFoundException("查询不到用户信息");
        }

        //根据购物车中的商品id查询数据库，获取购物车中的数据
        Cart cartlist = cartMapper.findByPId(product.getId(),userId);

        if (cartlist == null){
            //如果数据中没有商品信息，则直接想数据库添加商品
            Cart cart = new Cart();

            if (quantity >product.getStock()){
                throw new StockNotFoudException("库存不足，请提醒管理员及时补货");
            }else {
                cart.setCartQuantity(quantity);
            }

            cart.setCartPStock(product.getStock());
            cart.setCartPFilename(product.getFilename());
            cart.setCartPName(product.getName());
            cart.setCartPPrice(product.getPrice());
            cart.setCartPId(product.getId());
            cart.setCartUId(user.getId());
            cart.setCartUUserid(user.getUserId());
            cart.setCartUName(user.getUserName());
            cart.setCartUMobile(user.getUserMobile());
            cart.setCartUAddress(user.getUserAddress());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            cart.setCurrentTime(format.format(date));
            cart.setUpdateTime(format.format(date));
            cart.setCartValid(0);
            // todo  向数据库插入一条数据
            Integer row =  cartMapper.insert(cart);
            if (row == null){
                throw new InsertException("购物车表插入数据异常");
            }
        }else {
            //如果数据库中存在商品信息，则修改商品数量
            int count = cartlist.getCartQuantity() + quantity;
            if (count>cartlist.getCartPStock()){
                throw new StockNotFoudException("库存不足，请提醒管理员及时补货");
            }else {
                cartlist.setCartQuantity(count);
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            //设置修改时间
            cartlist.setUpdateTime(format.format(date));
            //todo  根据id对购物车信息进行更改
            Integer row = cartMapper.updateById(cartlist);
            if (row == null){
                throw new UpdateException("购物车信息更新商品信息出现异常");
            }
        }
        Cart byPId = cartMapper.findByPId(id, userId);
        return byPId;
    }
}
