package com.liangxin.platform.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liangxin.platform.common.entity.advise.generate.pt.Menu;
import com.liangxin.platform.common.entity.advise.inputParam.menu.InputMenuForOAList;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.advise.outputResult.user.BaseOutUser;
import com.liangxin.platform.mapper.advise.IMenuMapper;
import com.liangxin.platform.mapper.advise.generate.pt.MenuMapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class MenuService {
    private final Logger gLog = LogManager.getLogger(MenuService.class);

    @Autowired
    private IMenuMapper gIMenuMapper;
    @Autowired
    private MenuMapper gMenuMapper;

    public OutResult getAll(InputMenuForOAList pInputMenuForOAList) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(pInputMenuForOAList.getCurrentPage(), pInputMenuForOAList.getPageSize(), true);
            List<Menu> mRvalue = gIMenuMapper.getAll(pInputMenuForOAList);
            PageInfo<Menu> pageInfo = new PageInfo<>(mRvalue);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(0);
            mOutResult.setData(pageInfo.getList());
            mOutResult.setMsg("成功！");
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult add(Menu pMenu) {
        OutResult mOutResult = new OutResult();
        try {
            pMenu.setId(String.valueOf(UUID.randomUUID()).replace("-", ""));
            if (gMenuMapper.insertSelective(pMenu) > 0) {
                mOutResult.setIsSuccess(true);
                mOutResult.setMsg("success");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("no row has effected.");
            }
            mOutResult.setCode(1);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult update(Menu pMenu) {
        OutResult mOutResult;
        if (pMenu.getDisable().equals(new BigDecimal("0"))) {
            mOutResult = updateToDisable(pMenu);
        } else {
            mOutResult = updateToUnDisable(pMenu);
        }
        return mOutResult;
    }

    public OutResult updateToUnDisable(Menu pMenu) {
        OutResult mOutResult = new OutResult();
        try {
            if (gIMenuMapper.isExistsTopDisable(pMenu.getId()) > 0) {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("The top tier has disable nodes");
            } else {
                if (gMenuMapper.updateByPrimaryKeySelective(pMenu) > 0) {
                    mOutResult.setIsSuccess(true);
                    mOutResult.setMsg("success");
                } else {
                    mOutResult.setIsSuccess(false);
                    mOutResult.setMsg("no row has effected.");
                }
            }
            mOutResult.setCode(1);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    @Transactional
    public OutResult updateToDisable(Menu pMenu) {
        OutResult mOutResult = new OutResult();
        try {
            if (gMenuMapper.updateByPrimaryKeySelective(pMenu) > 0) {
                gIMenuMapper.updateMenuNode(pMenu.getId(), new Integer(String.valueOf(pMenu.getDisable())), false);//update所有子节点
                mOutResult.setIsSuccess(true);
                mOutResult.setMsg("success");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("no row has effected.");
            }
            mOutResult.setCode(1);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult getById(String pId) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(1, 1);
            InputMenuForOAList mInputMenuForOAList = new InputMenuForOAList();
            mInputMenuForOAList.setId(pId);
            List<Menu> mRvalue = gIMenuMapper.getAll(mInputMenuForOAList);
            PageInfo<Menu> pageInfo = new PageInfo<>(mRvalue);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(0);
            mOutResult.setData(pageInfo.getList());
            mOutResult.setMsg("成功！");
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    @Transactional
    public OutResult delMenuNode(String pId) {
        OutResult mOutResult = new OutResult();
        try {
            gIMenuMapper.delRoleRelationToMenu(pId);//删除角色的关联

            if (gIMenuMapper.updateMenuNode(pId, 1, true) > 0) {
                mOutResult.setIsSuccess(true);
                mOutResult.setMsg("success");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("no row has effected.");
            }
            mOutResult.setCode(1);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult getAllByUser(HttpServletRequest pHttpServletRequest) {
        OutResult mOutResult = new OutResult();
        try {
            BaseOutUser mBaseOutUser=(BaseOutUser)pHttpServletRequest.getSession().getAttribute("userInfo");
            PageHelper.startPage(1, 9999);
            List<Menu> mRvalue = gIMenuMapper.getAllByUser(mBaseOutUser.getId());
            PageInfo<Menu> pageInfo = new PageInfo<>(mRvalue);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(0);
            mOutResult.setData(pageInfo.getList());
            mOutResult.setMsg("成功！");
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }
    public OutResult getAllConsistRole(String pRoleId) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(1, 9999);
            List<Menu> mRvalue = gIMenuMapper.getAllConsistRole(pRoleId);
            PageInfo<Menu> pageInfo = new PageInfo<>(mRvalue);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(0);
            mOutResult.setData(pageInfo.getList());
            mOutResult.setMsg("成功！");
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

}
