package com.cy.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {

    @Around("execution(* com.cy.store.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
       //记录当前时间
        Long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        //后记录时间
        Long end = System.currentTimeMillis();
        System.out.println("当前耗时为："+(end-start));
        return result;
    }
}
