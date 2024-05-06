package com.assignment.tasktwo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogMethodParamAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogMethodParamAspect.class);

    @Before("@annotation(LogMethodParam)")
    public void logMethodParams(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        logger.info("Method called with parameters: {}", args);
    }
}
