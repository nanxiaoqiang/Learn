package com.nanxiaoqiang.test.springcloud.spring_cloud_ribbon_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon的例子
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonApp {
	
	/**
	 * 手动引入RestTemplate注册Bean，开启LoadBalance
	 * 
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonApp.class, args);
	}
}
