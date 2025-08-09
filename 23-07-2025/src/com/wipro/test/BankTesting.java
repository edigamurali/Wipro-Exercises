package com.wipro.test;

import com.wipro.oop.CitiBank;
import com.wipro.oop.Hdfc;

public class BankTesting 
{
	public static void main(String[] args) 
	{
		Hdfc hdfc=new Hdfc();
		hdfc.deposit(2000.0,"HDFC1234456");
		hdfc.withdraw(1000.0,"HDFC1234456");
		CitiBank citibank=new CitiBank();
		citibank.deposit(100000.0,"CITI5676557");
		citibank.withdraw(1000.0,"CITI5676557" );
	}
}
