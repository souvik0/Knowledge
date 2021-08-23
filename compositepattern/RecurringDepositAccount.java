package compositepattern;

public class RecurringDepositAccount extends Account {

    public float accountBalance;

    public RecurringDepositAccount(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }
}
