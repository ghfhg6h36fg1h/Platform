package com.liangxin.platform.service.KPI;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liangxin.platform.common.entity.KPI.EmployeeBonus;
import com.liangxin.platform.common.entity.KPI.EmployeePerformance;
import com.liangxin.platform.common.entity.KPI.EmployeePerformanceBonus;
import com.liangxin.platform.common.entity.KPI.EmployeePerformanceImport;
import com.liangxin.platform.common.entity.KPI.inputParam.InputPage;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.mapper.KPI.IEmployeePerformanceBonusMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePerformanceBonusService {
    private final Logger gLog = LogManager.getLogger(EmployeePerformanceBonusService.class);
    @Autowired
    private IEmployeePerformanceBonusMapper gIEmployeePerformanceBonusMapper;

    public OutResult getEmployeePerformanceBonus(String employeeNo,String lineName){
        OutResult mOutResult = new OutResult();
        try {
            List<EmployeeBonus> mEmployeeBonus = gIEmployeePerformanceBonusMapper.getEmployeeBonus(employeeNo,lineName);
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

    public OutResult getEmployeePerformanceImportbysid(String sid){
        OutResult mOutResult = new OutResult();
        try {
            List<EmployeePerformanceImport> memployeePerformanceImport = gIEmployeePerformanceBonusMapper.getEmployeePerformanceImportbysid(sid);
            mOutResult.setData(memployeePerformanceImport);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功");
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public OutResult getEmployeePerformanceImport(InputPage gInputPage){
        OutResult mOutResult = new OutResult();
        try {
            Page mPage = PageHelper.startPage(gInputPage.getPageIndex(), gInputPage.getPageSize(),true);
            List<EmployeePerformanceImport> memployeeBonusmployeePerformanceImport = gIEmployeePerformanceBonusMapper.getEmployeePerformanceImport(gInputPage);
            mOutResult.setData(memployeeBonusmployeePerformanceImport);
            mOutResult.setTotalCount(mPage.getTotal());
            mOutResult.setIsSuccess(true);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功");
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public OutResult getEmployeeBonusList(InputPage gInputPage){
        OutResult mOutResult = new OutResult();
        try {
            Page mPage = PageHelper.startPage(gInputPage.getPageIndex(), gInputPage.getPageSize(),true);
            List<EmployeeBonus> memployeeBonus = gIEmployeePerformanceBonusMapper.getEmployeeBonusList(gInputPage);
            mOutResult.setData(memployeeBonus);
            mOutResult.setTotalCount(mPage.getTotal());
            mOutResult.setIsSuccess(true);
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
                EmployeePerformance ep = gIEmployeePerformanceBonusMapper.getEmployeePerformance(employeeNo, prdDate);
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
