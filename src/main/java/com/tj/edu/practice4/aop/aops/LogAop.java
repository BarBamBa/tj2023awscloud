package com.tj.edu.practice4.aop.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    private void logPointCut() {}

    @Before("logPointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("LogAop의 before가 실행 됨.");
    }

    @After("logPointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("LogAop의 after가 실행 됨.");
    }
}
