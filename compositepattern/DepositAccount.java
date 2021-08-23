package compositepattern;

public class DepositAccount extends Account {

    public float totalBalance = 0;

    @Override
    public float getBalance() {
        for (Account account : allAccounts) {
            totalBalance = totalBalance + account.getBalance();
        }
        return totalBalance;
    }
}
