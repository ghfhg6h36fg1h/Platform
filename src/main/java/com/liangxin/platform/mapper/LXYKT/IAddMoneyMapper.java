package com.liangxin.platform.mapper.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.AddMoneyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IAddMoneyMapper {
    List<AddMoneyInfo> getAddMoneyInfo(@Param("empno") String empno, @Param("startdate") String startdate, @Param("enddate") String enddate);
    List<AddMoneyInfo> getAddMoneyInitalInfo(@Param("empno") String empno);
}
