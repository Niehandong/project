package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.service.AddressService;
import com.cy.store.service.DistrictService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

@Service
public class AddressServiceimpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    //在添加用户收获地址的业务层依赖于DistrictService的业务接口
    @Autowired
    private DistrictService districtService;

    @Value("20")
    public Integer maxCount;

    //新增收获地址
    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        //调用收获地址统计的方法
        Integer cout = addressMapper.countByUid(uid);
        if (cout > maxCount){
            throw new AddressCountLimitException("新增地址超过限制");
        }
        // 对省  市 区 地址进行补全
        String ProviceName = districtService.getNameByCode(address.getProvinceCode());
        String CityName = districtService.getNameByCode(address.getCityCode());
        String AreaName = districtService.getNameByCode(address.getAreaCode());
//        System.out.println("provice:"+ProviceName);
//        System.out.println("city:"+CityName);
//        System.out.println("area:"+AreaName);

        address.setProvinceName(ProviceName);
        address.setCityName(CityName);
        address.setAreaName(AreaName);


        address.setUid(uid);
        Integer isDefault = cout == 0 ? 1 : 0;//1表示默认   0表示不默认
        address.setIsDefault(isDefault);
        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());
        //插入收货地址方法
        Integer rows = addressMapper.insert(address);
        if (rows != 1){
            throw new InsertException("插入用户收获地址产生异常");
        }


    }
    //根据uid查询所有地址信息
    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        for (Address address:list){
           // address.setAid(null);
           // address.setUid(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setTel(null);
            address.setIsDefault(null);
            address.setCreatedTime(null);
            address.setCreatedUser(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);
        }
        return list;
    }
    //修改某个用户的收货地址为默认收获地址
    @Override
    public void setDefault(Integer aid, Integer uid, String username) throws AccessDeniedException {
        Address result = addressMapper.findByAid(aid);
        if (result == null){
            throw new AddressNotFoundException("收货地址不存在");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        //先将所有收货地址设置为非默认
        Integer rows = addressMapper.updateNonDefault(uid);
        if (rows < 1){
            throw new UpdateException("更新数据产生未知的异常");
        }
       rows = addressMapper.updateDefaultByAid(aid,username,new Date());
        if (rows != 1){
            throw new UpdateException("更新数据产生未知的异常");
        }
    }
    //删除用户选中的用户数据
    @Override
    public void delete(Integer aid, Integer uid, String username) throws AccessDeniedException {
        Address result = addressMapper.findByAid(aid);
        if (result == null){
            throw new AddressNotFoundException("收获地址数据不存在");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = addressMapper.deleteByAid(aid);
        if (rows != 1){
            throw new DeleteException("删除数据产生未知的异常");
        }
        Integer count = addressMapper.countByUid(uid);
        if (count == 0){
            //直接终止程序
            return;
        }
        if (result.getIsDefault() == 0){
            return;
        }
        //将这条数据中的is_default中字符的值设置为1
        Address address = addressMapper.findLastModified(uid);
        rows = addressMapper.updateDefaultByAid(address.getAid(),username,new Date());
       if (rows != 1){
           throw new UpdateException("更新数据时产生未知的异常");
       }

    }
    //根据收货地址的id获取收货地址
    @Override
    public Address getByAid(Integer aid,Integer uid) throws AccessDeniedException {
        Address address = addressMapper.findByAid(aid);
        if (address == null){
            throw new AddressNotFoundException("收获地址不存在");
        }
        if (!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据方法");
        }
        address.setProvinceCode(null);
        address.setCityCode(null);
        address.setAreaCode(null);
        address.setCreatedUser(null);
        address.setCreatedTime(null);
        address.setModifiedUser(null);
        address.setModifiedTime(null);
        return address;
    }
}
