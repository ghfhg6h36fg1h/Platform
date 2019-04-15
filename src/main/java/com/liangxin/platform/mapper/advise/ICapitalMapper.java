package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.inputParam.capital.InputForOAList;
import com.liangxin.platform.common.entity.advise.outputResult.capital.ListCapital;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICapitalMapper {

     int isCapital(@Param("pWorkId") String pWorkId);

     List<ListCapital> getCapitalList();

     List<ListCapital> getCapitalListForOA(@Param("pInputForOAList") InputForOAList pInputForOAList);

}
