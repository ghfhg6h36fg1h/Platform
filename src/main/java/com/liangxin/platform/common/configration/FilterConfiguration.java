package com.liangxin.platform.common.configration;

import com.liangxin.platform.common.projectFilter.ProjectFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Autowired
    private ProjectFilter gProjectFilter;

    @Bean
    public FilterRegistrationBean filterDemo4Registration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(gProjectFilter);
        //拦截规则
        registration.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        //registration.addInitParameter("exclusions","/index,*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");
        //过滤器名称
        registration.setName("ProjectFilter");
        //是否自动注册 false 取消Filter的自动注册
        //registration.setEnabled(false);
        //过滤器顺序
        registration.setOrder(1);
        return registration;
    }
}
