package com.chainofresponsibilityLogging;

public interface Logger {

    // Chain of responsibility pattern
    public void setNextLogger(Logger nextLogger);
    public void logMessage(int level, String message);

    // Observer pattern
    public void write(String message);
}
