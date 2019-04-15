package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.outputResult.proposalStatus.ProposalStatusListOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IProposalStatusMapper {
    String getNameById(@Param("pId") String pId);
    List<ProposalStatusListOut> getAll();
}
