package com.liangxin.platform.common.projectFilter;

import java.util.ArrayList;
import java.util.List;

//此类为配置忽略过滤的路由列表！
public class ExcludeFilterList {
    private List<String> gExludeList=new ArrayList<>() ;
    public ExcludeFilterList(){
        //gExludeList.add("/index");
        gExludeList.add("/login");
        gExludeList.add("/loginPage");
    }

    public List<String> getgExludeList() {
        return gExludeList;
    }

    public void setgExludeList(List<String> gExludeList) {
        this.gExludeList = gExludeList;
    }
}
