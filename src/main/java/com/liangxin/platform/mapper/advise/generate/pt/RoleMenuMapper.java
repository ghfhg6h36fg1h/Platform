package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMenuMapper {
    /**
     *
     * @mbggenerated 2018-05-03
     */
    int insert(RoleMenu record);

    /**
     *
     * @mbggenerated 2018-05-03
     */
    int insertSelective(RoleMenu record);
}