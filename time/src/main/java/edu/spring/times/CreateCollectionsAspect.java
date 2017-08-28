package edu.spring.times;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CreateCollectionsAspect {

	@Around("execution(* CreateCollections.*(..))")
	public void measureTimeToExecute(ProceedingJoinPoint jointPoint) throws Throwable{
		long startTime=System.currentTimeMillis();
		jointPoint.proceed();
		long endTime=System.currentTimeMillis();
		System.out.println("Time to Execute"+jointPoint.getSignature().getName()+": "+(endTime-startTime)+" ms");
	}
	
	
}
