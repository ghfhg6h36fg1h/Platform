package com.liangxin.platform.mapper.KPI;


import com.liangxin.platform.common.entity.KPI.EmployeeBonus;
import com.liangxin.platform.common.entity.KPI.EmployeePerformance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IEmployeePerformanceBonusbysidMapper {
    List<EmployeeBonus> getEmployeeBonusbysid(@Param("sid") String sid);
    EmployeePerformance getEmployeePerformancebysid(@Param("employeeNo") String employeeNo,@Param("prdDate") String prdDate);
}
