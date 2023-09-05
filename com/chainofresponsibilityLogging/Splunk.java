package com.chainofresponsibilityLogging;

public class Splunk implements LogObserver {

    Logger logger;

    public void updateObserver() {
        System.out.println("Writting log data to Splunk");
    }

    public void setSubject(Logger logger) {
        this.logger = logger;
    }
}
