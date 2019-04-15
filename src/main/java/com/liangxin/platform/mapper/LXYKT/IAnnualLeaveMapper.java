package com.liangxin.platform.mapper.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.AnnualLeaveInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface IAnnualLeaveMapper {
    String getWorkAgeInfo(@Param("empno") String empno);
    String getDayInfo(@Param("nxjid") String nxjid);
    String getFreeDayInfo(@Param("nxjid") String nxjid);
    List<String> getDayoffInfo(@Param("empno") String empno);
    AnnualLeaveInfo getAnnualLeaveInfo(@Param("empno") String empno);
}
