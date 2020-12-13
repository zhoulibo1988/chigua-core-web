package com.chigua;

import com.chigua.core.swagger.SwaggerProperties;
import com.chigua.core.tool.props.ChiGuaProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Mr.zhou
 * @date 2020-07-17
 */
//事务开启支持
@EnableTransactionManagement
@SpringBootApplication
//开启缓存
@EnableCaching
@MapperScan(basePackages = {"com.chigua.core.service.*.mapper"})
@EnableConfigurationProperties({ChiGuaProperties.class, SwaggerProperties.class})
public class SpringbootStudyMycatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudyMycatApplication.class, args);
	}

}
