package com.liangxin.platform.mapper.KPI;

import com.liangxin.platform.common.entity.KPI.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IBonusMapper {
    int insertTeamOverfulfillBonus(@Param("teamOverfulfillBonusList") List<TeamOverfulfillBonus> teamOverfulfillBonusList);

    int deleteTeamOverfulfillBonus(@Param("teamOverfulfillBonusList") List<TeamOverfulfillBonus> teamOverfulfillBonusList);

    int insertEmployeePerformance(@Param("employeePerformanceImportList") List<EmployeePerformanceImport> employeePerformanceImportList);

    int deleteEmployeePerformance(@Param("employeePerformanceImportList") List<EmployeePerformanceImport> employeePerformanceImportList);

    int insertEmployeeBonus(@Param("employeeBonusList") List<EmployeeBonus> employeeBonusList);

    int deleteEmployeeBonus(@Param("employeeBonusList") List<EmployeeBonus> employeeBonusList);

    int insertTeamPerformance(@Param("teamPerformanceList") List<TeamPerformance> teamPerformanceList);

    int deleteTeamPerformance(@Param("teamPerformanceList") List<TeamPerformance> teamPerformanceList);

    List<EmployeeBonus> getEmployeeBonus();
}
