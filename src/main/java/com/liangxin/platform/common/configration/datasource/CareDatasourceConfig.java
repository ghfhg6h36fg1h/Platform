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
@MapperScan(basePackages = "com.liangxin.platform.mapper.care", sqlSessionTemplateRef  = "careSqlSessionTemplate")
public class CareDatasourceConfig {
    @Bean(name = "careDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.care")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "careSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("careDataSource") DataSource dataSource) throws Exception {

        //添加分页插件。
        CommonConfig mCommonConfig=new CommonConfig();
        PageHelper pageHelper = mCommonConfig.pageHelper("sqlserver");
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPlugins(new Interceptor[]{pageHelper});
        return bean.getObject();

    }

    @Bean(name = "careTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("careDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "careSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("careSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
