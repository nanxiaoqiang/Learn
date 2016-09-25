package com.nanxiaoqiang.test.springcloud.spring_cloud_eureka_server.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class HelloController {

	public HelloController() {
	}

	@RequestMapping(value = "/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello, " + name;
	}
}
