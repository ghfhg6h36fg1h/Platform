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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = {"com.liangxin.platform.mapper.advise", "com.liangxin.platform.mapper.advise.generate.pt","com.liangxin.platform.mapper.tax"}, sqlSessionTemplateRef = "adviseSqlSessionTemplate")
public class AdviseDatasourceConfig {
    @Bean(name = "adviseDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.advise")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "adviseSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("adviseDataSource") DataSource dataSource) throws Exception {

        //添加分页插件。sqlserver
        CommonConfig mCommonConfig=new CommonConfig();
        PageHelper pageHelper = mCommonConfig.pageHelper("sqlserver");
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPlugins(new Interceptor[]{pageHelper});
        return bean.getObject();
    }

    @Bean(name = "adviseTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("adviseDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "adviseSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("adviseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
