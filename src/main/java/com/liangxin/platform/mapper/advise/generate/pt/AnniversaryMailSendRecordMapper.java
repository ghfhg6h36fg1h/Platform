package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.AnniversaryMailSendRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnniversaryMailSendRecordMapper {
    /**
     *
     * @mbggenerated 2018-07-26
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-07-26
     */
    int insert(AnniversaryMailSendRecord record);

    /**
     *
     * @mbggenerated 2018-07-26
     */
    int insertSelective(AnniversaryMailSendRecord record);

    /**
     *
     * @mbggenerated 2018-07-26
     */
    AnniversaryMailSendRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-07-26
     */
    int updateByPrimaryKeySelective(AnniversaryMailSendRecord record);

    /**
     *
     * @mbggenerated 2018-07-26
     */
    int updateByPrimaryKey(AnniversaryMailSendRecord record);
}