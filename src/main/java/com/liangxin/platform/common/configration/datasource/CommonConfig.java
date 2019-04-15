package com.liangxin.platform.common.configration.datasource;

import com.github.pagehelper.PageHelper;

import java.util.Properties;

public class CommonConfig {
    public PageHelper pageHelper(String pSqlType){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("dialect", pSqlType);
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
