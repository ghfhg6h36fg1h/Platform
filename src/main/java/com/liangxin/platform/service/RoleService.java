package com.liangxin.platform.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liangxin.platform.common.entity.advise.generate.pt.Role;
import com.liangxin.platform.common.entity.advise.inputParam.role.RoleInput;
import com.liangxin.platform.common.entity.advise.inputParam.role.RoleMenuActionInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.advise.outputResult.user.BaseOutUser;
import com.liangxin.platform.mapper.advise.IRoleMapper;
import com.liangxin.platform.mapper.advise.generate.pt.RoleMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service
public class RoleService {
    private final Logger gLog = LogManager.getLogger(RoleService.class);

    @Autowired
    private IRoleMapper gIRoleMapper;
    @Autowired
    private RoleMapper gRoleMapper;

    public OutResult getAll(RoleInput pListInput) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(pListInput.getCurrentPage(), pListInput.getPageSize(), true);
            List<Role> mRvalue = gIRoleMapper.getAll(pListInput);
            PageInfo<Role> pageInfo = new PageInfo<>(mRvalue);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(1);
            mOutResult.setData(pageInfo.getList());
            mOutResult.setMsg("成功！");
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult add(Role pRole) {
        OutResult mOutResult = new OutResult();
        try {
            pRole.setId(String.valueOf(UUID.randomUUID()).replace("-", ""));
            if (gIRoleMapper.isExistsByName(pRole.getName()) == 0) {
                if (gRoleMapper.insertSelective(pRole) > 0) {
                    mOutResult.setIsSuccess(true);
                    mOutResult.setMsg("success");
                } else {
                    mOutResult.setIsSuccess(false);
                    mOutResult.setMsg("no role rows has add.");
                }
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("the role name was used,no row has added.");
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

    public OutResult update(Role pRole) {
        OutResult mOutResult = new OutResult();
        try {
            Role mRole = gRoleMapper.selectByPrimaryKey(pRole.getId());
            if (mRole != null) {
                if (mRole.getName().equals(pRole.getName())) {
                    commonUpdate(mOutResult, pRole);
                } else {
                    if (gIRoleMapper.isExistsByName(pRole.getName()) == 0) {
                        commonUpdate(mOutResult, pRole);
                    } else {
                        mOutResult.setIsSuccess(false);
                        mOutResult.setMsg("the role name was used,no row has updated.");
                    }
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
    public OutResult del(Role pRole) {
        OutResult mOutResult = new OutResult();
        try {
            gIRoleMapper.delMenuRelationToRole(pRole.getId());
            gIRoleMapper.delUserRelationToRole(pRole.getId());
            commonUpdate(mOutResult, pRole);
            mOutResult.setCode(1);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    private void commonUpdate(OutResult pOutResult, Role pRole) {
        if (gRoleMapper.updateByPrimaryKeySelective(pRole) > 0) {
            pOutResult.setIsSuccess(true);
            pOutResult.setMsg("success");
        } else {
            pOutResult.setIsSuccess(false);
            pOutResult.setMsg("no role rows has update.");
        }
    }


    public OutResult getById(String pId) {
        OutResult mOutResult = new OutResult();
        try {
            RoleInput mListInput = new RoleInput();
            mListInput.setId(pId);
            PageHelper.startPage(1, 1, true);
            List<Role> mRvalue = gIRoleMapper.getAll(mListInput);
            PageInfo<Role> pageInfo = new PageInfo<>(mRvalue);
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
    public OutResult addMenuAction(RoleMenuActionInput pRoleMenuActionInput) {
        OutResult mOutResult = new OutResult();
        try {
            gIRoleMapper.delMenuRelationToRole(pRoleMenuActionInput.getRoleId());
            gIRoleMapper.addMenuAction(pRoleMenuActionInput.getRoleId(), pRoleMenuActionInput.getMenuIdList());
            mOutResult.setCode(0);
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
