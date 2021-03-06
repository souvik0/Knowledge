package com.chainofresponsibilitypattern;

public class TenRupeeDispenser extends PaperCurrencyDispenser {

    public TenRupeeDispenser() {
    }

    @Override
    public void dispense(PaperCurrency currency) {
        if (currency != null) {
            int amount = currency.getAmount();
            int remainder = amount;
            if (amount >= 10) {
                int count = amount / 10;
                remainder = amount % 10;
                System.out.printf("Dispensing '%d' 10$ currency note.\n", count);
            }

            if (remainder > 0 && nextDispenser != null) {
                nextDispenser.dispense(new PaperCurrency(remainder));
            }
        }
    }
}
