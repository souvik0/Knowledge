package abstractfactorypattern;

public abstract class Bank {

    public LoanType loan = null;

    // Constructor used for exchanging of Objects
    public Bank (LoanType loan) {
        this.loan = loan;
    }

    public abstract String getBankName ();
    public abstract String loanAndBankWiseInterestRate ();
}
