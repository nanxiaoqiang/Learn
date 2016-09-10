package com.nanxiaoqiang.test.springboot.springboot_simple.controller.jdbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jdbc.User;
import com.nanxiaoqiang.test.springboot.springboot_simple.service.jdbc.JdbcTemplateService;

@RequestMapping(value = "/jdbc")
@RestController
public class JdbcTemplateController {

	@Resource
	private JdbcTemplateService service;

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public User create() {
		User user = new User();
		user.setName("nanxiaoqiang");
		user.setRemark("only for Test");
		int count = service.saveUser(user);
		user.setId(Long.valueOf(count));
		return user;
	}

	@ResponseBody
	@RequestMapping(value = "get_all_user", method = RequestMethod.GET)
	public List<User> getAllUser() {
		return service.getAllUser();
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getById(@PathVariable Long id) {
		return service.findById(id);
	}

}
