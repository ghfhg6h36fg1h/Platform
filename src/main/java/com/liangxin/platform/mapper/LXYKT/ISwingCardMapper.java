package com.liangxin.platform.mapper.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.SwingCardInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ISwingCardMapper {
    List<SwingCardInfo> getSwingCardInfo(@Param("empno") String empno, @Param("startdate") String startdate, @Param("enddate") String enddate);
    List<SwingCardInfo> getSwingCardInitalInfo(@Param("empno") String empno);
}
