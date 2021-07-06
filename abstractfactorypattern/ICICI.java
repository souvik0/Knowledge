package com.abstractfactorypattern;

public class ICICI extends Bank {

	public ICICI (LoanType loan) {
        super(loan);
	}

    public String getBankName () {
        return "ICICI Bank";
    }

    public String loanAndBankWiseInterestRate () {
        if (loan.toString().equalsIgnoreCase("HOMELOAN")) {
            return "9.0%" ;
        } else if (loan.toString().equalsIgnoreCase("PERSONALLOAN")) {
            return "13.5%";
        } else if (loan.toString().equalsIgnoreCase("EDUCATIONALLOAN")){
            return "10.0%";
        } else {
            System.out.println("No other loan type provided");
            return "None";
        }
    }
}
