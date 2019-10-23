package coderead.spring.myannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Description : TimeCount实现
 * @Author : Administrator
 * @Date :  2019 10 23 23:29
 **/
@Component
@Aspect
public class TimeCountAspectJ {
    @Around("@annotation(TimeCount)")
    public Object count(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("execution time : " + (System.nanoTime() - start));
        return  obj;
    }
}
