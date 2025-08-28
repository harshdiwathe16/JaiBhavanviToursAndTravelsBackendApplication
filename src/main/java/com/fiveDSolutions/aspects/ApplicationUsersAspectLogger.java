package com.fiveDSolutions.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

/**
 * File Name: StudentLoggerAspect.java
 * Entity: StudentLoggerAspect
 * Package: com.pranay.StudentSelfReflection.aspects
 * Author: pranayramteke
 * Date: 20/06/25
 * Description:
 */

@Aspect
@Component
public class ApplicationUsersAspectLogger
{
	// createStudent(int id, String name)
	// deleteStudent(int id);
	@Around("execution(* com.fiveDSolutions.JaiBhavaniToursAndTravels.service.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Instant startTime = Instant.now();
		System.out.println(joinPoint.getSignature().getName() + " method started at : " + startTime);
		
		Object response = joinPoint.proceed();
		
		// TimeStamp After The Actual Operation
		Instant endTime = Instant.now();
		System.out.println( joinPoint.getSignature().getName() +  " method finished at : " + endTime);
		System.out.println( joinPoint.getSignature().getName()  + " method time elapsed : " + Duration.between(startTime, endTime));
		
		return response;
	}
}