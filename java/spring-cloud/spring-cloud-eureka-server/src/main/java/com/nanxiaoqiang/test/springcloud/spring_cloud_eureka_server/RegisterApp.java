package com.nanxiaoqiang.test.springcloud.spring_cloud_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!注册中心
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterApp {
	public static void main(String[] args) {
		SpringApplication.run(RegisterApp.class, args);
	}
}
