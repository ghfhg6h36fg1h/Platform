package com.liangxin.platform.mapper.KPI;


import com.liangxin.platform.common.entity.KPI.TeamOverfulfillBonus;
import com.liangxin.platform.common.entity.KPI.inputParam.InputPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ITeamOverfulfillBonusMapper {
    List<TeamOverfulfillBonus> getTeamOverfulfillBonus();
    List<TeamOverfulfillBonus> getTeamBonus(InputPage gInputPage);
}
