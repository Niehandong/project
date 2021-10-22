package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

//收货地址的接口
public interface AddressMapper {

    //插入用户收获地址的数据
    Integer insert(Address address);
    //统计用户id的收获地址数量
    Integer countByUid(Integer uid);
    //根据用户的id查询收获的地址
    List<Address> findByUid(Integer uid);
    //根据AID查询收货地址数据
    Address findByAid(Integer aid);
    //根据用户的uid值来修改用户的收货地址设置为非默认
    Integer updateNonDefault(Integer uid);
    //根据aid修改用户默认
    Integer updateDefaultByAid(@Param("aid") Integer aid,
                               @Param("modifiedUser") String modifiedUser,
                               @Param("modifiedTime") Date modifiedTime);
    //根据收获id删除收获数据
    Integer deleteByAid(Integer aid);
    //根据用户uid查询用户最后一次修改的收货地址数据
    Address findLastModified(Integer uid);
}
