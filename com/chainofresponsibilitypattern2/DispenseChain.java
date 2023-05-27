package com.chainofresponsibilitypattern2;

public interface DispenseChain {

    public void setNextChain(DispenseChain nextChain);
    public void dispense(Currency cur);
}
