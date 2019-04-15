package com.liangxin.platform.mapper.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.ClockPushInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IClockPushMapper {
    List<ClockPushInfo> getClockPushInfo();
}
