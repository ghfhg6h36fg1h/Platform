package com.liangxin.platform.mapper.tax.pt;

import com.liangxin.platform.common.entity.tax.pt.Tax;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaxMapper {
    /**
     *
     * @mbggenerated 2018-11-26
     */
    int deleteByPrimaryKey(String sid);

    /**
     *
     * @mbggenerated 2018-11-26
     */
    int insert(Tax record);

    /**
     *
     * @mbggenerated 2018-11-26
     */
    int insertSelective(Tax record);

    /**
     *
     * @mbggenerated 2018-11-26
     */
    Tax selectByPrimaryKey(String sid);

    /**
     *
     * @mbggenerated 2018-11-26
     */
    int updateByPrimaryKeySelective(Tax record);

    /**
     *
     * @mbggenerated 2018-11-26
     */
    int updateByPrimaryKey(Tax record);
}