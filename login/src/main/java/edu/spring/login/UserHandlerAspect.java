package edu.spring.login;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class UserHandlerAspect {

	UserHandler userHandle=new UserHandler();
	public static HashMap<String, Long> userLoggedInTime=new HashMap<String, Long>();
	
	@Around("execution(* UserHandler.login(..))")
	public Object verifiedLogin(ProceedingJoinPoint joinPoint) throws Throwable{
		Object args[]=(Object[])joinPoint.getArgs();
		int res=-1;
		if(args[0].toString().length()<3){
			System.out.println("Username should be of atleast 3 Characters.");
		}
		else{
			 res=(Integer)joinPoint.proceed();
			if(res==1)
			{
				userLoggedInTime.put(args[0].toString(), System.currentTimeMillis());
				System.out.println("login Successful!");
			}
			else if(res==-1)
				System.out.println("login Unsuccessful!");
			else if(res==0){
				System.out.println("User already Logged In!");
			}
		}
		return res;
	}
	
	
	
	@Around("execution(* UserHandler.register(..))")
	public Object verifiedRegistration(ProceedingJoinPoint joinPoint) throws Throwable{
		Object args[]=(Object[])joinPoint.getArgs();
		boolean res=false;
		
		if(args[1].toString().length()<3 || args[2].toString().length()<3){
			System.out.println("Username and Password should be of atleast 3 Characters.");
		}
		else{
			res=(Boolean)joinPoint.proceed();
			if(res)
				System.out.println("Registration Successful!");
			else
				System.out.println("Registration Unsuccessful!");
		}
		
		return res;
	}
	
	
	@Around("execution(* UserHandler.logout(..))")
	public Object verifiedLogout(ProceedingJoinPoint joinPoint) throws Throwable{
		Object args[]=(Object[])joinPoint.getArgs();
		boolean res=false;
		
		if(args[0].toString().length()<3){
			System.out.println("Logout Unsuccessful! Username  should be of atleast 3 Characters.");
		}
		else{
			res=(Boolean)joinPoint.proceed();
			if(res)
			{
				long startTime=userLoggedInTime.get(args[0].toString());
				long endTime=System.currentTimeMillis();
				userLoggedInTime.remove(args[0].toString());
				System.out.println("Logged Time: "+(endTime-startTime)/1000+" sec");
				System.out.println("Logout Successful!");
			}
			else
				System.out.println("Incorrect Username!");
		}
		
		return res;
	}
	
	
	
	
}
