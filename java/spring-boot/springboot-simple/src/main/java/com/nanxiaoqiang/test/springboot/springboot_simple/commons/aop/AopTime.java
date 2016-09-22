package com.nanxiaoqiang.test.springboot.springboot_simple.commons.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP测试,记录方法执行时间
 * 
 * @author nanxiaoqiang
 * 
 * @version 2016年9月22日
 */
@Aspect
@Component
@Order(2)// 在都有@Aspect的AOP中，按照Order的顺序执行，在Before中，数字越小执行越靠前，After则反之。
public class AopTime {
	private static Logger logger = LogManager.getLogger(AopTime.class.getName());

	ThreadLocal<Long> methodStartTime = new ThreadLocal<>();

	@Pointcut("execution(public * com.nanxiaoqiang.test.springboot.springboot_simple.controller..*.*(..))")
	public void aopTime() {
	}

	@Before("aopTime()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		logger.info("开始计时");
		methodStartTime.set(System.currentTimeMillis());
	}
	
	@AfterReturning(returning = "object", pointcut="aopTime()")
	public void doAfterReturn(Object object) throws Throwable {
		logger.info("总共耗时 : " + (System.currentTimeMillis() - methodStartTime.get()));
	}

}
