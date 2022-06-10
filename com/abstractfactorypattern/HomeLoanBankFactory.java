package com.abstractfactorypattern;

public class HomeLoanBankFactory implements Loan {

    public Bank getBank (BankType bankName) {
        Bank bank = null;
        switch (bankName) {
        case HDFC :
            bank = new HDFC(LoanType.HOMELOAN);
            break;
        case ICICI :
            bank = new ICICI(LoanType.HOMELOAN);
            break;
        case AXIS :
            bank = new Axis(LoanType.HOMELOAN);
            break;
        default:
            break;
        }
		return bank;
    }

}
