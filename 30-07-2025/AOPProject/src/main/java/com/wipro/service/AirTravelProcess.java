package com.wipro.service;

import org.springframework.stereotype.Component;

import com.wipro.exception.NoSeatAvailableException;

@Component
public class AirTravelProcess {
	
	public void checkIn(Boolean flag) throws NoSeatAvailableException
	{
		if(flag==true)
		{
			System.out.println("----CheckIn Process Completed----");
		}
		else {
			throw new NoSeatAvailableException("no seat is available");
		}
	}
	public void collectBoardingPass()
	{
		System.out.println("---- Boarding pass Collected ----");
	}
	public void doSecurityCheck()
	{
		System.out.println("---- Security check done ----");
	}
	public void doBoarding()
	{
		System.out.println("--- Bording done -----");
	}
}
