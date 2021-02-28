package com.fen.fou.aopStu.jdk;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class JdkAspect {
  @Pointcut("execution(* com.fen.fou.aopStu.jdk.Say.sayHello(..))")
  private void cut() {
  }
  @Before("cut()")
  public void advice(JoinPoint joinPoint) throws Throwable{
    Object[] args = joinPoint.getArgs();
    for(Object obj : args){
      System.out.println("------before------args----"+obj);
    }
    System.out.println("------before------");
  }
  @AfterReturning(pointcut = "cut()", returning = "retValue")
  public void doAfterReturning(JoinPoint joinPoint, Object retValue)
  {
    Object[] args = joinPoint.getArgs();
    for(Object obj : args){
      System.out.println("------AfterReturning------args----"+obj);
    }
    System.out.println("------AfterReturning------"+retValue);
  }
  @AfterThrowing(pointcut = "cut()")
  public void doAfterThrowing()
  {
    System.out.println("------AfterThrowing------");
  }

  @After("cut()")
  public void doAfter(){
    System.out.println("------after------");
  }

  @Around("cut()")
  public void doAround(ProceedingJoinPoint process) throws Throwable {
    System.out.println("------Around before------");
    process.proceed();
    System.out.println("------Around after------");
  }
}
