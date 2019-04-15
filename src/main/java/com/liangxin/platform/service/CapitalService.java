package com.liangxin.platform.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liangxin.platform.common.entity.advise.generate.pt.Capital;
import com.liangxin.platform.common.entity.advise.inputParam.capital.InputForOAList;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.advise.outputResult.capital.ListCapital;
import com.liangxin.platform.mapper.advise.ICapitalMapper;
import com.liangxin.platform.mapper.advise.generate.pt.CapitalMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class CapitalService {
    private final Logger gLog = LogManager.getLogger(CapitalService.class);
    @Autowired
    private ICapitalMapper gICapitalMapper;
    @Autowired
    private CapitalMapper gGenerateCapitalMapper;

    /**
     * 判断是否是班长方法
     *
     * @param pWorkId
     * @return
     */
    public OutResult isCapital(String pWorkId) {
        OutResult mOutResult = new OutResult();
        try {
            if (gICapitalMapper.isCapital(pWorkId) > 0) {
                mOutResult.setIsSuccess(true);
            } else {
                mOutResult.setIsSuccess(false);
            }
            mOutResult.setData(null);
            mOutResult.setCode(0);
            mOutResult.setMsg("success");
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * 查询班长列表
     *
     * @return
     */
    public OutResult getCapitalList() {
        OutResult mOutResult = new OutResult();
        try {
            List<ListCapital> mData = gICapitalMapper.getCapitalList();
            mOutResult.setData(mData);
            mOutResult.setTotalCount(mData.size());
            mOutResult.setIsSuccess(true);
            mOutResult.setMsg("success");
            mOutResult.setCode(0);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * 查询班长列表
     *
     * @return
     */
    public OutResult getCapitalListForOA(InputForOAList pInputForOAList) {
        OutResult mOutResult = new OutResult();
        try {
            Page mPage = PageHelper.startPage(pInputForOAList.getPageIndex(), pInputForOAList.getPageSize());
            List<ListCapital> mData = gICapitalMapper.getCapitalListForOA(pInputForOAList);
            mOutResult.setData(mData);
            mOutResult.setTotalCount(mPage.getTotal());
            mOutResult.setIsSuccess(true);
            mOutResult.setMsg("success");
            mOutResult.setCode(0);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult add(Capital pCapital) {
        OutResult mOutResult = new OutResult();
        try {
            pCapital.setId(String.valueOf(UUID.randomUUID()).replace("-", ""));
            if (gICapitalMapper.isCapital(pCapital.getWorkId()) == 0) {
                if (gGenerateCapitalMapper.insertSelective(pCapital) > 0) {
                    mOutResult.setIsSuccess(true);
                    mOutResult.setMsg("success");
                } else {
                    mOutResult.setIsSuccess(false);
                    mOutResult.setMsg("no rows has add.");
                }
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("the work ID was used,no row has added.");
            }
            mOutResult.setCode(0);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * @param pCapital
     * @return
     */
    public OutResult update(Capital pCapital) {
        OutResult mOutResult = new OutResult();
        try {
            if (gGenerateCapitalMapper.updateByPrimaryKeySelective(pCapital) > 0) {
                mOutResult.setIsSuccess(true);
                mOutResult.setMsg("success");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("no rows has add.");
            }
            mOutResult.setCode(0);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * @param pId
     * @return
     */
    public OutResult getById(String pId) {
        OutResult mOutResult = new OutResult();
        try {
            Capital mCapital = gGenerateCapitalMapper.selectByPrimaryKey(pId);
            mOutResult.setIsSuccess(true);
            List<Capital> mListCapital = new ArrayList<>();
            mListCapital.add(mCapital);
            mOutResult.setData(mListCapital);
            mOutResult.setMsg("success");
            mOutResult.setCode(0);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

  public Capital selectByPrimaryKey(Object id){
        return  gGenerateCapitalMapper.selectByPrimaryKey(id);
    }
}
