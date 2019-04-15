package com.liangxin.platform.service.KPI;

import com.liangxin.platform.common.entity.KPI.EmployeeBonus;
import com.liangxin.platform.common.entity.KPI.EmployeePerformanceImport;
import com.liangxin.platform.common.entity.KPI.TeamOverfulfillBonus;
import com.liangxin.platform.common.entity.KPI.TeamPerformance;
import com.liangxin.platform.common.tools.HttpTool;
import com.liangxin.platform.common.tools.SplitListByNum;
import com.liangxin.platform.common.tools.excel.ReadExcel;
import com.liangxin.platform.mapper.KPI.IBonusMapper;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class BonusService {
    private final Logger gLog = LogManager.getLogger(BonusService.class);
    @Value("${KPI.appId}")
    private String gappId;
    /** list上限 不建议改动*/
    private int len=50;
    @Autowired
    private IBonusMapper gIBonusMapper;

    public String readExcelFile(MultipartFile file) {
        String result = "";
        //创建处理EXCEL的类
        ReadExcel readExcel = new ReadExcel();
        //解析excel，获取上传的事件单
        try {

            Workbook mWorkbook = readExcel.getWorkbook(file);
            List<TeamOverfulfillBonus> teamOverfulfillBonusList = readExcel.getExcelInfo0(mWorkbook, 0);
            List<EmployeePerformanceImport> employeePerformanceImportList = readExcel.getExcelInfo1(mWorkbook, 1);
            List<EmployeeBonus> employeeBonusList = readExcel.getExcelInfo2(mWorkbook, 2);
            List<TeamPerformance> teamPerformanceList = readExcel.getExcelInfo3(mWorkbook, 3);
            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作
            if (teamOverfulfillBonusList != null && !teamOverfulfillBonusList.isEmpty()) {
                gIBonusMapper.deleteTeamOverfulfillBonus(teamOverfulfillBonusList);

              List<List<TeamOverfulfillBonus>> resultList= SplitListByNum.splitList(teamOverfulfillBonusList,len) ;

               for (List list:resultList)
                gIBonusMapper.insertTeamOverfulfillBonus(list);
//                gIBonusMapper.insertTeamOverfulfillBonus(teamOverfulfillBonusList);

                result = "上传成功";

            } else {
                result = "获取班组超产奖金数据为空，请检查班组超产奖金数据合法性";
                return result;
            }
            if (employeePerformanceImportList != null && !employeePerformanceImportList.isEmpty()) {
                gIBonusMapper.deleteEmployeePerformance(employeePerformanceImportList);

                List<List<EmployeePerformanceImport>> resultList= SplitListByNum.splitList(employeePerformanceImportList,len) ;
                for (List list:resultList)
                gIBonusMapper.insertEmployeePerformance(list);
            //    gIBonusMapper.insertEmployeePerformance(employeePerformanceImportList);

            } else {
                result = "获取员工个人绩效数据为空，请检查员工个人绩效数据合法性";
                return result;
            }
            if (employeeBonusList != null && !employeeBonusList.isEmpty()) {
                gIBonusMapper.deleteEmployeeBonus(employeeBonusList);

                List<List<EmployeeBonus>> resultList= SplitListByNum.splitList(employeeBonusList,len) ;
                for (List list:resultList)
                gIBonusMapper.insertEmployeeBonus(list);
             //   gIBonusMapper.insertEmployeeBonus(employeeBonusList);

            } else {
                result = "获取员工个人奖金数据为空，请检查员工个人奖金数据合法性";
                return result;
            }
            if (teamPerformanceList != null && !teamPerformanceList.isEmpty()) {
                gIBonusMapper.deleteTeamPerformance(teamPerformanceList);

                List<List<TeamPerformance>> resultList= SplitListByNum.splitList(teamPerformanceList,len) ;
                for (List list:resultList)
                gIBonusMapper.insertTeamPerformance(list);
              //  gIBonusMapper.insertTeamPerformance(teamPerformanceList);
            } else {
                result = "获取班组绩效数据为空，请检查班组绩效数据合法性";
                return result;
            }
        } catch (
                Exception e)

        {
            gLog.error(e.toString());
        }
        return result;
    }

    public void pushEmployeePerformanceBonus(){
        String GETTOKENURL = "https://portal.sh-liangxin.com/appsapi/token/apptoken";
        String PARAS="corpid=X6HGI658CAMzfglk&corpsecret=UcbPm4nAejTaBvAgaZNDdIqx4NqKHN9j&appid=" + gappId;
        String POSTURL = "https://portal.sh-liangxin.com/appsapi/message/send?app_access_token=";
        List<EmployeeBonus> mEmployeeBonus = gIBonusMapper.getEmployeeBonus();
        try{
            gLog.info("EmployeePerformanceBonus PushMission Started");
            for(EmployeeBonus eb : mEmployeeBonus){
                int createTime = (int)(System.currentTimeMillis());
                String userid = eb.getEmployeeNo();
                gLog.info(userid);
                String content = pushContent(eb.getEmployeeNo(),eb.getName(),eb.getPrdDate(),eb.getRank(),eb.getPerBonus());
                String msgType = "text";
                String type = "num";
                String gettoken = null;
                try {
//                    gettoken = HttpTool.getToken(GETTOKENURL);
                    gettoken=HttpTool.sendGet(GETTOKENURL,PARAS);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                JSONObject j = JSONObject.fromObject(gettoken);
                String token = j.getString("app_access_token");
                String url = POSTURL + token;
                //System.out.println(url);
                JSONObject jb = new JSONObject();
                jb.put("UserId", userid);
                jb.put("MsgType", msgType);
                jb.put("Content",content);
                jb.put("CreateTime", createTime);
                jb.put("Type", type);
                String mPostParas="UserId="+userid+"&MsgType="+msgType+"&Content="+content+"&CreateTime="+createTime+"&Type="+type;
                //System.out.println(jb.toString());
                String result = null;
                try {
                    //result = HttpTool.postString(url,jb.toString());
                    result = HttpTool.sendPost(url,mPostParas);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    gLog.error(e.toString());
                }
                gLog.info(result);
            }
        }catch (Exception e){
            gLog.error(e.toString());
        }
    }

    private String pushContent(String empno , String name ,String prdDate ,String rank ,String perBonus){
        return "您好：" + name + "(" + empno + ")\r\n" + "截止" + prdDate + ",您的当月职级为" + rank + ",个人奖金为" + perBonus + "元。请注意查看，谢谢！";
    }

}
