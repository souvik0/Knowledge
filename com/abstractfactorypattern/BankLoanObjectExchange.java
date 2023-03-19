package com.abstractfactorypattern;

public class BankLoanObjectExchange {

    private BankLoanObjectExchange () {
    }

    //Here I am creating bankObject by passing loanType. Vice-versa can also be done
    public static Bank getLoanInterestRateFromBank (BankType bank, LoanType loan) {
         Bank bankObject = null;
         switch (loan) {
         case HOMELOAN:
             HomeLoanBankFactory homeLoanBankFactory = new HomeLoanBankFactory();
             bankObject = homeLoanBankFactory.getBank(bank);
             System.out.println(bankObject.getBankName());
             System.out.println(bankObject.loanAndBankWiseInterestRate());
             break;
         case PERSONALLOAN:
             PersonalLoanBankFactory personalLoanBankFactory = new PersonalLoanBankFactory();
             bankObject = personalLoanBankFactory.getBank(bank);
             System.out.println(bankObject.getBankName());
             System.out.println(bankObject.loanAndBankWiseInterestRate());
             break;
         case EDUCATIONALLOAN:
             EducationalLoanBankFactory educationalLoanBankFactory = new EducationalLoanBankFactory();
             bankObject = educationalLoanBankFactory.getBank(bank);
             System.out.println(bankObject.getBankName());
             System.out.println(bankObject.loanAndBankWiseInterestRate());
             break;
         }
         return bankObject;
    }
}
