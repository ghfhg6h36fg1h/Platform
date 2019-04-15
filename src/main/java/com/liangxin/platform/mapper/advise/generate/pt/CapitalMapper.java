package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.Capital;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CapitalMapper {
    /**
     *
     * @mbggenerated 2018-05-10
     */
    int deleteByPrimaryKey(Object id);

    /**
     *
     * @mbggenerated 2018-05-10
     */
    int insert(Capital record);

    /**
     *
     * @mbggenerated 2018-05-10
     */
    int insertSelective(Capital record);

    /**
     *
     * @mbggenerated 2018-05-10
     */
    Capital selectByPrimaryKey(Object id);

    /**
     *
     * @mbggenerated 2018-05-10
     */
    int updateByPrimaryKeySelective(Capital record);

    /**
     *
     * @mbggenerated 2018-05-10
     */
    int updateByPrimaryKey(Capital record);
}