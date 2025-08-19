package com.tourmgt.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfig {
	Logger logger = LoggerFactory.getLogger(AopConfig.class);

	@Pointcut(value = "execution (* com.tourmgt..*.*(..))")
	public void executeLog() {
	}

	@Before(value = "executeLog()")
	public void executeLogBefore(JoinPoint joinPoint) {
		this.logger.info("method started: " + joinPoint.getSignature().getName());
	}

	@After(value = "executeLog()")
	public void executeLogAfter(JoinPoint joinPoint) {
		this.logger.info("method ended: " + joinPoint.getSignature().getName());
	}
}
