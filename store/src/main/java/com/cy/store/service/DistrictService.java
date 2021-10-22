package com.cy.store.service;

import com.cy.store.entity.District;

import java.util.List;

public interface DistrictService {
    //根据父代号来查询区域信息
    List<District> getByParent(String parent);
    //根据code查询对应的区域信息
    String getNameByCode(String code);

}
