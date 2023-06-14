package com.chainofresponsibilityLogging;

public interface Logger {

    public void setNextLogger(Logger nextLogger);
    public void logMessage(int level, String message);
    public void write(String message);
}
