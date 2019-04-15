package com.liangxin.platform.mapper.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.OtUseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IOtUseMapper {
    List<OtUseInfo> getOtUseInfo(@Param("empno") String empno, @Param("startdate") String startdate, @Param("enddate") String enddate);
    List<OtUseInfo> getOtUseInitalInfo(@Param("empno") String empno);
}
