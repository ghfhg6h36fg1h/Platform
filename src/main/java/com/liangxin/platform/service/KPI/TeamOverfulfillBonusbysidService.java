package com.liangxin.platform.service.KPI;

import com.liangxin.platform.common.entity.KPI.TeamOverfulfillBonus;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.tools.StringUtils;
import com.liangxin.platform.mapper.KPI.ITeamOverfulfillBonusbysidMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamOverfulfillBonusbysidService {
    private final Logger gLog = LogManager.getLogger(TeamOverfulfillBonusbysidService.class);
    @Autowired
    private ITeamOverfulfillBonusbysidMapper gITeamOverfulfillBonusbysidMapper;

    public OutResult getTeamOverfulfillBonusbysid(String sid){
        OutResult mOutResult = new OutResult();
            try {
                if(StringUtils.isNotEmpty(sid)) {
                    List<TeamOverfulfillBonus> mteamOverfulfillBonus = gITeamOverfulfillBonusbysidMapper.getTeamOverfulfillBonusbysid(sid);
                    mOutResult.setData(mteamOverfulfillBonus);
                    mOutResult.setCode(0);
                    mOutResult.setMsg("成功");
                }else {
                    mOutResult.setCode(1);
                    mOutResult.setMsg("失败,sid不能为空");
                    gLog.error("request error sid is null,please check it!");
                }
            } catch (Exception e) {
                mOutResult.setCode(1);
                mOutResult.setMsg("失败：" + e.toString());
                gLog.error(e.toString());
            }
        return mOutResult;
    }
}
