package com.liangxin.platform.mapper.KPI;


import com.liangxin.platform.common.entity.KPI.TeamPerformance;
import com.liangxin.platform.common.entity.KPI.inputParam.InputPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ITeamPerformanceMapper {
    List<TeamPerformance> getTeamPerformance();
    List<TeamPerformance> getTeamPerformanceList(InputPage gInputPage);
}
