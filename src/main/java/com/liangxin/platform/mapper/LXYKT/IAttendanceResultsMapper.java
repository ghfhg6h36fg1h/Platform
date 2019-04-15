package com.liangxin.platform.mapper.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.AttendanceResultsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IAttendanceResultsMapper {
    List<AttendanceResultsInfo> getAttendanceResultsInfo(@Param("empno") String empno, @Param("startdate") String startdate, @Param("enddate") String enddate);
    List<AttendanceResultsInfo> getAttendanceResultsInitalInfo(@Param("empno") String empno);
}