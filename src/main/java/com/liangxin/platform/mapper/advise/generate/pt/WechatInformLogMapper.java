package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.WechatInformLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WechatInformLogMapper {
    /**
     *
     * @mbggenerated 2018-11-22
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-11-22
     */
    int insert(WechatInformLog record);

    /**
     *
     * @mbggenerated 2018-11-22
     */
    int insertSelective(WechatInformLog record);

    /**
     *
     * @mbggenerated 2018-11-22
     */
    WechatInformLog selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-11-22
     */
    int updateByPrimaryKeySelective(WechatInformLog record);

    /**
     *
     * @mbggenerated 2018-11-22
     */
    int updateByPrimaryKey(WechatInformLog record);
}