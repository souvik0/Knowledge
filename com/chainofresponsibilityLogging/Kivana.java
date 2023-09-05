package com.chainofresponsibilityLogging;

public class Kivana implements LogObserver{

    Logger logger;

    public void updateObserver() {
        System.out.println("Writting log data to Kivana");
    }

    public void setSubject(Logger logger) {
        this.logger = logger;
    }
}
