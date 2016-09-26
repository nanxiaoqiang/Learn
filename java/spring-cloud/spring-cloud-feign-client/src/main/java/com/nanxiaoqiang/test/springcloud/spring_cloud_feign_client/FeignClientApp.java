package com.nanxiaoqiang.test.springcloud.spring_cloud_feign_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign:通过暴露接口的方式调用(类似与阿里dubbo，京东jsf)并且会自动LoadBalance
 * 
 * @author nanxiaoqiang
 * 
 * @version 2016年9月26日
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignClientApp {
	public static void main(String[] args) {
		SpringApplication.run(FeignClientApp.class, args);
	}
}
