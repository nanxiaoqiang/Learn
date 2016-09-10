package com.nanxiaoqiang.test.springboot.springboot_simple.jdbc;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nanxiaoqiang.test.springboot.springboot_simple.App;
import com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jdbc.User;
import com.nanxiaoqiang.test.springboot.springboot_simple.service.jdbc.JdbcTemplateService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class JdbcTemplateTest {
	@Resource
	private JdbcTemplateService service;
	
	@Before
	public void setUp() {
		// 可以写个方法清空数据库里的数据
		int count = service.removeAll();
		System.out.println(count);
	}
	
	@Test
	public void test() {
		// 插入用户
		service.saveUser(new User("test1", "rmark1"));
		service.saveUser(new User("test2", "rmark2"));
		service.saveUser(new User("test3", "rmark3"));
		service.saveUser(new User("test4", "rmark4"));
		
		Assert.assertEquals(4, service.getAllUser().size());// 应该插入了四条数据
		
		service.deleteByName("test3");
		
		Assert.assertEquals(3, service.getAllUser().size());// 应该只剩下三条数据
		
		
	}
}
