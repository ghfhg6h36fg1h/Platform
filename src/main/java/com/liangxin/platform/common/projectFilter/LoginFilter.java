package com.liangxin.platform.common.projectFilter;

import com.liangxin.platform.common.entity.advise.outputResult.user.BaseOutUser;
import com.liangxin.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginFilter {
    @Autowired
    private UserService mUserService;

    public void doLoginFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将请求转换成HttpServletRequest 请求
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String route = req.getRequestURI();
        ExcludeFilterList mExcludeFilterList = new ExcludeFilterList();
        //不过滤路由判断
        boolean mIsFilter = true;
        for (String fRoute : mExcludeFilterList.getgExludeList()) {
            if (route.equals(fRoute) || route.contains("/outInterface") || route.contains(".js")
                    || route.contains(".css") || route.contains(".jpg")) {
                mIsFilter = false;
                break;
            }
        }
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String path = req.getContextPath();
        String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path;
        HttpSession session = req.getSession(true);
        BaseOutUser mBaseOutUser = (BaseOutUser) session.getAttribute("userInfo");
        //Authorization
        boolean mIsAuthorization = true;
        if (mIsFilter && mBaseOutUser != null) {
            String mRefererUrl = req.getHeader("referer");
            if (mRefererUrl != null && mRefererUrl.contains(".html")) {
                mRefererUrl = mRefererUrl.substring(mRefererUrl.lastIndexOf("/") + 1, mRefererUrl.length());
                mIsAuthorization = mUserService.urlActionRight(mBaseOutUser.getId(), mRefererUrl);
                if (!mIsAuthorization) {
                    resp.setHeader("loginStatus", "unLogin");
                    resp.sendError(0, "未授权！");
                }
            }
        }
        if (mIsAuthorization) {
            if ((mBaseOutUser == null) && mIsFilter) {
                resp.setHeader("Cache-Control", "no-store");
                resp.setDateHeader("Expires", 0);
                resp.setHeader("Para", "no-cache");
                resp.setHeader("Access-Control-Allow-Origin", "*");
                resp.setHeader("loginStatus", "unLogin");
                //此处设置了访问静态资源类
                if (!route.contains("/outInterface")) {
                    getRedirect(resp, basePath);
                } else {
                    resp.sendError(0, "未登陆！");
                }
            } else {
                // Filter 只是链式处理，请求依然转发到目的地址。
                filterChain.doFilter(req, resp);
            }
        }
    }


    private void getRedirect(HttpServletResponse response, String pBaseUrl)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script language='javascript'>");
        out.println("top.location.href='" + pBaseUrl + "/loginPage'");
        out.println("</script>");
        out.flush();
        out.close();
        out = null;
    }
}
