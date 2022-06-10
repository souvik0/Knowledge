package com.abstractfactorypattern;

public enum LoanType {
    HOMELOAN ("HOMELOAN"), 
    PERSONALLOAN ("PERSONALLOAN"), 
    EDUCATIONALLOAN ("EDUCATIONALLOAN");

    private final String loanType;

    LoanType(String loanType) {
        this.loanType = loanType;
	}

    public String toString () {
        return loanType;
    }
}
