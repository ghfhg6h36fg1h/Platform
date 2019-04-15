package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    /**
     *
     * @mbggenerated 2018-05-03
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-03
     */
    int insert(Role record);

    /**
     *
     * @mbggenerated 2018-05-03
     */
    int insertSelective(Role record);

    /**
     *
     * @mbggenerated 2018-05-03
     */
    Role selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-03
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbggenerated 2018-05-03
     */
    int updateByPrimaryKey(Role record);
}