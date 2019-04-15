package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.generate.pt.ProjectRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IProjectRecordMapper {

    List<ProjectRecord> selectByCondition(ProjectRecord pProjectRecord);

}
