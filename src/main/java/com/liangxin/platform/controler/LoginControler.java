package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

@Controller
public class LoginControler {
    private final Logger gLog = LogManager.getLogger(LoginControler.class);
    @Autowired
    private UserService gUserServcie;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadPage() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public OutResult login(HttpServletRequest request, String userName, String passWord) {
        OutResult mOutResult;
        HttpSession mSession = request.getSession();
        mOutResult = gUserServcie.loginCheck(userName, passWord);
        if (mOutResult.getIsSuccess()) {
            mSession.setAttribute("userInfo", mOutResult.getData().get(0));
            mSession.setMaxInactiveInterval(36000);
        }
        return mOutResult;
    }

    @ResponseBody
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public OutResult loginOut(HttpServletRequest request) {
        OutResult mOutResult = new OutResult();
        try {
            String mUsername="";
            HttpSession mSession = request.getSession();
            if (mSession.getAttribute("userInfo") != null) {
                mUsername=String.valueOf(mSession.getAttribute("userInfo"));
                mSession.removeAttribute("userInfo");
            }
            mOutResult.setIsSuccess(true);
            mOutResult.setCode(1);
            mOutResult.setMsg("成功");
            gLog.info(mUsername+":在，"+(new Date())+"，注销登陆！");
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg("失败！"+ex.getMessage());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/outInterface/login", method = RequestMethod.GET)
    public OutResult outInterfaceLogin(HttpServletRequest request, String userName, String passWard) {
        OutResult mOutResult = new OutResult();
        try {
            HttpSession mSession = request.getSession();
            UUID mUUID = UUID.randomUUID();
            if (mSession.getAttribute("userInfo") == null) {
                mSession.setAttribute("userInfo", String.valueOf(mUUID));
            } else {
            }
            mOutResult.setCode(1);
            mOutResult.setMsg("成功");
            gLog.info(userName + ":login!");
        } catch (Exception ex) {
            mOutResult.setCode(0);
            mOutResult.setMsg("失败！");
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }
}
