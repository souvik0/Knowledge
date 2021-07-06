package com.abstractfactorypattern;

// Interface shouldn't have any constructor, but exchange object method here is getBnak
public interface Loan {
    public Bank getBank (BankType bankType);
}
