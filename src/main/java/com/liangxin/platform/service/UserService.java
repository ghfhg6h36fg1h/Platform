package com.liangxin.platform.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liangxin.platform.common.entity.advise.generate.pt.User;
import com.liangxin.platform.common.entity.advise.inputParam.user.BaseInput;
import com.liangxin.platform.common.entity.advise.inputParam.user.UserRoleInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.advise.outputResult.user.BaseOutUser;
import com.liangxin.platform.common.tools.MD5;
import com.liangxin.platform.mapper.advise.IMenuMapper;
import com.liangxin.platform.mapper.advise.IUserMapper;
import com.liangxin.platform.mapper.advise.generate.pt.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final Logger gLog = LogManager.getLogger(UserService.class);
    @Autowired
    private UserMapper gUserMapper;
    @Autowired
    private IUserMapper gIUserMapper;
    @Autowired
    private IMenuMapper gIMenuMapper;


    public OutResult addUser(User pUser) {
        OutResult mRValue = new OutResult();
        try {
            if (gIUserMapper.isExistsUser(pUser.getWorkId(), pUser.getMail(), pUser.getUserName(), pUser.getIdCard(), pUser.getPhone(), null) == 0) {
                String mConfirmation = pUser.getConfirmation();
                pUser.setId(String.valueOf(UUID.randomUUID()).replace("-", ""));
                pUser.setConfirmation(MD5.MD5Encode(mConfirmation));
                if (gUserMapper.insertSelective(pUser) > 0) {
                    mRValue.setIsSuccess(true);
                    mRValue.setMsg("成功");
                    mRValue.setCode(1);
                } else {
                    mRValue.setIsSuccess(false);
                    mRValue.setMsg("database has finished the executing , but no row has updated!");
                    mRValue.setCode(1);
                }
            } else {
                mRValue.setIsSuccess(false);
                mRValue.setMsg("the user is exists through identify the idCard or phone or MailSet or userName.");
                mRValue.setCode(1);
            }
        } catch (Exception ex) {
            mRValue.setIsSuccess(false);
            mRValue.setMsg(ex.getMessage());
            mRValue.setCode(0);
            gLog.error("增加用户出错！", ex);
        }
        return mRValue;
    }

    @Value("${myPrivilege}")
    private String gPrivilege;

    public OutResult loginCheck(String pUserName, String pConfirmation) {
        OutResult mRValue = new OutResult();
        try {


            try {
                String[] mStrPrivilege = gPrivilege.split(",");
                if (pUserName.equals(mStrPrivilege[0]) && pConfirmation.equals(mStrPrivilege[1])) {
                    List<BaseOutUser> mPrivilegeList = new ArrayList<>();
                    BaseOutUser mPrivilegeBaseOutUser=new BaseOutUser();
                    mPrivilegeList.add(mPrivilegeBaseOutUser);
                    mPrivilegeBaseOutUser.setId(pUserName);
                    mRValue.setCode(1);
                    mRValue.setData(mPrivilegeList);
                    mRValue.setIsSuccess(true);
                    return mRValue;
                }
            } catch (Exception ex) {
                gLog.error("myPrivilege,ERROR", ex);
            }


            if (!"NIL".equals(pUserName)) {
                BaseOutUser mBaseOutUser = gIUserMapper.getByWorkId(pUserName);
                if (null != mBaseOutUser) {
                    String mConfirmation = MD5.MD5Encode(pConfirmation.trim());
                    if (mConfirmation.equals(mBaseOutUser.getConfirmation().trim())) {
                        List<BaseOutUser> mListBaseOutUser = new ArrayList<>();
                        mListBaseOutUser.add(mBaseOutUser);
                        mRValue.setCode(1);
                        mRValue.setData(mListBaseOutUser);
                        mRValue.setIsSuccess(true);
                        mRValue.setMsg("password was pass!");
                    } else {
                        mRValue.setCode(1);
                        mRValue.setIsSuccess(false);
                        mRValue.setMsg("password was not pass!");
                    }
                } else {
                    mRValue.setCode(1);
                    mRValue.setIsSuccess(false);
                    mRValue.setMsg("this user is not registered!");
                }
            } else {
                mRValue.setCode(1);
                mRValue.setIsSuccess(false);
                mRValue.setMsg("password was not pass&username is nil!");
            }
        } catch (Exception ex) {
            mRValue.setCode(0);
            mRValue.setIsSuccess(false);
            mRValue.setMsg(ex.getMessage());
            gLog.error("登陆错误：", ex);
        }
        return mRValue;
    }


    public OutResult getUserList(BaseInput pBaseInput) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(pBaseInput.getCurrentPage(), pBaseInput.getPageSize(), true);
            List<BaseOutUser> mRvalue = gIUserMapper.getUserList(pBaseInput);
            PageInfo<BaseOutUser> pageInfo = new PageInfo<>(mRvalue);
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

    public OutResult update(User pUser) {
        OutResult mRValue = new OutResult();
        try {
            if (gIUserMapper.isExistsUser(pUser.getWorkId(), pUser.getMail(), pUser.getUserName(), pUser.getIdCard(), pUser.getPhone(), pUser.getId()) == 0) {
                if (pUser.getConfirmation() != null && pUser.getConfirmation() != "") {
                    String mConfirmation = pUser.getConfirmation();
                    pUser.setConfirmation(MD5.MD5Encode(mConfirmation));
                }
                commonUpdate(pUser, mRValue);
            } else {
                mRValue.setIsSuccess(false);
                mRValue.setMsg("the user is exists through identify the idCard or phone or MailSet or userName.");
                mRValue.setCode(1);
            }
        } catch (Exception ex) {
            mRValue.setIsSuccess(false);
            mRValue.setMsg(ex.getMessage());
            mRValue.setCode(0);
            gLog.error("更新用户出错！", ex);
        }
        return mRValue;
    }

    @Transactional
    public OutResult del(User pUser) {
        OutResult mRValue = new OutResult();
        try {
            if (pUser.getDeleteFlag().toString().equals("1")) {
                gIUserMapper.delRoleRelationToUser(pUser.getId());
            }
            commonUpdate(pUser, mRValue);
        } catch (Exception ex) {
            mRValue.setIsSuccess(false);
            mRValue.setMsg(ex.getMessage());
            mRValue.setCode(0);
            gLog.error("更新用户出错！", ex);
        }
        return mRValue;
    }

    private void commonUpdate(User pUser, OutResult pRValue) {
        if (gUserMapper.updateByPrimaryKeySelective(pUser) > 0) {
            pRValue.setIsSuccess(true);
            pRValue.setMsg("成功");
            pRValue.setCode(1);
        } else {
            pRValue.setIsSuccess(false);
            pRValue.setMsg("database has finished the executing , but no row has updated!");
            pRValue.setCode(1);
        }
    }

    public OutResult getById(String pId) {
        OutResult mOutResult = new OutResult();
        try {
            BaseInput mBaseInput = new BaseInput();
            mBaseInput.setId(pId);
            PageHelper.startPage(1, 1);
            List<BaseOutUser> mRvalue = gIUserMapper.getUserList(mBaseInput);
            PageInfo<BaseOutUser> pageInfo = new PageInfo<>(mRvalue);
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
    public OutResult addUserRole(UserRoleInput pRUserRoleInput) {
        OutResult mOutResult = new OutResult();
        try {

            gIUserMapper.delRoleRelationToUser(pRUserRoleInput.getUserId());
            gIUserMapper.addUserRole(pRUserRoleInput.getUserId(), pRUserRoleInput.getRoleIdList());
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

    public boolean urlActionRight(String pUserId, String pUrl) {
        boolean mOutResult = false;
        try {

            try {
                String[] mPrivilege=gPrivilege.split(",");
                if(pUserId.equals(mPrivilege[0])){
                    return true;
                }
            }catch (Exception ex){
                gLog.error("gPrivilege-urlActionRight-ERROR:",ex.getMessage());
            }

            //若无此路由对应则绕过验证。
            if (gIMenuMapper.isExistsByAction(pUrl) == 0) {
                return true;
            }

            if (gIUserMapper.urlActionRight(pUserId, pUrl) > 0) {
                mOutResult = true;
            }
        } catch (Exception ex) {
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }
}
