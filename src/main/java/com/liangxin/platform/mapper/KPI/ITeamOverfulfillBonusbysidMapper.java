package com.liangxin.platform.mapper.KPI;


import com.liangxin.platform.common.entity.KPI.TeamOverfulfillBonus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ITeamOverfulfillBonusbysidMapper {
    List<TeamOverfulfillBonus> getTeamOverfulfillBonusbysid(@Param("sid") String sid);
}
