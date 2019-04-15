package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.RegularBus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegularBusMapper {
    /**
     *
     * @mbggenerated 2018-07-05
     */
    int deleteByPrimaryKey(Object id);

    /**
     *
     * @mbggenerated 2018-07-05
     */
    int insert(RegularBus record);

    /**
     *
     * @mbggenerated 2018-07-05
     */
    int insertSelective(RegularBus record);

    /**
     *
     * @mbggenerated 2018-07-05
     */
    RegularBus selectByPrimaryKey(Object id);

    /**
     *
     * @mbggenerated 2018-07-05
     */
    int updateByPrimaryKeySelective(RegularBus record);

    /**
     *
     * @mbggenerated 2018-07-05
     */
    int updateByPrimaryKey(RegularBus record);
}