package com.abstractfactorypattern;

public class HDFC extends Bank {

    public HDFC (LoanType loan) {
        super(loan);
	}

    public String getBankName () {
        return "HDFC Bank";
    }

    public String loanAndBankWiseInterestRate () {
        if (loan.toString().equalsIgnoreCase("HOMELOAN")) {
            return "8.5%" ;
        } else if (loan.toString().equalsIgnoreCase("PERSONALLOAN")) {
            return "12.5%";
        } else if (loan.toString().equalsIgnoreCase("EDUCATIONALLOAN")){
            return "10.5%";
        } else {
            System.out.println("No other loan type provided");
            return "None";
        }
    }
}
