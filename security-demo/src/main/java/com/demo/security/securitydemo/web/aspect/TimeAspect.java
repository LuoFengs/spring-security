package com.demo.security.securitydemo.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : luofeng
 * @date : Created in 2019/2/28 14:25
 * @description :
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.demo.security.securitydemo.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint point) throws Throwable {

        System.out.println("time aspect start ");

        Object[] args = point.getArgs();
        for(Object obj : args){
            System.out.println("arg is :"+obj);
        }
        long time = new Date().getTime();
        Object proceed = point.proceed();
        System.out.println("time aspect 耗时:"+(new Date().getTime() - time));
        System.out.println("time aspect end ");
        return proceed;

    }

}
