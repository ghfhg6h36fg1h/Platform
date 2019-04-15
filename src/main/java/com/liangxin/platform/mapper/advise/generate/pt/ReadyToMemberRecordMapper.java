package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.ReadyToMemberRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReadyToMemberRecordMapper {
    /**
     *
     * @mbggenerated 2018-08-01
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-08-01
     */
    int insert(ReadyToMemberRecord record);

    /**
     *
     * @mbggenerated 2018-08-01
     */
    int insertSelective(ReadyToMemberRecord record);

    /**
     *
     * @mbggenerated 2018-08-01
     */
    ReadyToMemberRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-08-01
     */
    int updateByPrimaryKeySelective(ReadyToMemberRecord record);

    /**
     *
     * @mbggenerated 2018-08-01
     */
    int updateByPrimaryKey(ReadyToMemberRecord record);
}