package com.example.TodoApiSpring;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void logTime(ProceedingJoinPoint p)  {
        long start=System.currentTimeMillis();

        try{
            p.proceed();
        }
        catch (Throwable e) {
            System.out.println("something went wrong");
        } finally {
            long end=System.currentTimeMillis();
            long totalT=end-start;
            System.out.println("total time taken by function "+totalT);
        }

    }
}
