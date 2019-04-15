package com.liangxin.platform.common.tools;

import com.liangxin.platform.common.entity.KPI.TeamOverfulfillBonus;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019-2-15.
 */
public class SplitListByNum {
    public static <T> List<List<T>> splitList(List<T> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }

        List<List<T>> result = new ArrayList<List<T>>();


        int size = list.size();
        //根据每个list的上限计算list的个数
        int count = (size + len - 1) / len;


        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }

}
