package com.chainofresponsibilityLogging;

public class ConsoleLogger implements Logger {

    Logger nextLogger;
    int level;

    @Override
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void logMessage(int logLevel, String message) {
        if (level <= logLevel){
            write(message);
        }
        if (nextLogger !=null){
            nextLogger.logMessage(logLevel, message);
        }
    }

    @Override
    public void write(String message) {
       System.out.println("Standard Console::Logger: " + message);
    }
}
