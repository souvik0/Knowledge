package chainofresponsibilitypattern;

public class Client {

    public static void main(String[] args) {
        int amount = 550;
        if (isValidAmount(amount)) {
            ATMWithdrawal.withdraw(new PaperCurrency(amount));
        }
    }

    private static boolean isValidAmount(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Try again!");
            return false;
        } else if (amount > 1000) {
            System.out.println("Daily withdrawal limit is 1000$. Try again!");
            return false;
        } else if (amount % 10 != 0) {
            System.out.println("Amount must be mutiple of 10s, Try again!");
            return false;
        }
        return true;
    }
}
