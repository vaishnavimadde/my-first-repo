package com.example.SpringRestandJPA.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class  ValidationApsect {

    @Around("execution(* com.example.SpringRestandJPA.service.JobService.*(..)) && args(postId)")
    public Object validateinp(ProceedingJoinPoint jp, int postId) throws Throwable {
        if(postId<0)
        {
            postId=-postId;
            System.out.println("PostId was negative made it positive");
        }
        Object obj=jp.proceed(new Object[]{postId});
        return obj;
    }
}
