package com.liangxin.platform.common.configration.datasource;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.liangxin.platform.mapper.KPI", sqlSessionTemplateRef  = "KPISqlSessionTemplate")
public class KPIDatasourceConfig {
    @Bean(name = "KPIDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.KPI")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "KPISqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("KPIDataSource") DataSource dataSource) throws Exception {
        //添加分页插件。
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("dialect", "sqlserver");
        pageHelper.setProperties(properties);

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPlugins(new Interceptor[]{pageHelper});
        return bean.getObject();
    }

    @Bean(name = "KPITransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("KPIDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "KPISqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("KPISqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
