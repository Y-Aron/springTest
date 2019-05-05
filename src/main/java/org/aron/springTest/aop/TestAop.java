package org.aron.springTest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: Y-Aron
 * @create: 2019-04-20 22:39
 */
@Aspect
@Slf4j
@Component
public class TestAop {
    @Pointcut(value = "execution(* org.aron.springTest.bean.User.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("---------- 前置通知开始 ----------");
        // 获取拦截对象
        Signature signature = joinPoint.getSignature();
        log.info("拦截的目标类: {}", signature.getDeclaringTypeName());
        log.info("拦截的方法名称: {}", signature.getName());
        log.info("输入的参数: {}", Arrays.asList(joinPoint.getArgs()));
        log.info("---------- 前置通知结束 ----------");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("---------- 环绕通知开始 ----------");
        Signature signature = pjp.getSignature();
        log.info("拦截的目标类: {}", signature.getDeclaringType());
        log.info("拦截的方法名称: {}", signature.getName());
        log.info("输入的参数: {}", Arrays.asList(pjp.getArgs()));
        Object proceed = pjp.proceed();
        log.info("拦截的方法的返回值: {}", proceed);
        log.info("---------- 环绕通知结束! ----------");
        return proceed;
    }

    @AfterReturning(pointcut = "pointcut()", returning = "val")
    public void afterReturning(JoinPoint joinPoint, Object val) {
        log.info("---------- 后置通知(如果出现异常不会调用)开始 ----------");
        log.info("{}", joinPoint);
        log.info("拦截的方法的返回值: {}", val);
        log.info("---------- 后置通知(如果出现异常不会调用)结束! ----------");
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterException(JoinPoint joinPoint, Exception e) {
        log.info("---------- 异常通知开始 ----------");
        log.info("{}", joinPoint);
        log.info("异常信息: {}", e.getMessage());
        log.info("---------- 异常通知结束! ----------");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        log.info("---------- 后置通知(如果出现异常也会调用)开始 ----------");
        Signature signature = joinPoint.getSignature();
        log.info("拦截的目标类: {}", signature.getDeclaringTypeName());
        log.info("拦截的方法名称: {}", signature.getName());
        log.info("输入的参数: {}", Arrays.asList(joinPoint.getArgs()));
        log.info("---------- 后置通知(如果出现异常也会调用)结束! ----------");
    }
}
