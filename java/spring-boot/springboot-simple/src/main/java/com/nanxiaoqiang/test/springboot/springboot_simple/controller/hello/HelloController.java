package com.nanxiaoqiang.test.springboot.springboot_simple.controller.hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping(value = "/sayHello/{name}")
	public String sayHello(@PathVariable String name) {
		return "Hello " + name;
	}
}
