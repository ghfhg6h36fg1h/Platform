package com.liangxin.platform.mapper.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.OvertimeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IOverTimeMapper {
    List<OvertimeInfo> getOverTimeInfo(@Param("empno") String empno, @Param("startdate") String startdate, @Param("enddate") String enddate);
    List<OvertimeInfo> getOverTimeInitalInfo(@Param("empno") String empno);
}
