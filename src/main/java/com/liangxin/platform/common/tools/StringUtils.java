package com.liangxin.platform.common.tools;

import java.math.BigDecimal;

public class StringUtils {
    public static boolean isNotEmpty(String str){

        if (str!=null && !"".equals(str) && str.length()>0 && !str.isEmpty()){
            return true;
        }
        return false;
    }

    //将秒转换为时间：如3600就是01:00
    public static String secondToTime(String second){
        if (StringUtils.isNotEmpty(second)){
            int s = Integer.parseInt(second);
            //int s1=s%60;
            int m=s/60;
            int m1=m%60;
            int h=m/60;
            //String a = (h>10?(h+""):("0"+h))+":"+(m1>10?(m1+""):("0"+m1))+":"+(s1>10?(s1+""):("0"+s1));//到秒
            String a = (h>=10?(h+""):("0"+h))+":"+(m1>=10?(m1+""):("0"+m1));//到分
            return a;
        }
        else{
            return "";
        }
    }

    //截取日期时间的日期
    public static String subKqDate(String kqdate){
        if(kqdate.length()>10){
            return kqdate.substring(0, 10);
        }
        else{
            return kqdate;
        }
    }

    //去掉数字后面的0
    public static String getPrettyNumber(String number) {
        String plainString = BigDecimal.valueOf(Double.parseDouble(number))
                .stripTrailingZeros().toPlainString();
        if(plainString.equals("0.0")){
            plainString = "0";
        }
        return plainString;
    }

    public static String mergeContent(String content){

        String rts = "您好！您有异常的考勤记录\r\n";
        String[] a =content.split(" ");
        for(String t:a)
        {
            String[] b = t.split(",");
            rts = rts + "日期："+ b[0] + "\r\n" +  "类型：" + b[1] + "\r\n";
        }
        rts = rts + "请及时处理！";
        //System.out.println(rts);
        return rts;

    }

}
