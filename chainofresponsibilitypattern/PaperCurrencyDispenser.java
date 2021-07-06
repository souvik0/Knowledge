package com.chainofresponsibilitypattern;

public abstract class PaperCurrencyDispenser {

    public PaperCurrencyDispenser nextDispenser;

    public void setNextDispenser(PaperCurrencyDispenser nextDispenser) {
        this.nextDispenser = nextDispenser;
    }

    public abstract void dispense(PaperCurrency currency);
}
