package com.wipro.oop;

public class Hdfc implements BanksOps {

	@Override
	public void deposit(double amount, String accNumber) {
		System.out.println("depositing "+amount+" into Hdfc bank to account no "+accNumber);

	}

	@Override
	public void withdraw(double amount, String accNumber) {
		System.out.println("withdrawing "+amount+" from Hdfc bank to account number "+accNumber);

	}
	

}
