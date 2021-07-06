package com.chainofresponsibilitypattern;

public class ATMWithdrawal {

    public static PaperCurrencyDispenser dispenserChain;
    public static PaperCurrencyDispenser hundredDispenser = new HundredRupeeDispenser();
    public static PaperCurrencyDispenser fiftyDispenser = new FiftyRupeeDispenser();
    public static PaperCurrencyDispenser twentyDispenser = new TwentyRupeeDispenser();
    public static PaperCurrencyDispenser tenDispenser = new TenRupeeDispenser();

    // Creation of responsibility chain
    static {
        hundredDispenser.setNextDispenser(fiftyDispenser);
        fiftyDispenser.setNextDispenser(twentyDispenser);
        twentyDispenser.setNextDispenser(tenDispenser);
        dispenserChain = hundredDispenser;
    }

    public static void withdraw(PaperCurrency currency) {
        if (currency != null) {
           dispenserChain.dispense(currency);
        }
    }
}
