package com.nanxiaoqiang.test.springboot.springboot_simple.jpa;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nanxiaoqiang.test.springboot.springboot_simple.App;
import com.nanxiaoqiang.test.springboot.springboot_simple.dao.jpa.JpaUserRepository;
import com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jpa.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class JpaTest {
	
	@Resource
	private JpaUserRepository jpaUserRepository;

	@Test
	public void test() {
		// 先查查数据库里有多少条
		long old_count = jpaUserRepository.findAll().size();
		
		// 创建记录
		jpaUserRepository.save(new User("JpaA", "JpaRemarkA"));
		jpaUserRepository.save(new User("JpaB", "JpaRemarkB"));
		jpaUserRepository.save(new User("JpaC", "JpaRemarkC"));
		jpaUserRepository.save(new User("JpaD", "JpaRemarkD"));
		jpaUserRepository.save(new User("JpaE", "JpaRemarkE"));
		
		// 查看当前的条数
		Assert.assertEquals(old_count + 5, jpaUserRepository.findAll().size());
		
		Assert.assertEquals("JpaA", jpaUserRepository.findByNameIgnoreCase("jpaa").getName());
		
		// 删除
		jpaUserRepository.delete(jpaUserRepository.findByNameIgnoreCase("jpab"));
		
		// 查看删除后的条数
		Assert.assertEquals(old_count + 4, jpaUserRepository.findAll().size());
		
	}

}
