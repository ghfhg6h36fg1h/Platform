package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.ProjectRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectRecordMapper {
    /**
     *
     * @mbggenerated 2018-11-22
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-11-22
     */
    int insert(ProjectRecord record);

    /**
     *
     * @mbggenerated 2018-11-22
     */
    int insertSelective(ProjectRecord record);

    /**
     *
     * @mbggenerated 2018-11-22
     */
    ProjectRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-11-22
     */
    int updateByPrimaryKeySelective(ProjectRecord record);

    /**
     *
     * @mbggenerated 2018-11-22
     */
    int updateByPrimaryKey(ProjectRecord record);
}