package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    /**
     *
     * @mbggenerated 2018-05-03
     */
    int insert(UserRole record);

    /**
     *
     * @mbggenerated 2018-05-03
     */
    int insertSelective(UserRole record);
}