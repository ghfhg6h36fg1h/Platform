package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListInput;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListOAInput;
import com.liangxin.platform.common.entity.advise.outputResult.New_proposal.*;
import com.liangxin.platform.common.entity.advise.outputResult.proposal.ListOutResult;
import com.liangxin.platform.common.entity.advise.outputResult.proposal.ProposalStatisticOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface INew_ProposalMapper {
    //总数+总实施数
    List<AllSumOutResult> getSumData(@Param("StartTime") String StartTime, @Param("EndTime") String EndTime);

    int getUserNum(@Param("StartTime") String StartTime, @Param("EndTime") String EndTime);


    //个人总数+实施数
    List<AllSumOutResult> getPersonData(@Param("empno") String empno, @Param("StartTime") String StartTime, @Param("EndTime") String EndTime);

    int getPersonUserNum(@Param("empno") String empno, @Param("StartTime") String StartTime, @Param("EndTime") String EndTime);


    List<RankOutResult> getClaRank(@Param("StartTime") String StartTime, @Param("EndTime") String EndTime);

    List<RankOutResult> getPerRank(@Param("StartTime") String StartTime, @Param("EndTime") String EndTime);

    List<New_ListOutResult> NewGetAll(ListInput listInput);

    List<PersonInfoOutResult> GetInfo(@Param("empno")String empno);

    String GetDepart(String empno);


    List<OAStepOutResult> selectOAByID(String id);

    List<New_ListOutResult> NewGetAllGood(ListInput listInput);

    List<New_ListOutResult> getWebAll(ListOAInput pListOAInput);

    List<ProposalStatisticOut> NewGetStatisticProposal(ListOAInput pListOAInput);

    List<RankOutResult> getOrgRank(@Param("empno")String empno);

    String getImplementName(@Param("empno")String empno);
}