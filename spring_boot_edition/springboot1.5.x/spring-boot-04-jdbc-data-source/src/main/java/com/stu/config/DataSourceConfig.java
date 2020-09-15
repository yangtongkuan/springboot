package com.stu.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/1/2 15:09
 * @Classname: DataSourceConfig
 * @To change this template use File | Settings | File Templates.
 */
@Configuration
public class DataSourceConfig {


    //  必须使用@Primary 标注主数据源  否则报错
    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    // 副数据源
    @Bean(name = "secondlyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondly")
    public DataSource secondlyDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @param dataSource
     * @return
     * @desc 使用@Primary 表明当前库是主的template
     */
//    @Primary
    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    @Bean(name = "secondlyJdbcTemplate")
    public JdbcTemplate secondlyJdbcTemplate(@Qualifier("secondlyDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
