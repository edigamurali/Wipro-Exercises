package com.wipro.AOPProject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.exception.NoSeatAvailableException;
import com.wipro.service.AirTravelProcess;

public class App 
{
    public static void main( String[] args )
    {
       AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
       ctx.scan("com.wipro.*");
       ctx.refresh();
       AirTravelProcess air=ctx.getBean(AirTravelProcess.class);
       try {
		air.checkIn(false);
		air.collectBoardingPass();
		air.doSecurityCheck();
		air.doBoarding();
	} catch (NoSeatAvailableException e) {
		System.out.println(e.getMessage());
	}
    }
}
