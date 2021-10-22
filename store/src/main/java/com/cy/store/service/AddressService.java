package com.cy.store.service;

import com.cy.store.entity.Address;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

//收货地址的接口
@Service
public interface AddressService {
   //新增一个收货地址
   void addNewAddress(Integer uid, String username, Address address);
   //根据uid查询所有地址信息
   List<Address> getByUid(Integer uid);
   //修改某个用户的收货地址为默认收获地址
   void setDefault(Integer aid,Integer uid,String username) throws AccessDeniedException;
   //删除用户选中的用户数据
   void delete(Integer aid,Integer uid,String username) throws AccessDeniedException;
   //根据收货地址的id获取收货地址
   Address getByAid(Integer aid,Integer uid) throws AccessDeniedException;
}
