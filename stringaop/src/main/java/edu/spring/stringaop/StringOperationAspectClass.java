package edu.spring.stringaop;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class StringOperationAspectClass {
	
	ArrayList<ErrorReport> errorReport=App.errorReport;

	@AfterThrowing(pointcut = "execution(* StringOperations.*(..))", throwing= "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) throws Throwable{		
			errorReport.add(new ErrorReport(joinPoint.getSignature().getName(), error.getClass().toString()));
	}
	
	@Around("execution(* StringOperations.*(..))")
	public void measureTimeToExecute(ProceedingJoinPoint jointPoint) throws Throwable{
		long startTime=System.currentTimeMillis();
		jointPoint.proceed();
		long endTime=System.currentTimeMillis();
		System.out.println("Time to Execute "+jointPoint.getSignature().getName()+": "+(endTime-startTime)+" ms");
	}
}
