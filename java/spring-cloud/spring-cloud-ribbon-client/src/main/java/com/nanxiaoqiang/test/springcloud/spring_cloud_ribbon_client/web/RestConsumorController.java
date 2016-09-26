package com.nanxiaoqiang.test.springcloud.spring_cloud_ribbon_client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/test")
public class RestConsumorController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/get_hello/{name}")
	public String getHelloServer(@PathVariable(value = "name") String name) {
		return restTemplate.getForEntity("http://spring-cloud-eureka-service/test/hello/" + name, String.class).getBody();
	}
}
