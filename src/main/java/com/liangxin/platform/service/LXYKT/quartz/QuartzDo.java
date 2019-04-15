package com.liangxin.platform.service.LXYKT.quartz;

import com.liangxin.platform.common.entity.LXYKT.ClockPushInfo;
import com.liangxin.platform.common.tools.HttpTool;
import com.liangxin.platform.mapper.LXYKT.IClockPushMapper;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.liangxin.platform.common.tools.StringUtils.mergeContent;

@Service
public class QuartzDo {

    private final Logger gLog = LogManager.getLogger(QuartzDo.class);

    @Value("${LXYKT.appId}")
    private String gappId;
    //获取token的url
    //private final static String GETTOKENURL = "https://portal.sh-liangxin.com/appsapi/token/apptoken?corpid=X6HGI658CAMzfglk&corpsecret=UcbPm4nAejTaBvAgaZNDdIqx4NqKHN9j&appid=adc1fd32d9ca7ed26fe294a94fb09219";
    //private final  String GETTOKENURL = "https://portal.sh-liangxin.com/appsapi/token/apptoken?corpid=X6HGI658CAMzfglk&corpsecret=UcbPm4nAejTaBvAgaZNDdIqx4NqKHN9j&appid=88d75c24b94bd1b4d73b916ea8eea62c";
    //private final String GETTOKENURL = "https://portal.sh-liangxin.com/appsapi/token/apptoken?corpid=X6HGI658CAMzfglk&corpsecret=UcbPm4nAejTaBvAgaZNDdIqx4NqKHN9j&appid=" + gappId;

    //向协同发送补打卡等数据的POST请求URL
    //private final static String POSTURL = "https://portal.sh-liangxin.com/appsapi/message/send?app_access_token=";
    //public final static String POSTURL = "https://portal.sh-liangxin.com/appsapi/message/send";
    @Resource
    private IClockPushMapper gIClockPushMapper;

    @Scheduled(cron = "${LXYKT.clockPush.schedule}")
    public void run() {
        gLog.info("执行时间：" + String.valueOf(new Date()) + "考勤异常推送开始");
        // TODO Auto-generated method stub
        String GETTOKENURL = "https://portal.sh-liangxin.com/appsapi/token/apptoken";
        String PARAS = "corpid=X6HGI658CAMzfglk&corpsecret=UcbPm4nAejTaBvAgaZNDdIqx4NqKHN9j&appid=" + gappId;
        String POSTURL = "https://portal.sh-liangxin.com/appsapi/message/send?app_access_token=";
        List<ClockPushInfo> mClockPushInfo = getClockPushInfoList();
        try {
            if (null == mClockPushInfo || 0 == mClockPushInfo.size()) {
                gLog.info("执行时间：" + String.valueOf(new Date()) + "无考勤异常记录");
                return;
            }
            for (ClockPushInfo cpi : mClockPushInfo) {
                int createTime = (int) (System.currentTimeMillis());
                String userid = cpi.getEmpno();
                gLog.info(userid);
                String content = mergeContent(cpi.getContent());
                String msgType = "text";
                String type = "num";
                String gettoken = null;
                try {
                    // gettoken = HttpTool.getToken(GETTOKENURL);
                    gettoken = HttpTool.sendGet(GETTOKENURL, PARAS);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    gLog.error("执行时间：" + String.valueOf(new Date()) + "考勤异常推送错误", e.toString());
                }
                JSONObject j = JSONObject.fromObject(gettoken);
                String token = j.getString("app_access_token");
                String url = POSTURL + token;
                //System.out.println(url);
                JSONObject jb = new JSONObject();
                jb.put("UserId", userid);
                jb.put("MsgType", msgType);
                jb.put("Content", content);
                jb.put("CreateTime", createTime);
                jb.put("Type", type);
                String mPostParas = "UserId=" + userid + "&MsgType=" + msgType + "&Content=" + content + "&CreateTime=" + createTime + "&Type=" + type;
                //System.out.println(jb.toString());
                String result = null;
                try {
                    //result = HttpTool.postString(url,jb.toString());
                    result = HttpTool.sendPost(url, mPostParas);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    gLog.error("执行时间：" + String.valueOf(new Date()) + "考勤异常推送错误", e.toString());
                }
                gLog.info(result);
            }
        } catch (Exception e) {
            gLog.error("执行时间：" + String.valueOf(new Date()) + "考勤异常推送错误", e.toString());
        }
        gLog.info("执行时间：" + String.valueOf(new Date()) + "考勤异常推送开始");

    }

    private List<ClockPushInfo> getClockPushInfoList() {
        List<ClockPushInfo> reList = new ArrayList<ClockPushInfo>();
        try {
            List<ClockPushInfo> mClockPushInfoList = gIClockPushMapper.getClockPushInfo();
            for (ClockPushInfo cpi : mClockPushInfoList) {
                if (cpi.getEmpno().matches("[1-9][0-9]{4}")) {
                    reList.add(cpi);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reList;
    }
}
