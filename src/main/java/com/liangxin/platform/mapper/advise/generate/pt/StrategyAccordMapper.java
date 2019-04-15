package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.StrategyAccord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StrategyAccordMapper {
    /**
     *
     * @mbggenerated 2018-12-04
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-12-04
     */
    int insert(StrategyAccord record);

    /**
     *
     * @mbggenerated 2018-12-04
     */
    int insertSelective(StrategyAccord record);

    /**
     *
     * @mbggenerated 2018-12-04
     */
    StrategyAccord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-12-04
     */
    int updateByPrimaryKeySelective(StrategyAccord record);

    /**
     *
     * @mbggenerated 2018-12-04
     */
    int updateByPrimaryKey(StrategyAccord record);
}