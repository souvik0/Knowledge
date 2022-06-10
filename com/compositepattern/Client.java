package com.compositepattern;

public class Client {

	public static void main ( String[] args) {
        Account savingsAccounts = new CompositeAccount();
        Account depositAccounts = new DepositAccount();
        
        depositAccounts.addAccount(new FixedDepositAccount(200));
        depositAccounts.addAccount(new RecurringDepositAccount(100));

        savingsAccounts.addAccount(new SavingsAccount(200));
        savingsAccounts.addAccount(new SavingsAccount(300));
        //allAccounts.addAccount(depositAccounts);
       

        float totalBalance = savingsAccounts.getBalance() + depositAccounts.getBalance();
        System.out.println("Total Balance : " +totalBalance);
    }
}
