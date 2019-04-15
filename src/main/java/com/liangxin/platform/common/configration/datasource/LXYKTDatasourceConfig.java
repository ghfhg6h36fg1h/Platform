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
@MapperScan(basePackages = "com.liangxin.platform.mapper.LXYKT", sqlSessionTemplateRef  = "LXYKTSqlSessionTemplate")
public class LXYKTDatasourceConfig {
    @Bean(name = "LXYKTDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.LXYKT")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "LXYKTSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("LXYKTDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "LXYKTTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("LXYKTDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "LXYKTSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("LXYKTSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
