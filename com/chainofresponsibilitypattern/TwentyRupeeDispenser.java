package com.chainofresponsibilitypattern;

public class TwentyRupeeDispenser extends PaperCurrencyDispenser {

    public TwentyRupeeDispenser() {
    }

    @Override
    public void dispense(PaperCurrency currency) {
        if (currency != null) {
            int amount = currency.getAmount();
            int remainder = amount;
            if (amount >= 20) {
                int count = amount / 20;
                remainder = amount % 20;
                System.out.printf("Dispensing '%d' 20$ currency note.\n", count);
            }

            if (remainder > 0 && nextDispenser != null) {
                nextDispenser.dispense(new PaperCurrency(remainder));
            }
        }
    }
}
