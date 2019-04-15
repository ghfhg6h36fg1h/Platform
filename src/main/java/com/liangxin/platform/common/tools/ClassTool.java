package com.liangxin.platform.common.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;


public class ClassTool {

    private final static Logger gLog = LoggerFactory.getLogger(ClassTool.class);

    /**
     * 动态调用类里的函数。
     *
     * @param fieldName
     * @param o
     * @return
     */
    public Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            gLog.error(e.getMessage(), e);
            return "{\"isSuccess\":\"false\",\"msg\":\"" + e.getMessage() + "\"}";
        }
    }
}
