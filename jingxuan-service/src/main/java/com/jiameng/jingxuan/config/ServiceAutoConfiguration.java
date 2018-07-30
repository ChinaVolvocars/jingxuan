package com.jiameng.jingxuan.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jiameng.jingxuan.service.IAdminService;
import com.jiameng.jingxuan.service.impl.AdminServiceImpl;




@Configuration
@EnableCaching
public class ServiceAutoConfiguration {
	@Bean
	@ConditionalOnMissingBean
	public IAdminService adminService() {
		return new AdminServiceImpl();
	}
}
