package com.compositepattern;

public class CompositeAccount extends Account {

    public float totalBalance = 0;

    @Override
    public float getBalance() {
        for (Account account : allAccounts) {
            totalBalance = totalBalance + account.getBalance();
        }
        return totalBalance;
    }
}
