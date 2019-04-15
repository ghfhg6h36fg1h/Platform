package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
    /**
     *
     * @mbggenerated 2018-05-16
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-16
     */
    int insert(Menu record);

    /**
     *
     * @mbggenerated 2018-05-16
     */
    int insertSelective(Menu record);

    /**
     *
     * @mbggenerated 2018-05-16
     */
    Menu selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-16
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     *
     * @mbggenerated 2018-05-16
     */
    int updateByPrimaryKey(Menu record);
}