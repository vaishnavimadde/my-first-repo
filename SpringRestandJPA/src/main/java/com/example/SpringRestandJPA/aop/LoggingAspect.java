package com.example.SpringRestandJPA.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.SpringRestandJPA.service.JobService.*(..))")
    public void loggingbefore(JoinPoint jp)
    {
        System.out.println(jp.getSignature().getName() + " method wil be called");
    }

    @After("execution(* com.example.SpringRestandJPA.service.JobService.*(..))")
    public void loggingafter(JoinPoint jp)
    {
        System.out.println(jp.getSignature().getName() + " method has been called");
    }
}
