package compositepattern;

public class SavingsAccount extends Account {

    public float accountBalance;

    public SavingsAccount(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
	}
}
