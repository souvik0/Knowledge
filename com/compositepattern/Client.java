package com.compositepattern;

public class Client {

	public static void main ( String[] args) {
        Account savingsAccounts = new SavingsAccount(0);
        Account depositAccounts = new DepositAccount();

        depositAccounts.addAccount(new FixedDepositAccount(200));
        depositAccounts.addAccount(new RecurringDepositAccount(100));

        float totalBalance = savingsAccounts.getBalance() + depositAccounts.getBalance();
        System.out.println("Total Balance : " +totalBalance);
    }
}
