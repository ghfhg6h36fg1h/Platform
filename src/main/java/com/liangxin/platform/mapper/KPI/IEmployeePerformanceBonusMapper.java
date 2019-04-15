package com.liangxin.platform.mapper.KPI;


import com.liangxin.platform.common.entity.KPI.EmployeeBonus;
import com.liangxin.platform.common.entity.KPI.EmployeePerformance;
import com.liangxin.platform.common.entity.KPI.EmployeePerformanceImport;
import com.liangxin.platform.common.entity.KPI.inputParam.InputPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IEmployeePerformanceBonusMapper {
    List<EmployeeBonus> getEmployeeBonus(@Param("employeeNo") String employeeNo,@Param("lineName") String lineName);
    List<EmployeeBonus> getEmployeeBonusList(InputPage gInputPage);
    EmployeePerformance getEmployeePerformance(@Param("employeeNo") String employeeNo,@Param("prdDate") String prdDate);
    List<EmployeePerformanceImport> getEmployeePerformanceImport(InputPage gInputPage);
    List<EmployeePerformanceImport> getEmployeePerformanceImportbysid(@Param("sid") String sid);
}
