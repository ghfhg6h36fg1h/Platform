package com.liangxin.platform.service.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.SwingCardInfo;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.tools.StringUtils;
import com.liangxin.platform.mapper.LXYKT.ISwingCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Service
public class SwingCardService {
    private final Logger gLog = LogManager.getLogger(SwingCardService.class);
    @Autowired
    private ISwingCardMapper gISwingCardMapper;

    public OutResult getSwingCardInfo(String empno,String startdate,String enddate){
        OutResult mOutResult = new OutResult();
        try{
            if (StringUtils.isNotEmpty(empno)){
                if (StringUtils.isNotEmpty(startdate) && StringUtils.isNotEmpty(enddate)){
                    List<SwingCardInfo> mSwingCardInfo =  gISwingCardMapper.getSwingCardInfo(empno, startdate, enddate);
                    mOutResult.setData(mSwingCardInfo);
                    mOutResult.setCode(0);
                    mOutResult.setMsg("成功");
                }
                else {
                    List<SwingCardInfo> mSwingCardInfo =  gISwingCardMapper.getSwingCardInitalInfo(empno);
                    mOutResult.setData(mSwingCardInfo);
                    mOutResult.setCode(0);
                    mOutResult.setMsg("成功");
                }
            }
            else {
                mOutResult.setCode(1);
                mOutResult.setMsg("失败,工号不能为空");
                gLog.error("request error empno is null,please check it!");
            }
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }
}