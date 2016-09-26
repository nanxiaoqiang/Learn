package com.nanxiaoqiang.test.springcloud.spring_cloud_eureka_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!服务
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class TestServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(TestServiceApp.class, args);
	}
}
