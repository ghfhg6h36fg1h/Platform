package com.liangxin.platform.mapper.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.TripInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ITripMapper {
    List<TripInfo> getTripInfo(@Param("empno") String empno, @Param("startdate") String startdate, @Param("enddate") String enddate);
    List<TripInfo> getTripInitalInfo(@Param("empno") String empno);
}
