package com.liangxin.platform.webService;

import com.liangxin.platform.webService.advise.IProjectRecordWedService;

import com.liangxin.platform.webService.advise.IStrategyAccordWebService;
import com.liangxin.platform.webService.advise.ProjectRecordWedServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;


@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus; //必须有的

    @Autowired
    private IProjectRecordWedService gIProjectRecordWedService;

    @Bean
    public Endpoint projectRecordWedServiceEndpoint() {//发布gIProjectRecordWedService
        EndpointImpl projectRecordWedServiceEndpoint = new EndpointImpl(bus, gIProjectRecordWedService);
        projectRecordWedServiceEndpoint.publish("/outInterface/projectRecordWedService");
        return projectRecordWedServiceEndpoint;
    }

    @Autowired
    private IStrategyAccordWebService gIStrategyAccordWebService;

    @Bean
    public Endpoint strategyAccordWedServiceEndpoint() {//IStrategyAccordWebService
        EndpointImpl strategyAccordWedServiceEndpoint = new EndpointImpl(bus, gIStrategyAccordWebService);
        strategyAccordWedServiceEndpoint.publish("/outInterface/strategyAccordWedService");
        return strategyAccordWedServiceEndpoint;
    }
}
