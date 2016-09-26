package com.nanxiaoqiang.test.springcloud.spring_cloud_eureka_service.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/test")
@RestController
public class TestServiceController {

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	public TestServiceController() {
	}

	@RequestMapping(value = "/hello/{name}")
	public String hello(@PathVariable String name) {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/test/hello/" + name + ", host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
		return "Hello," + name;
	}

}
