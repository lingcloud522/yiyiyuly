package com.lingcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
public class TransactionTemplateConfig {


    @Autowired
    DataSource dataSource;
    @Bean
    public TransactionTemplate getTransactionTemplate(){
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.setIsolationLevel(4);
        transactionTemplate.setPropagationBehavior(2);
        return transactionTemplate;
    }

    @Bean
    public PlatformTransactionManager getTransactionManager(){
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName("com.mysql.jdbc.Driver");
        builder.url("jdbc:mysql://rm-bp18a3e9v6hjev0krio.mysql.rds.aliyuncs.com/content_platform_test");
        builder.username("testdb");
        builder.password("Su2h981!@#30Wish");
        builder.type(com.alibaba.druid.pool.DruidDataSource.class);
        return builder.build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }
}
