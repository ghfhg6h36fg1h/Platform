package com.liangxin.platform.mapper.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.ConsumeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IConsumeMapper {
    List<ConsumeInfo> getConsumeInfo(@Param("empno") String empno, @Param("startdate") String startdate, @Param("enddate") String enddate);
    List<ConsumeInfo> getConsumeInitalInfo(@Param("empno") String empno);
}