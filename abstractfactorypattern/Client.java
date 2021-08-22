package abstractfactorypattern;

public class Client {

    public static void main (String[] args) {
        BankLoanObjectExchange.getLoanInterestRateFromBank(BankType.HDFC, LoanType.HOMELOAN);
        BankLoanObjectExchange.getLoanInterestRateFromBank(BankType.ICICI, LoanType.PERSONALLOAN);
        BankLoanObjectExchange.getLoanInterestRateFromBank(BankType.AXIS, LoanType.EDUCATIONALLOAN);
    }
}
