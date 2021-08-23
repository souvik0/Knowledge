package abstractfactorypattern;

public class Axis extends Bank {

    public Axis (LoanType loan) {
        super(loan);
	}

    public String getBankName () {
        return "AXIS Bank";
    }

    public String loanAndBankWiseInterestRate () {
        if (loan.toString().equalsIgnoreCase("HOMELOAN")) {
            return "8.5%" ;
        } else if (loan.toString().equalsIgnoreCase("PERSONALLOAN")) {
            return "13.5%";
        } else if (loan.toString().equalsIgnoreCase("EDUCATIONALLOAN")){
            return "10.0%";
        } else {
            System.out.println("No other loan type available");
            return "None";
        }
    }

}
