package com.nanxiaoqiang.test.springboot.springboot_simple.jpa;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.nanxiaoqiang.test.springboot.springboot_simple.dao.jpa.JpaUserRepository;
import com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jpa.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaRedisCacheTest {
	@Resource
	private JpaUserRepository jpaUserRepository;
	
	@Resource
	private RedisCacheManager redisCacheManager;

	@Test
	public void Test() {

		// 创建记录
		User user = jpaUserRepository.save(new User("Cached", "CacheRemark"));
		Assert.notNull(user.getId());
		user.setName("CachedChanged");
		user = jpaUserRepository.save(user);
		User userCached = jpaUserRepository.findByName(user.getName());
		Assert.isTrue(userCached.getId().equals(user.getId()));
		jpaUserRepository.delete(user.getId());
		User userDel = jpaUserRepository.findById(user.getId());
		Assert.isTrue(userDel == null);
	}

}
