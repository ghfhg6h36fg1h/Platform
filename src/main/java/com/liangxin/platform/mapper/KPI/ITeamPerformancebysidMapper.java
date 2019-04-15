package com.liangxin.platform.mapper.KPI;


import com.liangxin.platform.common.entity.KPI.TeamPerformance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ITeamPerformancebysidMapper {
    List<TeamPerformance> getTeamPerformancebysid(@Param("sid") String sid);
}
