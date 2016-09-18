package com.nanxiaoqiang.test.springboot.springboot_simple.redis;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
	@Resource
	private StringRedisTemplate stringRedisTemplate;

	public RedisTest() {
	}
	
	@Test
	public void simpleTest() {
		stringRedisTemplate.opsForValue().set("key", "1985", 1, TimeUnit.DAYS);
		String s = stringRedisTemplate.opsForValue().get("key");
		Assert.isTrue(s.equals("1985"));
		stringRedisTemplate.opsForValue().increment("key", 1L);
		String s2 = stringRedisTemplate.opsForValue().get("key");
		Assert.isTrue(s2.equals("1986"));
	}

}
