package com.wipro.annymousTest;

import com.wipro.anonymous.BankOps;

public class AnonymousDemo 
{
	public static void main(String[] args)
	{
		BankOps savingsAccount=new BankOps() {
			
			@Override
			public void deposit(double amount) {
				System.out.println(amount +" is depositing into savings account");
				
			}
		};
		savingsAccount.deposit(10000.0);
		BankOps currentAccount=new BankOps() {
			
			@Override
			public void deposit(double amount) {
				System.out.println(amount +" is depositing into current account");
				
			}
		};
		currentAccount.deposit(20000.0);
	}
}
