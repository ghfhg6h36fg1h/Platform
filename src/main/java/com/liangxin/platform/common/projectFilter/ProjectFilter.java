package com.liangxin.platform.common.projectFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
@Component
public class ProjectFilter extends HttpServlet implements Filter {
    @Autowired
    private LoginFilter gLoginFilter ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("==>ProjectFilter启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //gLoginFilter=new LoginFilter();
        gLoginFilter.doLoginFilter(servletRequest,servletResponse,filterChain);
    }

    @Override
    public void destroy() {

    }
}
