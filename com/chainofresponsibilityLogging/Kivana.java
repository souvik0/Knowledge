package com.chainofresponsibilityLogging;

public class Kivana implements LogObserver{

    public void updateObserver() {
        System.out.println("Writting log data to Kivana");
    }
}
