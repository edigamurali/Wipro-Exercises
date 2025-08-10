package com.wipro.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AirTravelAspect {
	

	@Before("execution(* com.wipro.service..checkIn(..))")
	public void showPhotoIdbefore(JoinPoint jp)
	{
		System.out.println("PhotoId is showed");
	}
	@Before("execution(* com.wipro.service..do*(..))")
	public void showBoardingPass(JoinPoint jp)
	{
		System.out.println("I have Boarding pass");
	}
	@AfterThrowing(pointcut="execution(* com.wipro.service..checkIn(..))", throwing="ex")
	void NoSeatAvailable(JoinPoint jp,Throwable ex)
	{
		System.out.println("Call Airport Manager");
	}

}
