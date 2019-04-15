package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.New_Integral;

public interface New_IntegralMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(New_Integral record);

    int insertSelective(New_Integral record);

    New_Integral selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(New_Integral record);

    int updateByPrimaryKey(New_Integral record);
}