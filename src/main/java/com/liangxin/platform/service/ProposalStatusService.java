package com.liangxin.platform.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.advise.outputResult.proposalStatus.ProposalStatusListOut;
import com.liangxin.platform.mapper.advise.IProposalStatusMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalStatusService {
    private final Logger gLog = LogManager.getLogger(ProposalStatusService.class);

    @Autowired
    private IProposalStatusMapper gIProposalStatusMapper;
    public String getNameById(String pId){
        String mRValue="";
        try{
            mRValue=gIProposalStatusMapper.getNameById(pId);
        }catch (Exception ex){
            gLog.error("通过id获取状态接口出错！",ex);
        }
        return  mRValue;
    }
    public OutResult getAll(){
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(1, 10000, true);
            List<ProposalStatusListOut> mRvalue = gIProposalStatusMapper.getAll();
            PageInfo<ProposalStatusListOut> pageInfo = new PageInfo<>(mRvalue);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(1);
            mOutResult.setIsSuccess(true);
            mOutResult.setData(pageInfo.getList());
            mOutResult.setMsg("成功！");
        } catch (Exception ex) {
            mOutResult.setCode(0);
            mOutResult.setIsSuccess(false);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }
}
