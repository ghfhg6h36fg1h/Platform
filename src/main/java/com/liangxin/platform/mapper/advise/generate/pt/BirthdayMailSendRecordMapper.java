package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.BirthdayMailSendRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BirthdayMailSendRecordMapper {
    /**
     *
     * @mbggenerated 2018-07-26
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-07-26
     */
    int insert(BirthdayMailSendRecord record);

    /**
     *
     * @mbggenerated 2018-07-26
     */
    int insertSelective(BirthdayMailSendRecord record);

    /**
     *
     * @mbggenerated 2018-07-26
     */
    BirthdayMailSendRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-07-26
     */
    int updateByPrimaryKeySelective(BirthdayMailSendRecord record);

    /**
     *
     * @mbggenerated 2018-07-26
     */
    int updateByPrimaryKey(BirthdayMailSendRecord record);
}