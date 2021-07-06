package com.compositepattern;

public class FixedDepositAccount extends Account {

    public float accountBalance;

    public FixedDepositAccount(float accountBalance) {
        this.accountBalance = accountBalance;
	}

	@Override
    public float getBalance() {
        return accountBalance;
    }
}
