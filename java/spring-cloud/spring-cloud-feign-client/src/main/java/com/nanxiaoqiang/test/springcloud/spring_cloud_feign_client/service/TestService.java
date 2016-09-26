package com.nanxiaoqiang.test.springcloud.spring_cloud_feign_client.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "spring-cloud-eureka-service")
public interface TestService {

	@RequestMapping(value = "/test/hello/{name}")
	String hello(@PathVariable(value = "name") String name);
}
