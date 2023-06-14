package com.chainofresponsibilitypattern;

public class Dollar50Dispenser implements DispenseChain{

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 50){
            int num = cur.getAmount()/50;
            int remainder = cur.getAmount() % 50;
            System.out.println("Dispensing "+ num +" 50$ note");
            // Here it is going to next dispenser
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else{ // Here also it is going to next dispenser if required
            this.chain.dispense(cur);
        }
    }
}
