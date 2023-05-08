package com.nikita.multithreading.resource;


public class Account {
	int accountBalance;
	public Account(int accountBalance)
	{
		super();
		this.accountBalance=accountBalance;
		
	}
	public void checkBalance()
	{
		System.out.println("Current balance:"+accountBalance);
	}
	public void depositeAmount(int amount)
	{
		System.out.println("Depositing "+amount+"rs in account");
		accountBalance+=amount;
		checkBalance();
	}
	public void withdrawAmount(int amount)
	{
		System.out.println("Trying to withdraw"+amount+"rs from account ");
	
	if(amount>accountBalance)
	{
		System.out.println("INSUFFICIENT BALANCE...");
	}
	else
	{
		accountBalance-=amount;
		checkBalance();
	}
	}
}
