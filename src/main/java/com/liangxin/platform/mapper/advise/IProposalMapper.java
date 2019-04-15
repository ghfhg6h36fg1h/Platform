package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.Proposal;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListOAInput;
import com.liangxin.platform.common.entity.advise.outputResult.proposal.ListOutResult;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListInput;
import com.liangxin.platform.common.entity.advise.outputResult.proposal.ProposalStatisticOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface IProposalMapper {
     List<ListOutResult> getAll(@Param("pListInput") ListInput pListInput);
     List<ListOutResult> getOAAll(@Param("pListOAInput") ListOAInput pListOAInput);
     int addProposal(Proposal pProposal);
     List<ListOutResult> getById(@Param("pId") String pId);
     int update(Proposal pProposal);
     int updateByOwner(Proposal pProposal);
     String getCapitalIdById(@Param("pId") String pId);
     List<ProposalStatisticOut> getStatisticProposal(@Param("pListOAInput") ListOAInput pListOAInput);
}
