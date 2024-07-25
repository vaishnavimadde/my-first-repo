package com.example.SpringRestandJPA.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @Around("execution(* com.example.SpringRestandJPA.service.JobService.*(..))")
    public Object timemonitor(ProceedingJoinPoint jp) throws Throwable {
        long start= System.currentTimeMillis();
        Object obj=jp.proceed();
        long end=System.currentTimeMillis();
        System.out.println("Time required:" + (end-start)+ " ms");
        return obj;
    }
}
