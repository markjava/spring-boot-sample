package com.boot.sample.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * mybatis配置
 * @author xu.yong
 *
 */
@Configuration
@PropertySources(value={@PropertySource("classpath:jdbc.properties")})
@MapperScan(basePackages = "com.boot.sample.mapper", sqlSessionTemplateRef = "secretKeySqlSessionTemplate")
@EntityScan("com.boot.sample.entity")
public class SecretKeySourceConfig {
	
	@Primary
	@Bean("secretKeyDataSource")
	@ConfigurationProperties(prefix="spring.datasource.secretkey_service")
	public DataSource secretKeyDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		return dataSource;
	}
	
	@Primary
	@Bean(name = "secretKeySqlSessionFactory")
	public SqlSessionFactory secretKeySqlSessionFactory(@Qualifier("secretKeyDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/*Mapper.xml"));
		return bean.getObject();
	}
	
	@Primary
	@Bean(name = "secretKeySqlSessionTemplate")
	public SqlSessionTemplate secretKeySqlSessionTemplate(@Qualifier("secretKeySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Primary
	@Bean
	public PlatformTransactionManager memberTransactionManager() {
		return new DataSourceTransactionManager(secretKeyDataSource());
	}

}
