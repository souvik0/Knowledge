package com.chainofresponsibilitypattern;

import java.util.Scanner;

public class ATMDispenseChain {

    private DispenseChain chain;

    public ATMDispenseChain() {
       // initialize the chain
       this.chain = new Dollar50Dispenser();
       DispenseChain c2 = new Dollar20Dispenser();
       DispenseChain c3 = new Dollar10Dispenser();

       // set the chain of responsibility
       chain.setNextChain(c2);
       c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            try (Scanner input = new Scanner(System.in)) {
                 amount = input.nextInt();
            }
            // Validate the input
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
            }
            // process the request to invoke
            atmDispenser.chain.dispense(new Currency(amount));
        }
    }
}
