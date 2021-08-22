package abstractfactorypattern;

public class PersonalLoanBankFactory implements Loan {

    public Bank getBank (BankType bankName) {
        Bank bank = null;
        switch (bankName) {
        case HDFC :
            bank = new HDFC (LoanType.PERSONALLOAN);
            break;
        case ICICI :
            bank = new ICICI (LoanType.PERSONALLOAN);
            break;
        case AXIS :
            bank = new Axis (LoanType.PERSONALLOAN);
            break;
        default:
            break;
        }
        return bank;
    }
}
