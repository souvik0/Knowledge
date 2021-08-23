package chainofresponsibilitypattern;

public class FiftyRupeeDispenser extends PaperCurrencyDispenser {

    public FiftyRupeeDispenser() {
    }

    @Override
    public void dispense(PaperCurrency currency) {
        if (currency != null) {
            int amount = currency.getAmount();
            int remainder = amount;
            if (amount >= 50) {
                int count = amount / 50;
                remainder = amount % 50;
                System.out.printf("Dispensing '%d' 50$ currency note.\n", count);
            }

            if (remainder > 0 && nextDispenser != null) {
                nextDispenser.dispense(new PaperCurrency(remainder));
            }
        }
    }
}
