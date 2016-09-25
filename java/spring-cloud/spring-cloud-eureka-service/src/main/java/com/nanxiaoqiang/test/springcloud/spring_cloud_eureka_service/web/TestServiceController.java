package com.nanxiaoqiang.test.springcloud.spring_cloud_eureka_service.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/test")
@RestController
public class TestServiceController {

	public TestServiceController() {
	}
	
	@RequestMapping(value = "/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello," + name;
	}

}
