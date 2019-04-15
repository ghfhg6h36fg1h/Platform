package com.liangxin.platform.mapper.advise.generate.pt;

import com.liangxin.platform.common.entity.advise.generate.pt.New_PROPOSAL;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListOAInput;
import com.liangxin.platform.common.entity.advise.outputResult.proposal.ListOutResult;

import java.util.List;

public interface New_PROPOSALMapper {
    int deleteByPrimaryKey(String id);

    int insert(New_PROPOSAL record);

    int insertSelective(New_PROPOSAL record);

    New_PROPOSAL selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(New_PROPOSAL record);

    int updateByPrimaryKey(New_PROPOSAL record);


}