package com.ozerutkualtun.ct.customer_tracker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger

    Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

    // set up pointcut declarations

    @Pointcut("execution(* com.ozerutkualtun.ct.customer_tracker.controller.*.*(..))")
    private void forControllerPackage() {};

    @Pointcut("execution(* com.ozerutkualtun.ct.customer_tracker.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.ozerutkualtun.ct.customer_tracker.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forDaoPackage() || forControllerPackage() || forServicePackage()")
    private void forAppFlow() {}

    // add @Before advice

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        logger.info(">>>>>>>> in @Before: from METHOD: " + joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();

        for(Object arg: args) {
            logger.info(">>>>>>>> Argument: " + arg);
        }
     }


    // add @AfterReturning advice

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info(">>>>>>>> in @AfterReturning from METHOD: " + joinPoint.getSignature().toShortString());

        logger.info(">>>>>>>> Result: " + result);
    }

}
