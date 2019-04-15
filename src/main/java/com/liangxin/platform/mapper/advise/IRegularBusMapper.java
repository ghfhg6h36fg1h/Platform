package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.generate.pt.RegularBus;
import com.liangxin.platform.common.entity.advise.inputParam.regularBus.RegularBusInputForGetAllList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IRegularBusMapper {
    List<RegularBus> getAll(@Param("pRegularBusInputForGetAllList") RegularBusInputForGetAllList pRegularBusInputForGetAllList);
    String getMaxUpdateTime();
}
