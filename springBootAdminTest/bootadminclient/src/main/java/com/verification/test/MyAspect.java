package com.verification.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    //중복을 해결해주는 아노테이션 - 포인트컷 지시자를 미리 설정해두는 것
//    @Pointcut("execution(* runSomething())")
    @Pointcut("execution(* com.verification.controller..*.*(..))")
    private void pointcut() {}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {

        System.out.println("열쇠로 문을 열고 집에 들어간다.");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {

        System.out.println("외출 시 문을 잠근다.");
    }

//    @Around("execution(* runSomething())")
    @Around("execution(* com.verification.controller..*.*(..))")
    public void around(ProceedingJoinPoint pjp) {
        //ProceedingJoinPoint: 핵심 기능을 호출하는 기능을 가지고 있음(around 사용 시 필수!)
        //before
        System.out.println("옷을 갈아입는다.");
        try {
            pjp.proceed(); //핵심 기능 호출 == (이전예제) delegate.factorial(20);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        //after
        System.out.println("씻는다.");
    }

    @AfterReturning("execution(* runSomething())")
    public void afterReturning(JoinPoint jp) {
        System.out.println("핵심기능 정상 종료: 하루를 반성");
    }

    @AfterThrowing("execution(* runSomething())")
    public void afterThrowing(JoinPoint jp) {
        System.out.println("119에 신고!");
    }

}
