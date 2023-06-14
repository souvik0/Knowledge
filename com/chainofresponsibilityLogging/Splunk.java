package com.chainofresponsibilityLogging;

public class Splunk implements LogObserver {

    public void updateObserver() {
        System.out.println("Writting log data to Splunk");
    }
}
