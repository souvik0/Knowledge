package com.designATM;

public class CashWithdrawProcessor {

    CashWithdrawProcessor nextCashWithdrawalProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;
    }

    public void withdraw(ATM atm, int remainingAmount) {
        if (nextCashWithdrawalProcessor != null) {
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
        }
    }
}
