package com.wipro.oop;

public class CitiBank implements BanksOps
{
	@Override
	public void deposit(double amount, String accNumber) {
		System.out.println("depositing "+amount+" into Citi bank to account no "+accNumber);

	}

	@Override
	public void withdraw(double amount, String accNumber) 
	{
		System.out.println("withdrawing "+amount+" from Citi bank to account number "+accNumber);

	}	

}
