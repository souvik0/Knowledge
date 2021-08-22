package abstractfactorypattern;

public class EducationalLoanBankFactory implements Loan {

	public Bank getBank (BankType bankName) {
        Bank bank = null;
        switch (bankName) {
        case HDFC :
            bank = new HDFC (LoanType.EDUCATIONALLOAN);
            break;
        case ICICI :
            bank = new ICICI (LoanType.EDUCATIONALLOAN);
            break;
        case AXIS :
            bank = new Axis (LoanType.EDUCATIONALLOAN);
            break;
        default:
            break;
        }
        return bank;
    }
}
