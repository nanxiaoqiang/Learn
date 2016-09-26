package com.nanxiaoqiang.test.springcloud.spring_cloud_feign_client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanxiaoqiang.test.springcloud.spring_cloud_feign_client.service.TestService;

@RestController
@RequestMapping(value = "/test")
public class TestClientController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/say_to/{name}")
	public String sayHelloTo(@PathVariable String name) {
		return testService.hello(name);
	}
}
