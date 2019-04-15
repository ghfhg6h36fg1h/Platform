package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     *
     * @mbggenerated 2018-05-07
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-07
     */
    int insert(User record);

    /**
     *
     * @mbggenerated 2018-05-07
     */
    int insertSelective(User record);

    /**
     *
     * @mbggenerated 2018-05-07
     */
    User selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-07
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbggenerated 2018-05-07
     */
    int updateByPrimaryKey(User record);
}