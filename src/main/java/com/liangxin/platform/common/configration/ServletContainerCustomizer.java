package com.liangxin.platform.common.configration;

import org.apache.catalina.Context;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServletContainerCustomizer {
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                final int cacheSize = 40 * 1024;
                StandardRoot standardRoot = new StandardRoot(context);
                standardRoot.setCacheMaxSize(cacheSize);
                context.setResources(standardRoot); // This is what made it work in my case.

                logger.info(String.format("New cache size (KB): %d", context.getResources().getCacheMaxSize()));
            }
        };
        return tomcatFactory;
    }
}
