package com.cy.store.service.impl;

import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictServiceimpl implements DistrictService {
    @Autowired
    public DistrictMapper districtMapper;
    //根据父代号来查询区域信息
    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        for (District d : list){
            d.setId(null);
            d.setParent(null);
        }
        return list;
    }
    //根据code查询对应的区域信息
    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}
