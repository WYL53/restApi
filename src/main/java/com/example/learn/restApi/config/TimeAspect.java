package com.example.learn.restApi.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    @Around("execution(public * com.example.learn.restApi.user.controller.*(..))")
    public void excuTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objs = joinPoint.getArgs();
        for (Object o : objs) {
            System.out.println(o);
        }
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        System.out.println("timeAspect time:"+(System.currentTimeMillis()-start));
    }
}
