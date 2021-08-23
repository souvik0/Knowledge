package chainofresponsibilitypattern;

public class HundredRupeeDispenser extends PaperCurrencyDispenser {

    public HundredRupeeDispenser() {
    }

    @Override
    public void dispense(PaperCurrency currency) {
        if (currency != null) {
            int amount = currency.getAmount();
            int remainder = amount;
            if (amount >= 100) {
                int count = amount / 100;
                remainder = amount % 100;
                System.out.printf("Dispensing '%d' 100$ currency note.\n", count);
            }

            // Passsing on responsibilities to next object
            if (remainder > 0 && nextDispenser != null) {
                nextDispenser.dispense(new PaperCurrency(remainder));
            }
        }
    }
}
