package com.liangxin.platform.mapper.advise;


import com.liangxin.platform.common.entity.advise.generate.pt.New_Integral;
import com.liangxin.platform.common.entity.advise.generate.pt.New_IntegralDetail;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ChangeMoneyInput;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListOAInput;
import com.liangxin.platform.common.entity.advise.outputResult.New_proposal.IntegralListOutResult;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface INew_IntegralMapper {
    New_Integral getTopData(@Param("empno") String empno);

    List<IntegralListOutResult> getListData(@Param("empno") String empno);


    int ChangeIntegral(ChangeMoneyInput changeMoneyInput);

    List<IntegralListOutResult> getWebIntegralList(ListOAInput listOAInput);

    List<IntegralListOutResult> getWebIntegralListByState(String state);

    int updateWebIntegralListByState(@Param("state")String state);

    List<IntegralListOutResult> getWebIntegralListByName(ListOAInput listOAInput);

    List<IntegralListOutResult> getWebIntegralListByEmpno(ListOAInput listOAInput);
}