package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author: liuxl
 * @date: 2018-06-04 15:52
 * @description:
 */
@Aspect
public class AopTest {

    public static Logger logger = LoggerFactory.getLogger("commonlog");

    public static final String execution = "execution(* com.test.aop..*(..)))";
//    public static final String execution = "execution(public * *(..))";

    @Before(execution)//前置通知
    public void showBeginLog(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("{}.{}->入参: {} ",className, methodName, Arrays.toString(joinPoint.getArgs()));
    }

/*    @AfterReturning(value = execution, returning = "returnVal")
    public void afterReturin(JoinPoint joinPoint, Object returnVal) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("{}.{}()执行完毕, 返回值:{}" ,className,methodName, returnVal);
    }*/

    @AfterThrowing(throwing="e",pointcut=execution)
    public void doRecoveryActions(JoinPoint joinPoint,Throwable e){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.error("{}.{}()异常!",className,methodName, e);
    }

}