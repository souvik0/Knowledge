package com.chainofresponsibilitypattern;

public class Dollar20Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextCurrency) {
        this.chain = nextCurrency;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 20){
            int num = currency.getAmount()/20;
            int remainder = currency.getAmount() % 20;
            System.out.println("Dispensing "+ num +" 20$ note");
            // Here it is going to next dispenser
            if (remainder != 0) {
                chain.dispense(new Currency(remainder));
            }
        } else{ // Here also it is going to next dispenser if required
                chain.dispense(currency);
        }
    }
}
