package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.New_IntegralDetail;

public interface New_IntegralDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(New_IntegralDetail record);

    int insertSelective(New_IntegralDetail record);

    New_IntegralDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(New_IntegralDetail record);

    int updateByPrimaryKey(New_IntegralDetail record);
}