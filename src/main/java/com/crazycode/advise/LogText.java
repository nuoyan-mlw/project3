/*
package com.crazycode.advise;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogText {

    */
/*配置全局切入点,方法名就是切入点名字*//*

    @Pointcut("execution(* com.crazycode.web.controller..*.*(..))")
    public void p1() {

    }
    //说明,此方法的名字就是切入点名字,和返回类型,访问修饰符等都无关,关注的是方法名
    @Before("p1()")
    public void logBefore() {
        System.out.println("开始日志记录....");
    }

    @AfterReturning("p1()")
    public void logAfterReturning() {
        System.out.println("日志记录完毕....");
    }

    @AfterThrowing("p1()")
    public void logAfterThrowing() {
        System.out.println("日志记录异常信息....");
    }

    @After("p1()")
    public void logAfterAfter() {
        System.out.println("释放日志资源....");
    }
}
*/
