package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.ContractExpireRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContractExpireRecordMapper {
    /**
     *
     * @mbggenerated 2018-08-01
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-08-01
     */
    int insert(ContractExpireRecord record);

    /**
     *
     * @mbggenerated 2018-08-01
     */
    int insertSelective(ContractExpireRecord record);

    /**
     *
     * @mbggenerated 2018-08-01
     */
    ContractExpireRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-08-01
     */
    int updateByPrimaryKeySelective(ContractExpireRecord record);

    /**
     *
     * @mbggenerated 2018-08-01
     */
    int updateByPrimaryKey(ContractExpireRecord record);
}