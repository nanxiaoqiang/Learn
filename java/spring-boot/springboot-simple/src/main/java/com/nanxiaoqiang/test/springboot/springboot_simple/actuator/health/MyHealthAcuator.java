package com.nanxiaoqiang.test.springboot.springboot_simple.actuator.health;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 在/health下添加一个自定义的key value
 * 
 * @author nanxiaoqiang
 * 
 * @version 2016年9月24日
 */
@Component
public class MyHealthAcuator implements HealthIndicator {
	private static Logger logger = LogManager.getLogger(MyHealthAcuator.class.getName());

	AtomicInteger errInt = new AtomicInteger(0);
	
	Lock lock = new ReentrantLock();  
	
	public MyHealthAcuator() {
		logger.info("MyHealthAcuator with errInt:" + errInt.get());
	}

	@Override
	public Health health() {
		try {
			lock.lock();
			logger.info("now errInt is:" + errInt.incrementAndGet());
			if (errInt.get() == 3) {// 当errInt的值是3的时候旧抛出异常
				errInt.set(0);
				throw new Exception("随意抛出来的异常 and errInt:" + errInt.get());
			}
			return Health.up().withDetail("自定义Key", "自定义Value").build();
		} catch (Exception e) {
			return Health.down(e).build();
		} finally {
			lock.unlock();
		}
	}

}
