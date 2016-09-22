package com.nanxiaoqiang.test.springboot.springboot_simple.commons.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * AOP输出方法耗时
 * @author nanxiaoqiang
 * 
 * @version 2016年9月22日
 */
@Aspect
@Component
@Order(1)
public class AopLogging {
	private static Logger logger = LogManager.getLogger(AopLogging.class.getName());

	@Pointcut("execution(public * com.nanxiaoqiang.test.springboot.springboot_simple.controller..*.*(..))")
	public void aopLogging() {
	}

	@Before("aopLogging()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(returning = "object", pointcut = "aopLogging()")
	public void doAfterReturn(Object object) throws Throwable {
		logger.info("RETURN : " + object);
	}
}
