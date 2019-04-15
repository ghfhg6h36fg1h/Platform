package com.liangxin.platform.service.KPI;

import com.liangxin.platform.common.entity.KPI.EmployeeBonus;
import com.liangxin.platform.common.entity.KPI.EmployeePerformance;
import com.liangxin.platform.common.entity.KPI.EmployeePerformanceBonus;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.mapper.KPI.IEmployeePerformanceBonusbysidMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePerformanceBonusbysidService {
    private final Logger gLog = LogManager.getLogger(EmployeePerformanceBonusbysidService.class);
    @Autowired
    private IEmployeePerformanceBonusbysidMapper gIEmployeePerformanceBonusbysidMapper;

    public OutResult getEmployeePerformanceBonusbysid(String sid){
        OutResult mOutResult = new OutResult();
        try {
            List<EmployeeBonus> mEmployeeBonus = gIEmployeePerformanceBonusbysidMapper.getEmployeeBonusbysid(sid);
            List<EmployeePerformanceBonus> mEmployeePerformanceBonus = getEPBList(mEmployeeBonus);
            mOutResult.setData(mEmployeePerformanceBonus);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功");
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public OutResult getEmployeeBonusbysid(String sid){
        OutResult mOutResult = new OutResult();
        try {
            List<EmployeeBonus> mEmployeeBonus = gIEmployeePerformanceBonusbysidMapper.getEmployeeBonusbysid(sid);
            mOutResult.setData(mEmployeeBonus);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功");
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public List<EmployeePerformanceBonus> getEPBList(List<EmployeeBonus> eblist){
        List<EmployeePerformanceBonus> epblist = new ArrayList<EmployeePerformanceBonus>();
        try{
            for(EmployeeBonus eb: eblist){
                EmployeePerformanceBonus epb = new EmployeePerformanceBonus();
                String employeeNo = eb.getEmployeeNo();
                String prdDate = eb.getPrdDate();
                EmployeePerformance ep = gIEmployeePerformanceBonusbysidMapper.getEmployeePerformancebysid(employeeNo,prdDate);
                epb.setSid(eb.getSid());
                epb.setWorkShop(eb.getWorkShop());
                epb.setEmployeeNo(eb.getEmployeeNo());
                epb.setName(eb.getName());
                epb.setLineName(eb.getLineName());
                epb.setTeamOverfulfillBonus(eb.getTeamOverfulfillBonus());
                epb.setWastage(eb.getWastage());
                epb.setDeductBonus(eb.getDeductBonus());
                epb.setTeamPerformanceBonus(eb.getTeamPerformanceBonus());
                epb.setBonusFactor(eb.getBonusFactor());
                epb.setPerBonus(eb.getPerBonus());
                epb.setRank(eb.getRank());
                epb.setPrdDate(eb.getPrdDate());
                if(ep != null){
                    epb.setQualityViolation(ep.getQualityViolation());
                    epb.setRanking1(ep.getRanking1());
                    epb.setCrossCheckViolations(ep.getCrossCheckViolations());
                    epb.setRanking2(ep.getRanking2());
                    epb.setAttendanceViolation(ep.getAttendanceViolation());
                    epb.setRanking3(ep.getRanking3());
                    epb.setCasualLeave(ep.getCasualLeave());
                    epb.setRanking4(ep.getRanking4());
                    epb.setWorkshopDiscipline(ep.getWorkshopDiscipline());
                    epb.setRanking5(ep.getRanking5());
                    epb.setPpeWearStandard(ep.getPpeWearStandard());
                    epb.setRanking6(ep.getRanking6());
                    epb.setTrafficSafety(ep.getTrafficSafety());
                    epb.setRanking7(ep.getRanking7());
                    epb.setRedCardPosting(ep.getRedCardPosting());
                    epb.setRanking8(ep.getRanking8());
                    epb.setTypicalEvents(ep.getTypicalEvents());
                    epb.setRanking9(ep.getRanking9());
                }
                epblist.add(epb);
            }
        }catch(Exception e){
            gLog.error(e.toString());
        }
        return epblist;
    }
}
